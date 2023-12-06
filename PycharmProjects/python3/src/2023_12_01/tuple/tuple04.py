# 튜플(tuple)

# 튜플 패킹(tuple packing) : 여러 데이터를 튜플로 묶는 것
t1 = 10, 20, 30
print(type(t1))                     # <class 'tuple'>
print(t1)                           # (10, 20, 30)

# 튜플 언패킹(tuple unpacking)
# 1. 튜플의 각 원소를 여러개의 변수에 할당하는 것
# 2. 튜플의 원소의 갯수와 변수 갯수가 일치되지 않으면 에러발생

one, two, three = t1
print('one:', one)                  # 10
print('two:', two)                  # 20
print('three:', three)              # 30

