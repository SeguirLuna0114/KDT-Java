# 반복문 : for문

# 키보드로 구구단 1개 단을 입력 받아서 해당 구구단을 출력하는 프로그램 작성

dan = int(input('원하는 단을 입력하세요?'))

print('[',dan,'단 ]')
for i in range(1, 10):              # 1 ~ 9
    # print(dan, '*', i, '=', dan * i)
    print('{0} * {1} = {2}'.format(dan, i, dan*i))