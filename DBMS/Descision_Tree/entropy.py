import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import math

data = pd.read_csv('Descision_Tree/weather.csv')
target = data.columns[-1]


def getEntropy(target_value_freq:dict):

    totalInstance = sum(target_value_freq.values())
    keys = target_value_freq.keys()

    entropy = 0
    for key in keys:
        if target_value_freq[key] == 0: 
            entropy = 0
            break 
            
        entropy += -(target_value_freq[key]/totalInstance *
                     math.log2(target_value_freq[key]/totalInstance))

    return round(entropy, 3)


def getInformationGain(data, feature, target):
    distinct_values = sorted(data[feature].unique())
    target_values = data[target].unique()

    target_value_cnt = {}
    total_entropy_cnt = {}
    entropy = []
    
    for val in target_values:
        target_value_cnt[val] = 0
        total_entropy_cnt[val] = 0

    for value in distinct_values:
        for val in target_values:                       # initialize the dict
            target_value_cnt[val] = 0
            

        for row in range(len(data)):
            if data[feature][row] == value:             # if the row value is Sunny/Overcast/Rain
                for t_value in target_values:
                    if data[target][row] == t_value:    # if the target value is No/Yes
                        target_value_cnt[t_value] += 1
                    
        entropy.append(getEntropy(target_value_cnt))
        # print("Entropy of ", value, " = ", getEntropy(target_value_cnt))
        # print()
                    
    for row in range(len(data)):
        for t_value in target_values:
            if data[target][row] == t_value:    # if the target value is No/Yes
                total_entropy_cnt[t_value] += 1
    
    totalEntropy = getEntropy(total_entropy_cnt)
    gain = 0
    x = sorted(data[feature].value_counts())
    
    for i in range(len(distinct_values)):
        # print(x[i], sum(total_entropy_cnt.values()),": ", entropy[i])
        gain += (x[i]/sum(total_entropy_cnt.values()))*entropy[i]
    
    gain = totalEntropy-gain
    # print("Gain of ", feature, " = ", round(gain, 4))
    
    return round(gain, 4)


def discisionTreeClassifier(df, X_test, Y_test):

    features = df.columns[:-1]              # all features except feature

    informationGain = dict()
    for val in features: informationGain[val] = 0
    

    for feature in features:                # Outlook,Temp,Humidity,Wind
        informationGain[feature] = getInformationGain(df, feature, target)
        
    


m = discisionTreeClassifier(
    df=data, X_test=['Rain', 'Mild', 'Normal', 'Weak'], Y_test=target)
