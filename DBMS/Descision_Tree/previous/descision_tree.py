import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import math
from bigtree import Node, print_tree, tree_to_dot
from PIL import Image

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


def getInformationGain(data, feature, target, value_checked):
    distinct_values = sorted(data[feature].unique())
    target_values = data[target].unique()

    target_value_cnt = {}
    total_entropy_cnt = {}
    entropy = []
    all_specified_rows = []
    true_false = {}
    true = false = 0
    dist_value_cnt = len(distinct_values)
    
    
    for val in target_values:                           # true/false => initialize the dict
        target_value_cnt[val] = 0
        total_entropy_cnt[val] = 0

    for value in distinct_values:                       # Sunny/Overcast/Rain
        
        if value in value_checked:
            dist_value_cnt -= 1
            continue
        
        true = false = 0
        true_false[value] = 0
        specified_rows = []
        
        
        for val in target_values:                       # initialize the dict
            target_value_cnt[val] = 0
            
        for row in range(len(data)):
            if data[feature][row] == value:             # if the row value is Sunny/Overcast/Rain
                # specified_rows.append(row)
                for t_value in target_values:
                    if data[target][row] == t_value:    # if the target value is No/Yes
                        target_value_cnt[t_value] += 1
                        if t_value == 'Yes': true += 1
                        else: false += 1
                        
        true_false[value] = [true, false]
        # all_specified_rows.append(specified_rows)
                    
        entropy.append(getEntropy(target_value_cnt))
        print("Entropy of ", value, " = ", getEntropy(target_value_cnt))
        print()
                  
             
    for row in range(len(data)):                        # calculate total entropy 
        for t_value in target_values:
            if data[target][row] == t_value:    # if the target value is No/Yes
                total_entropy_cnt[t_value] += 1
    
    totalEntropy = getEntropy(total_entropy_cnt)
    gain = 0
    x = sorted(data[feature].value_counts())

    
    for i in range(dist_value_cnt):                     # calculate average gain
        # print(x[i], sum(total_entropy_cnt.values()),": ", entropy[i])
        gain += (x[i]/sum(total_entropy_cnt.values()))*entropy[i]
    
    gain = totalEntropy-gain
    print("Gain of ", feature, " = ", round(gain, 4), '\n---')
    
    return round(gain, 4), true_false 
      

def discisionTreeClassifier(df, X_test, Y_test):

    features = df.columns[:-1]              # all features except Class
    feature_search_done = []
    root = None 
        
    for turns in range(len(features)):
        
        informationGain = dict()
        purity = dict()
        maxGainRowList = []
        maxGainAttribute = None
        maxGain = 0
        
            
        for val in features: 
            informationGain[val] = 0
        
        for feature in features:                # Outlook,Temp,Humidity,Wind
            
            search_rows = []
            gain, purity = getInformationGain(df, feature, target, feature_search_done)
            informationGain[feature] = gain 
            if gain > maxGain:
                maxGain = gain
                maxGainAttribute = feature 
                maxGainPurity = purity          # means how many true and false it has
        
        for attribute in maxGainPurity:
            attr_purity = maxGainPurity[attribute]
            check_purity = any(val == 0 for val in attr_purity)
            
            if check_purity == True: 
                feature_search_done.append(attribute)
            
        
        # visualize the tree
        # if root == None:
        #     root = Node(maxGainAttribute)
            
        # for value in maxGainPurity:
        #     val = str(maxGainPurity[value])
        #     Node(str(value+" "+val), parent=root)
            
        # graph = tree_to_dot(root, node_colour="green")
        # graph.write_png("tree.png")
        # img = Image.open("tree.png")
        # img.show()

        print(maxGainAttribute, ": ", maxGain, "--", maxGainPurity, '\n ===== ')
                

m = discisionTreeClassifier(df=data, X_test=['Rain', 'Mild', 'Normal', 'Weak'], Y_test=target)
