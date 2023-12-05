# set(집합) 자료형의 특징
# 1. 중복데이터를 저장할 수 없다.
# 2. 순차적인 자료구조가 아니다.
#    순서있는 입.출력을 처리할 수 없다.

s1 = set([1,2,3,4])
print(type(s1))                     # <class 'set'>
print(s1)                           # {1, 2, 3, 4}

s2 = set('Hello')
print(type(s2))                     # <class 'set'>
print(s2)                           # {'e', 'H', 'o', 'l'}

# set을 list 로 변환 : list() 함수
s3 = set([1, 2, 3])
print(type(s3))                     # <class 'set'>
# print(s3[1])                      # 오류 발생 : 인덱싱을 할 수 없다.

# s3 집합을 list로 변환 : list()
list1 = list(s3)
print(type(list1))                  # <class 'list'>
print(list1)                        # [1, 2, 3]
print(list1[0])                     # 1
print(list1[1])                     # 2
print(list1[2])                     # 3

# s3 집합을 tuple로 변환 : tuple()
t1 = tuple(s3)
print(type(t1))                     # <class 'tuple'>
print(t1)                           # (1, 2, 3)
print(t1[0])                        # 1
print(t1[1])                        # 2
print(t1[2])                        # 3



