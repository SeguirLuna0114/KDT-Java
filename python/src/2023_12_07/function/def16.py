# 재귀함수를 이용해서 팩토리얼을 구해보자?
#  ex)  5! = 5 x 4 x 3 x 2 x 1

# 팩토리얼을 구하는 재귀함수
def fact(n):
    if n == 0:
        return 1
    else:
        return n * fact(n-1)

print('0!=', fact(0))
print('1!=', fact(1))
print('3!=', fact(3))
print('5!=', fact(5))
print('10!=', fact(10))
print('100!=', fact(100))
print('997!=', fact(997))

#--------------------------------------------------------
import math

print('3!=', math.factorial(3))
print('5!=', math.factorial(5))
print('100!=', math.factorial(100))
print('1000!=', math.factorial(1000))

