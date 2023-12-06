# continue 문 : 다시 반복문으로 돌아가라는 의미로 사용됨
#               continue문 아래쪽 부분은 실행되지 않는다.

# continue문을 이용해서 1~100 정수 중에서 5의 배수만 출력하는 프로그램 작성

for i in range(1, 101):             # 1 ~ 100

    if i%5 != 0:                    #  5의 배수가 아니면
        continue
    print('5의 배수:', i)