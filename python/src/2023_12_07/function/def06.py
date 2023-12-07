# 입력받은 매개변수에 따라 문자열을 반복 출력하는 함수

def str(text, cnt):
    for i in range(cnt):      # 0 ~ 2까지 3번 루프가 돌아감
        print(text, i+1)

# 함수 호출
str('안녕하세요', 3)
str('파이썬', 5)
str('자바', 3)
str('스프링')                  # 오류 발생

