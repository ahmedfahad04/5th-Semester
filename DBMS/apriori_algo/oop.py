# Caution:
# 1. You must include self before each method parameter list
# 2. Must declare the list/variable/dict outside constructor

import pprint


class AprioriAlgo:

    inventory = dict()
    products = set()
    feasible_product = dict()
    minimum_support_count = 0

    def __init__(self, min_support) -> None:
        self.minimum_support_count = min_support

    def loadData(self, fileName):

        # read query_data form file
        fp = open(fileName, 'r')
        lines = fp.readlines()

        # split query_data into dictionary
        for line in lines:
            label, items = line.split(': ')
            items = self.clean_query_data(items.split(' '))
            self.inventory[label] = items

            for item in items:
                self.products.add(item)

        self.products = sorted(list(self.products))

    def count_item_frequency(self, sub_set):

        if len(sub_set) == 1:
            sub_set = list(sub_set)

        cnt = 0
        for k, ls in self.inventory.items():
            if all(item_count in ls for item_count in sub_set):
                cnt += 1

        return cnt

    def checkEquality(self, items, A):
        flag = False
        for i in range(len(items)):
            if items[i] == A[i]:
                flag = True
            else:
                flag = False

        return flag

    def clean_query_data(self, prod_list):
        new_list = []

        for i in prod_list:
            new_list.append(i.strip())

        return new_list

    def combine(self, input_list, length, min_support_cnt):

        # Base case: if the length of the combination is 0, return an empty list
        if length == 0:
            return [[]]

        # Recursive case: if the length of the combination is greater than 0,
        # generate all combinations of the sublists of the input list
        result = []
        for i, element in enumerate(input_list):
            sublist = input_list[i+1:]
            for combination in self.combine(sublist, length-1, min_support_cnt):

                tmp = [element] + combination
                x = self.count_item_frequency(tmp)
                if x >= min_support_cnt:
                    result.append([element] + combination)

        return result

    def filterProducts(self):
        ls = self.products

        for i in range(1, len(ls)-1):
            ls_of_product = self.combine(ls, i, self.minimum_support_count)
            for product in ls_of_product:
                self.feasible_product[tuple(
                    product)] = self.count_item_frequency(product)

        return self.feasible_product

    def showSpecificProduct(self, query_size):

        for items, item_count in self.feasible_product.items():
            if len(items) == query_size:
                print(items, item_count)

    def calculateConfidence(self, query):

        # query_data = input("Enter query (ex. I2 I3 | I1): ")

        A, B = query.split('| ')
        AUB = sorted((A+B).strip().split(' '))
        A = tuple(A.strip().split(' '))

        support_cnt_AUB = 0
        support_cnt_A = 0

        for items, item_count in self.feasible_product.items():

            if len(items) == len(AUB):
                if self.checkEquality(items, AUB):
                    support_cnt_AUB = item_count

            if len(items) == len(A):
                if self.checkEquality(items, A):
                    support_cnt_A = item_count

        print("\nP(AUB): ", tuple(AUB), support_cnt_AUB)
        print("P(A): ", A, support_cnt_A)
        print("P(B|A): ", (support_cnt_AUB / support_cnt_A)*100, "%")


if __name__ == '__main__':

    aprioriAlgo = AprioriAlgo(min_support=2)

    aprioriAlgo.loadData(fileName='data.txt')
    
    selectedProducts = aprioriAlgo.filterProducts()
    pprint.pprint(selectedProducts)

    aprioriAlgo.showSpecificProduct(query_size=3)
    aprioriAlgo.calculateConfidence(query='I2 I3 | I1')
