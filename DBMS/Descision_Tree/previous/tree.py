class Node:
    def __init__(self, key):
        self.children = []
        self.value = key
        self.parent = None

    def add_child(self, childNode):
        childNode.parent = self
        self.children.append(childNode)

    def print_child(self):

        space = ' ' * self.get_level() * 2
        print(space + self.value)

        if self.children:
            for child in self.children:
                child.print_child()

    def get_level(self):

        level = 0
        p = self.parent
        while p is not None:
            level += 1
            p = p.parent

        return level

def build_tree():
    
    data = ['*weather', 'sunny', 'rainy', 'cloudy', '*temperature', 'hot', 'warm', 'cold', '*humidity', 'high', 'normal', '*windy', 'weak', 'strong', '*play', 'yes', 'no']
    root = None
    
    for index in len(data):
        if data[index][0] == '*' and index == 0:
            root = Node(data[index][1:])
        elif data[index][0] == '*':
            total_child = len(root.children)
            root.children[total_child - 1].add_child(Node(data[index][1:]))
        else:
            child_node = Node(data[index])
            root.add_child(child_node)
        
        



def make_tree():
    weather = Node("weather")
    sunny = Node("sunny")
    rainy = Node("rainy")
    cloudy = Node("cloudy")
    high = Node("high")
    low = Node("low")
    humidity = Node("humidity")
    
    weather.add_child(sunny)
    weather.add_child(rainy)
    weather.add_child(cloudy)
    
    cloudy.add_child(humidity)
    
    humidity.add_child(high)
    humidity.add_child(low)
    
        
        
    weather.print_child()

if __name__ == '__main__':
    make_tree()