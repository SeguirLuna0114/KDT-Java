# 멤버 연산자 : in, not in
# in : 해당 데이터가 컬렉션에 포함되어 있으면 True, 포함되어 있지 않으면 False를 리턴
# not in : 해당 데이터가 컬렉션에 포함되어 있지 않으면 True 를 리턴

list = [10, 20, 30, 40, 50]

result1 = 30 in list
result2 = 60 in list
print('result1=', result1)          # True
print('result2=', result2)          # False

str = 'abcde'
result3 = 'c' in str
result4 = 'k' in str
print('result3=', result3)          # True
print('result4=', result4)          # False
