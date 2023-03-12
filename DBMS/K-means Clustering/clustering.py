import pprint as p
import numpy as np 
import pandas as pd
from matplotlib import pyplot as plt 

class K_Means:
    
    def __init__(self, n_cluster=2, X=None) -> None:
        self.k = n_cluster
        self.X = X 
        self.labels_ = None
        self.centroids_ = None 
    
    def calculate_distance(self, point1, point2):
        x1 = point1[0]
        y1 = point1[1]
        x2 = point2[0]
        y2 = point2[1]
        
        return np.sqrt((x1-x2)**2 + (y1-y2)**2)
    
    def calculate_median(self, clusters):
         
        # variables
        data_points = [[] for i in range(self.k)]
        
        # separate each cluster
        for i in range(len(clusters)):
            id = clusters[i]
            data_points[id].append(self.X[i])
            
        # find the median of each cluster
        return [np.median(cluster, axis=0) for cluster in data_points]
                
    def predict(self, data):
        
        result = []
        
        for point in data:
            distance = []
            
            for centroid in self.centroids_:
                distance.append(self.calculate_distance(point, centroid))
                
            result.append(distance.index(min(distance)))
            
        return result
            
    def fit(self):
        
        # clusters
        clusters = []
        
        # randomly select k points as the initial centroids
        centroids = self.X[np.random.choice(self.X.shape[0], self.k, replace=False)]
        print("Initial centroids: ", centroids)
        
        while 1:
                            
            # calculate the distance between each point and the centroids
            for point in self.X:
                distance = []
                
                for centroid in centroids:
                    distance.append(self.calculate_distance(point, centroid))
                    
                clusters.append(distance.index(min(distance)))
                
            # calculate the median of each cluster
            new_centroids = self.calculate_median(clusters)
            
            # check for next iteration
            if np.array_equal(centroids, new_centroids):
                self.labels_ = clusters
                self.centroids_ = centroids
                return 
            
            else: 
                centroids = new_centroids
                clusters = []
        
if __name__ == '__main__':
    
    # read data from csv file
    data = pd.read_csv('data2.csv')
    df = data.iloc[:, :]
    df = np.array(df)
    
    # define variable
    var1 = 'Age'
    var2 = 'Income($)'
    
    # plot the data (before clustering)
    plt.scatter(data[var1], data[var2])
    plt.show()
    
    # apply the K-Means algorithm
    kmeans = K_Means(3, df)
    kmeans.fit()
    p.pprint(kmeans.predict([[1.2, 2.5]]))
    p.pprint(kmeans.labels_)
    p.pprint(kmeans.centroids_)
    
    # plot the data (after clustering)
    data['cluster'] = kmeans.labels_
    df1 = data[data.cluster == 0]
    df2 = data[data.cluster == 1]
    df3 = data[data.cluster == 2]

    plt.scatter(df1[var1], df1[var2], color='green')    
    plt.scatter(df2[var1], df2[var2], color='blue')    
    plt.scatter(df3[var1], df3[var2], color='red')    
    
    plt.xlabel(var1)
    plt.ylabel(var2)
    plt.show()