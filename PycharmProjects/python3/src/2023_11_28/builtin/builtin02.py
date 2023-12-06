# 내장 함수 : input(), int(), type()

# input() : 키보드로 입력을 받는 경우에 사용하는 내장함수
# int() : 문자형 데이터를 정수형으로 변환해주는 내장함수
# type() : 변수에 저장된 데이터의 자료형을 구해주는 내장함수

name = input('이름을 입력 하세요?')
age = int(input('나이를 입력 하세요?'))
print(type(name))                  # <class 'str'>
print(type(age))                   # <class 'int'>

if age >= 20:
    print('성인 입니다.')
else:
    print('미성년 입니다.')

