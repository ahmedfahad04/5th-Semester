from bigtree import Node, print_tree, tree_to_dot
from PIL import Image



root = Node("Weather")
Node("[Overcast]", parent=root)

root2 = Node("[Sunny]Humidity", parent=root)
Node("High", parent=root2)
Node("Low", parent=root2)

root3 = Node("[Rain]Wind", parent=root)
Node("Strong", parent=root3)
Node("Weak", parent=root3)



# print_tree(root, attr_list=["age"])
# a [age=90]
# ├── b [age=65]
# │   └── d [age=40]
# └── c [age=60]

graph = tree_to_dot(root, node_colour="green")
graph.write_png("tree.png")

img = Image.open("tree.png")
img.show()