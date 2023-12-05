# 딕셔너리의 정렬 : sorted() 함수
# 딕셔너리의 key(아기이름)를 이용해서 오름차순, 내림차순 정렬?
# 딕셔너리의 value(출생아수)를 이용해서 오름차순, 내림차순 정렬?

# { 'key ' : 'value' } = { '아기이름' : 출생아수 }
names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245 , 'Michale':27115,
         'Bob':5887, 'Kelly':7855}

#----------------------------------------------------------------------
# 딕셔너리의 key를 리턴하는 함수
def f1(x):
    return x[0]

# 딕셔너리의 value를 리턴하는 함수
def f2(x):
    return x[1]

# 1. 딕셔너리의 key(아기이름)를 이용해서 오름차순
result1 = sorted(names)
print('result1:', result1)              # ['Aimy', 'Bob', 'Kelly', 'Mary', 'Michale', 'Sams', 'Tom']

result2 = sorted(names.items(), key=f1)
print('result2:', result2)              # [('Aimy', 9778), ('Bob', 5887), ('Kelly', 7855), ('Mary', 10999), ('Michale', 27115), 'Tom']

# 2. 딕셔너리의 key(아기이름)를 이용해서 내림차순
result3 = sorted(names, reverse=True)
print('result3:', result3)              # ['Tom', 'Sams', 'Michale', 'Mary', 'Kelly', 'Bob', 'Aimy']

result4 = sorted(names.items(), reverse=True , key=f1)
print('result4:', result4)              # [('Tom', 20245), ('Sams', 2111), ('Michale', 27115), ('Mary', 10999), ('Kelly', 7855)y']

# 3. 딕셔너리의 value(출생아수)를 이용해서 오름차순
result5 = sorted(names.items(), key=f2)
print('result5:', result5)              # [('Sams', 2111), ('Bob', 5887), ('Kelly', 7855), ('Aimy', 9778), ('Mary', 10999),

# 4. 딕셔너리의 value(출생아수)를 이용해서 내림차순
result6 = sorted(names.items(), reverse=True , key=f2)
print('result6:', result6)              # [('Michale', 27115), ('Tom', 20245), ('Mary', 10999), ('Aimy', 9778), ('Kelly', 7855)