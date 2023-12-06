# 조건문 : if  ~ else문
# 키보드로 입력한 정수3개 중에서 최대값과 최소값을 구하는 프로그램 작성

n1 = int(input('정수1을 입력하세요?'))
n2 = int(input('정수2을 입력하세요?'))
n3 = int(input('정수3을 입력하세요?'))

# 최대값
if n1>=n2 and n1>=n3:
    max = n1
else:
    if n2>=n1 and n2>=n3:
        max = n2
    else:
        max = n3

# 최소값
if n1<=n2 and n1<=n3:
    min = n1
else:
    if n2<=n1 and n2<=n3:
        min = n2
    else:
        min = n3
print('max:', max)
print('min:', min)