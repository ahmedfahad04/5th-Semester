import numpy as np 
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

data = pd.read_csv('UCI Dataset/ballons.csv')
target = data.columns[-1]


def prior_probability(df, target):
      
    rows = len(df)
    values = df[target].value_counts()
    prior = []

    for i in values:
        prob = i/rows
        prior.append(prob)
        
    return prior     

def naive_bayes_classifer(df, X_test, Y_test): 
    
    feature_prob_given_true = []
    feature_prob_given_false = []
    
    features = df.columns[:-1]              # all features except target
    rows = len(df[Y_test])
    class_count = df[Y_test].value_counts() # count of each class
    class_value = df[Y_test].unique()       # ['T', 'F']

    for feature in features:
        distinct = df[feature].unique()     # ['YELLOW', 'RED', 'GREEN']
        
        for f_value in distinct:            # 'YELLOW'
            feature_value_true = 0
            feature_value_false = 0
            
            for i in range(len(df)):        # for each row
                if df[Y_test][i] == class_value[0] and df[feature][i] == f_value:    # if target is true
                    feature_value_true+=1
                elif df[Y_test][i] == class_value[1] and df[feature][i] == f_value:    # if target is false
                    feature_value_false+=1
                                
            feature_prob_given_true.append({f_value: feature_value_true/class_count['T']})
            feature_prob_given_false.append({f_value: feature_value_false/class_count['F']})
    
    # print(feature_prob_given_true)
    # print(feature_prob_given_false)
    
    posterior_T = 1
    posterior_F = 1
    for i in range(len(X_test)):                # here, multiple instance of feature will be given, not one [fix it]
        x = X_test[i]
        
        for f_val in feature_prob_given_true:   # f_val = {'YELLOW': 0.5, 'RED': 0.5, 'GREEN': 0.0}
            for key, value in f_val.items():    # key = 'YELLOW
                if x == key:                    # if x = 'YELLOW'
                    posterior_T *= value        # P(YELLOW|T) = 0.5, P(LARGE|T) = 0.5, P(STRETCH|T) = 0.5, P(ADULT|T) = 0.5
        
        for f_val in feature_prob_given_false:  # f_val = {'YELLOW': 0.5, 'RED': 0.5, 'GREEN': 0.0}
            for key, value in f_val.items():    # key = 'YELLOW
                if x == key:                    # if x = 'YELLOW'
                    posterior_F *= value        # P(YELLOW|F) = 0.5, P(LARGE|F) = 0.5, P(STRETCH|F) = 0.5, P(ADULT|F) = 0.5
            
    # print(posterior_F, posterior_T)
    
    posterior_T *= prior_probability(data, Y_test)[0]  # P(T|YELLOW, LARGE, STRETCH, ADULT) = P(YELLOW|T) * P(LARGE|T) * P(STRETCH|T) * P(ADULT|T) * P(T)
    posterior_F *= prior_probability(data, Y_test)[1]  # P(F|YELLOW, LARGE, STRETCH, ADULT) = P(YELLOW|F) * P(LARGE|F) * P(STRETCH|F) * P(ADULT|F) * P(F)
    
    # print(posterior_T, posterior_F)
    
    return  posterior_T > posterior_F        # return True if P(T|YELLOW, LARGE, STRETCH, ADULT) > P(F|YELLOW, LARGE, STRETCH, ADULT)


m = naive_bayes_classifer(df=data, X_test=['YELLOW', 'LARGE', 'STRETCH', 'CHILD'], Y_test=target)
print(m)
