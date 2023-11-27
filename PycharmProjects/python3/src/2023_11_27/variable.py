# 변수 : 메모리상에 데이터를 저장하기 위한 기억 공간의 이름
# 변수 만드는 형식 : 변수명 = 값(데이터)

# 정수형 변수
i = 10
print('i=', i)
print(type(i))
# <class 'int'>

print()

# 실수형 변수
r=3.14
print('r=', r)
print(type(r))
# <class 'float'>

print()

# 복소수형 변수
c=3 + 5j
print('c=', c)
print(type(c))
# <class 'complex'>

print()

# 논리형 변수
b1 = True           # 첫 캐릭터를 대문자로 작성
b2 = False
print('b1=', b1)
print('b2=', b2)
print(type(b1))
print(type(b2))
# <class 'bool'>


# 튜플(tuple)
t=('red','orange', 'yellow', 'green', 'blue', 'navy', 'purple')
print(t[0])                 # red
print('t=', t)              # t= ('red', 'orange', 'yellow', 'green', 'blue', 'navy', 'purple')
print(type(t))              # <class 'tuple'>


# 딕셔너리(dictionary) : {'key' : 'value'}
d = {   '네이버' : 'https://www.naver.com',
        '구글' : 'https://www.google.com',
        '애플' : 'https://www.apple.com'}
print('d=', d)              # d= {'네이버': 'https://www.naver.com', '구글': 'https://www.google.com', '애플': 'https://www.apple.com'}
print(type(d))              # <class 'dict'>
