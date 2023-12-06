# 반복문 : for문

# for  변수  in  range() :
#    반복 실행할 문장

# 1 ~ 100 까지 홀수의 합과 짝수의 합을 구하는 프로그램 작성
# 단, for문을 1번만 사용해서 작성

odd = even = 0
for i in range(1, 101):                 # 1 ~ 100
    if i%2 == 0:                        # 짝수
        even += i
    else:                               # 홀수
        odd += i
print('1~100 까지 홀수의 합:', odd)
print('1~100 까지 짝수의 합:', even)
