elm = [1,2,3,4]

# 1 2 3 4
# 12 13 14
# 23 24
# 34

for i in range(len(elm)):
    print(elm[i])
    for j in range(i+1, len(elm)):
        print(elm[i], elm[j])
        for k in range(j+1, len(elm)):
            print(elm[i], elm[j], elm[k])
            for l in range(k+1, len(elm)):
                print(elm[i], elm[j], elm[k], elm[l])
