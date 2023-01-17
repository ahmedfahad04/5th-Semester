class Node:
    def __init__(self, data) -> None:
        self.parent = None
        self.data = data 
        
class Tree:
    def __init__(self) -> None:
        self.root = None
        self.nodes = []
        
    def insertNode(self, node):
        if node.parent == None:
            self.root = node
        else:
            self.nodes.append(node)

        
            
            
if __name__ == '__main__':
    tree = Tree()
    
    root = Node('Root')
    tree.insertNode(root)
    
    ch1 = Node('Child 1')
    tree.insertNode(ch1)
    
    
    