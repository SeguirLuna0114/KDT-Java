# 반복문 : while문
# while  조건식 :
#     조건식이 참인 경우에 실행될 문장

# 1 ~ 100 까지 홀수, 짝수의 합을 구하는 프로그램 작성

i=1; odd=even=0                 # 초기값
while i <= 100:                # 조건식
    if i%2 == 0:                # 짝수
        even += i
    else:                       # 홀수
        odd += i
    i += 1                      # 증감식

print('1~100 까지 홀수의 합:',  odd)
print('1~100 까지 짝수의 합:',  even)
