##### Capstone: Analyzing (Social) Network Data (Skaldin Ruslan) <br />


###### Overview

In this capstone project I developed software that detects communities in given graph dataset. A community, with respect to graphs, can be defined as a subset of nodes that are densely connected to each other and loosely connected to the nodes in the other communities in the same graph.

###### Data

**Real data provided by the Network Repository.** <br />
A graph and network repository containing hundreds of real-world networks and benchmark datasets. This large comprehensive collection of graphs are useful in machine learning and network science.<br />
This particular dataset is the best for testing because the dataset contains a lot of communities and was designed for testing Communities detecting algorithms.
* http://networkrepository.com/soc.php

**Stanford Large Network Dataset Collection.** <br />
This dataset consists of 'circles' (or 'friends lists') from Facebook. Facebook data was collected from survey participants using this Facebook app. The dataset includes node features (profiles), circles, and ego networks.<br />
This dataset is not designed for testing Communities detection algorithms, thereby for getting visible results program must load large amount of vertices
* https://snap.stanford.edu/data/
 

###### Question

Easier: How are people being connected with people belonging to the same social circles?<br />
Harder: How to find a set of people that belongs to the same community in the graph?

 

###### Algorithms, Data Structures, and Answer to your Question

Connections between people have been laid out as a classic graph using an adjacency list. Each individual person in the graph is a vertex and an edge between vertices represents a friendship or their connection.

The program divided into three main parts:
- 1 - Input data and form graph
- 2 - Process data and detect communities
- 3 - Output data in both ways text (to console) and visually (render graph image) 
 
The main algorithm for detecting communities in graph was selected Label Propagation Algorithm.
This algorithm iteratively assigns a label to each node. The label of a node is set to the most frequent label among its neighbors. If there are multiple candidates the algorithm randomly chooses one of them. After applying the algorithm, all nodes with the same label belong to the same community.

The result of the algorithm has generated subsets of communities, this information program prints in terminal. Then this information passes to another algorithm that generates random colors for each community and renders an image.

On the generated image we can see the loaded graph and detected communities colored in different colors.

The result with 200 vertices will generate this graph: <br />
![alt text](https://github.com/RussellSk/social_network_capstone/blob/master/graph.png?raw=true)

###### Algorithm analysis

It takes a near-linear time for the algorithm to run to its completion. Initializing every node with unique labels requires O(n) time. Each iteration of the label propagation algorithm takes linear time in the number of edges (O(m)). At each node x, we first group the neighbors according to their labels (O(dx)). We then pick the group of maximum size and assign its label to x, requiring a worst-case time of O(dx). This process is repeated at all nodes and hence an overall time is O(m) for each iteration.

But there is limitation in process of finding communities in graph. During recent years, a rather surprising result has been obtained by various groups which shows that a phase transition exists in the community detection problem, showing that as the density of connections inside communities and between communities become more and more equal or both become smaller (equivalently, as the community structure becomes too weak or the network becomes too sparse), suddenly the communities become undetectable