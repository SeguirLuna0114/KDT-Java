# 1년 365.242374
# 평년 = 365일 (2월달 - 28일까지)
# 윤년 = 366일 (2월달 - 29일까지)

# 윤년의 정의
# 1. 해당 연도를 4로 나누어 떨어지면 윤년
# 2. 그 중에서 100으로 나누어 떨어지면 윤년이 아님
# 3. 그 중에서 400으로 나누어 떨어지면 윤년

# 윤년은 4의 배수이고 100배수는 아니거나 400의 배수이면 윤년

def yun(year):
    if year%400==0 or (year%4==0 and year%100!=0):
        print(year, "는 윤년입니다")
    else:
        print(year, "는 평년입니다")

year = int(input('원하는 연도를 입력하세요?'))
yun(year)