# 슬라이싱 : 문자열 중에서 시작 인덱스 번호부터 끝인덱스 번호까지 문자를 추출 하는 것
# 형식 :  변수[ 시작 인덱스 번호 : 끝 인덱스 번호 ]
# 시작 인덱스 번호부터 끝인덱스 번호-1번 까지 슬라이싱

s = 'Life is too short, you need python'

print(s[0:2])         # 인덱스 0번부터 1번까지 슬라이싱 : Li
print(s[0:5])         # 인덱스 0번부터 4번까지 슬라이싱 : Life
print(s[5:7])         # 인덱스 5번부터 6번까지 슬라이싱 : is
print(s[12:17])       # 인덱스 12번부터 16번까지 슬라이싱 : short

print(s[ : 7])        # 처음부터 인덱스 6번까지 슬라이싱 : Life is

print(s[5 : ])        # 인덱스 5번 부터 끝까지 슬라이싱 : is too short, you need python

print(s[ : ])         # 처음부터 끝까지 슬라이싱

# 날짜와 날씨를 슬라이싱으로 분리
str = '20201024Rainy'
date = str[:8]              # 20201024
weather = str[8:]           # Rainy
print(date,':', weather)

# str 변수의 년, 월, 일을 슬라이싱
year = str[:4]              # 2020
month = str[4:6]            # 10
day = str[6:8]              # 24
print(year, '년', month, '월', day, '일')



