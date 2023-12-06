# continue 문 : 다시 반복문으로 돌아가라는 의미로 사용됨
#               continue문 아래쪽 부분은 실행되지 않는다.

# continue문을 이용해서 1~100 까지 정수중에서 홀수만 출력하는 프로그램을 작성

for i in range(1, 101):             # 1 ~ 100

    if i%2 == 0:                    # 짝수
        continue
    print('홀수:', i)
