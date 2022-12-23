def count_item_frequency(sub_set):
    
    if len(sub_set) == 1:
        sub_set = list(sub_set)
        
    print("IN: ", sub_set)
    
    cnt = 0
    for k, ls in inventory.items():
        if all(value in ls for value in sub_set):
            # print(ls)
            cnt += 1
            
    return cnt 


def clean_data(prod_list):
    new_list = []
    
    for i in prod_list:
        new_list.append(i.strip())
        
    return new_list


# read data form file
fp = open('data.txt', 'r')
lines = fp.readlines()

# dictionary to store data
inventory = dict()
products = set()
min_support_cnt = 2

# split data into dictionary
for line in lines:
    label, items = line.split(': ')
    items = clean_data(items.split(' '))
    inventory[label] = items
    
    for item in items:
        products.add(item)
        
        
print(sorted(products))

for item in products:
    ls = []
    ls.append(item)
    print(item, count_item_frequency(item))
        
# # find frequency of each permutation
# sub_set = ['I2']  # TODO: this should be dynamic
# count = count_item_frequency(sub_set)

            
# print(count)

