# continue 문 : 다시 반복문으로 돌아가라는 의미로 사용됨
#               continue문 아래쪽 부분은 실행되지 않는다.

for i in range(1, 11):              # 1 ~ 10

    if i==5:
        continue
    print(i, '출력')