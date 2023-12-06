# 딕셔너리(dictionary)
# 1. 딕셔너리에 데이터를 저장할 때는 key와 value(=data)를 같이 저장한다.
# 2. 딕셔너리는 순차적인 자료구조가 아니다.
# 3. 딕셔너리의 데이터를 구해올때는 key를 이용해서 데이터를 구해온다.
# 4. 1개의 딕셔너리에 key는 1개만 사용 가능하다.
#    1개의 딕셔너리에 동일한 이름을 가진 key가 여러개 존재하면, 가장 마지막의
#    key만 사용 가능하다.

# { 'key ' : 'value' } = { '아기이름' : 출생아수 }
names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245 , 'Michale':27115,
         'Bob':5887, 'Kelly':7855, 'Mary':100}
print(type(names))           # <class 'dict'>
print(names)                 # {'Mary': 100, 'Sams': 2111, 'Aimy': 9778, 'Tom': 20245, 'Michale': 27115, 'Bob': 5887, 'Kelly': 7855}

print(names['Aimy'])        # 9778
print(names['Tom'])         # 20245
print(names['Mary'])        # 100

