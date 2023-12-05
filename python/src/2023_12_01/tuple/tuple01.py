# 튜플(tuple)
# 1. 순차적인 자료구조이다.
# 2. 튜플 데이터는 괄호() 안에 데이터를 저장한다.
# 3. 튜플 데이터는 수정 할 수 없다.
# 4. 튜플은 여러가지 자료형의 데이터를 혼용해서 저장할 수 있다.

t1 = ()                         # 비어있는 튜플
t2 = (1,)
t3 = (1,2,3)
t4 = 1, 2, 3
t5 = (30, 3.14, True, False, 'python')
# t5[1] = 42.195               # 오류 발생 : 튜플데이터는 수정할 수 없다.
t6 = ('a', 'b', 'c', ('ab', 'cd'))

print(type(t1))                 # <class 'tuple'>
print(type(t2))                 # <class 'tuple'>
print(type(t4))                 # <class 'tuple'>
print('t1:', t1)
print('t2:', t2)
print('t3:', t3)
print('t4:', t4)
print('t5:', t5)
print('t6:', t6)


