# time 모듈

import time

#time()은 UTC(Universal Time Coordinated 협정 세계 표준시)를
# 이용하여 현재 시간을 실수 형태로 리턴하는 함수.
# 1970년 1월 1일 0시 0분 0초를 기준으로 지난 시간을 초 단위로 리턴.
print(time.time())

#localtime()은 time()에 의해서 반환된 실수값을 이용해서
# 연도, 월, 일, 시, 분, 초,.. 의 형태로 바꾸어 주는 함수.
print(time.localtime(time.time()))

#asctime()은 localtime()에 의해서 반환된 튜플 형태의 값을
# 인수로 받아서 날짜와 시간을 알아보기 쉬운 형태로 리턴하는 함수.
print(time.asctime(time.localtime(time.time())))

# ctime()은 현재 시간을 간단하게 리턴하는 함수.
print(time.ctime())

#strftime('출력할 형식 포맷 코드', time.localtime(time.time())))
print(time.strftime('%x', time.localtime(time.time())))
print(time.strftime('%c', time.localtime(time.time())))
print(time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time())))

#sleep() 함수를 사용하면 일정한 시간 간격을 두고 실행
for i in range(10):         # 0 ~ 9
    print(i)
    time.sleep(2)           # 1초 간격으로 실행