# 비교 연산자 : ==, !=, >, >=, <, <=
# 비교 연산자의 결과가 참이면 True, 거짓이면 False 를 리턴한다.

x = 10; y = 20
str1 = 'abc'
str2 = 'python'

print(x == y)                   # False
print(x != y)                   # True
print(x > y)                    # False
print(x >= y)                   # False
print(x < y)                    # True
print(x <= y)                   # True

print(str1 == str2)             # False
print(str2 == 'python')         # True
print(str1 < str2)              # True
# 문자열의 크기 비교는 사전순서로 비교한다.
# abc가 python 보다 사전 순서가 앞이므로 결과는 True가 출력된다.