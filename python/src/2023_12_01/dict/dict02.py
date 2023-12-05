# 딕셔너리에서 지원되는 함수

# { 'key ' : 'value' } = { '아기이름' : 출생아수 }
names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245 , 'Michale':27115,
         'Bob':5887, 'Kelly':7855}

# 1. keys() : 딕셔너리의 key를 구해주는 함수
for k in names.keys():
    # print('Key:%s\t Value:%d'%(k, names[k]))
    # print('Key:', k, ' Value:', names[k])
    print('Key:{0} Value:{1}'.format(k, names[k]))

# 2. values() : 딕셔너리의 value를 구해주는 함수
result = names.values()
print(type(result))               # <class 'dict_values'>
print(result)                     # dict_values([10999, 2111, 9778, 20245, 27115, 5887, 7855])

list = list(result)              # 출생아수(value)를 리스트로 만들어 주는 함수 : list()
print(type(list))                # <class 'list'>
print(list)                      # [10999, 2111, 9778, 20245, 27115, 5887, 7855]

# 총 출생아수
count = sum(list)
print('총 출생아수:%d'%count)    # 총 출생아수:83990

# 3. items() : 딕셔너리의 key와 value를 모두 구해주는 함수
for item in names.items():
    print(item)                 # ('Mary', 10999)
                                # ('Sams', 2111)
                                # ...

for k, v in names.items():
    print(k,':',v)              # Mary : 10999
                                # Sams : 2111
                                # ...
