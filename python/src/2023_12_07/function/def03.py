# 매개변수가 2개인 함수
# 최대값과 최소값을 구해주는 함수

# 최대값을 구해주는 함수
def max(n1, n2):
    if n1 > n2:
        return n1
    else:
        return n2

# 최소값을 구해주는 함수
def min(n1, n2):
    if n1 < n2:
        return n1
    else:
        return n2

n1 = int(input('정수1을 입력하세요?'))
n2 = int(input('정수2를 입력하세요?'))

max = max(n1, n2)               # 함수 호출
min = min(n1, n2)               # 함수 호출

print('max:', max)
print('min:', min)