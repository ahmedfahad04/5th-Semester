class Node:
    def __init__(self, data):
        self.data = data
        self.children = []

class Tree:
    def __init__(self, data=None):
        self.root = None
        if data is not None:
            self.root = Node(data)

    def add_child(self, data, parent_data):
        if self.root is None:
            self.root = Node(parent_data)
            self.root.children.append(Node(data))
            return

        parent = None
        self._find_parent(self.root, parent_data, parent)

        if parent is not None:
            parent.children.append(Node(data))
        else:
            print("Parent not found")

    def _find_parent(self, node, parent_data, parent):
        if node.data == parent_data:
            parent = node
            return
        for child in node.children:
            self._find_parent(child, parent_data, parent)

    def traverse(self):
        self._traverse(self.root)

    def _traverse(self, node):
        print(node.data)
        for child in node.children:
            self._traverse(child)

# Example usage:
tree = Tree(1)
tree.add_child(2, 1)
tree.add_child(3, 1)
tree.add_child(4, 2)
tree.add_child(5, 2)
tree.add_child(6, 3)

tree.traverse()
