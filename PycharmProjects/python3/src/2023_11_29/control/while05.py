# 반복문 : while문
# while  조건식 :
#     조건식이 참인 경우에 실행될 문장

# 구구단 2~9단 까지 출력하는 프로그램 작성

dan=2                                       # 초기값
while dan <= 9:                             # 조건식 : 단
    print('[',dan,'단 ]')
    i = 1
    while i <= 9:                           # 조건식
        print(dan, '*', i, '=', dan*i)
        i += 1                              # 증감식
    dan += 1                                # 증감식
    print()