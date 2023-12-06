# 반복문 : for문

# for  변수  in  range() :
#    반복 실행할 문장

# 1 ~ 100 까지 홀수의 합과 짝수의 합을 구하는 프로그램 작성

# 홀수의 합 구하기
odd = 0
for i in range(1, 101, 2):
    odd += i
print('1~100 까지 홀수의 합:', odd)

# 짝수의 합 구하기
even = 0
for i in range(0, 101, 2):
    even += i
print('1~100 까지 짝수의 합:', even);

