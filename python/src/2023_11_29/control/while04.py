# 반복문 : while문
# while  조건식 :
#     조건식이 참인 경우에 실행될 문장

# 키보드로 원하는 단을 입력 받아서 구구단 1개 단을 출력하는 프로그램 작성

dan = int(input('원하는 단을 입력 하세요?'))

i = 1                                   # 초기값
while  i <= 9:                          # 조건식
    # print(dan, '*', i, '=', dan*i)
    print('{0} * {1} = {2}'.format(dan, i, dan*i))
    i += 1                              # 증감식 : i = i + 1



