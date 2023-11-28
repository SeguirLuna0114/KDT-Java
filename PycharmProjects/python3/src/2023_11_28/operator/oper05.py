# 논리 연산자

# 5과목의 점수를 입력 받아서 합격, 불합격을 판별하는 프로그램을 작성 하세요?
# 단, 과목당 과락은 40점이고, 평균 60점 이상이면 합격

# input() : 키보드로 입력을 받는 경우에 사용하는 함수
# int() : 문자를 정수형으로 형변환 해주는 함수 :  '60' -> 60
# n = input('점수를 입력하세요?')
# print(type(n))              # <class 'str'>
# n = int(n)                  # int() : 문자를 정수형으로 변환해주는 함수
# print(type(n))              # <class 'int'>

n1 = int(input('점수1을 입력 하세요?'))
n2 = int(input('점수2을 입력 하세요?'))
n3 = int(input('점수3을 입력 하세요?'))
n4 = int(input('점수4을 입력 하세요?'))
n5 = int(input('점수5을 입력 하세요?'))

avg = (n1+n2+n3+n4+n5) / 5          # 몫: 실수형
print('avg=', avg)

if n1>=40 and n2>=40 and n3>=40 and n4>=40 and n5>=40 and avg>=60:
    print('합격')
else:
    print('불합격')