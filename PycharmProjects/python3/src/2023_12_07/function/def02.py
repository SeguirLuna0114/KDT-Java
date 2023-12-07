# 매개 변수가 있는 함수
# : 절대값을 구하는 함수

# 사용자 정의 함수
def abs(n):                     # n : 매개변수(parameter)
    if n < 0:
        n = -n
    return n                    # return문 : 함수를 호출한 곳에 값을 돌려주는 역할

# 함수 호출
abs(-30)
print('돌려 받은값1:', abs(-30))

result = abs(-50)
print('돌려 받은값2:', result)


