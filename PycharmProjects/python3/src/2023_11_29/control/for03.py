# 반복문 : for문

# for  변수  in  range() :
#    반복 실행할 문장

# 1 ~ 10 까지 합을 구하는 프로그램 작성

sum = 0
for i in range(1, 11):              #  1 ~ 10
    sum = sum + i                   # sum += i
    print('1~',i,'=',sum)
#    1 =  0  +  1
#    3 =  1  +  2
#    6 =  3  +  3

print('sum=', sum)
