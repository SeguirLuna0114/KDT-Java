# 조건문 : if  else문

# 키보드로 입력한 정수 2개 중에서 최대값과 최소값을 구하는 프로그램 작성

n1 = int(input('정수1을 입력하세요?'))
n2 = int(input('정수2을 입력하세요?'))

if n1>=n2:
    max = n1
    min = n2
else:
    max = n2
    min = n1
print('max=', max)
print('min=', min)