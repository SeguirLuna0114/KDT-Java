# 기본값 매개변수(Default Argument Variable)

# 기본값 매개변수 cnt = 1로 정의
def str(text, cnt = 1):
    for i in range(cnt):
        print(text)

# 함수 호출
# 함수를 호출할때 2번째 매개변수를 생략하면, 기본값 매개변수 cnt=1이 사용됨
str('안녕 하세요?')
str('안녕히 가세요?', 3)
