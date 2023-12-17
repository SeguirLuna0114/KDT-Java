# 기상청의 날씨 정보 구하기

from bs4 import BeautifulSoup           # html, xml파일을 분석할때 사용하는 모듈
import urllib.request as req            # 다운로드
import os.path

url='http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108'

savename = 'forecast.xml'

# if not os.path.exists(savename):      # 현재 디렉토리에 forecast.xml 파일이 없으면
req.urlretrieve(url, savename)          # forecast.xml 파일 다운로드

# BeautifulSoup모듈로 분석하기
xml = open(savename, 'r', encoding='utf-8').read()
soup = BeautifulSoup(xml, 'html.parser')
# print(soup)

# 전국 날씨정보를 info 딕셔너리에 저장
info = {}               # info = { name : weather }
for location in soup.find_all('location'):
    name = location.find('city').text           # 도시명
    wf = location.find('wf').text               # 날씨
    tmx = location.find('tmx').text             # 최고기온
    tmn = location.find('tmn').text             # 최저기온

    weather = wf + ':' + tmn + '~' + tmx

    if name not in info:
        info[name] = []
    info[name].append(weather)

print(info)

# 각 지역의 날씨를 구분해서 출력
for name in info.keys():
    print('+', name)                # name : 도시명
    for weather in info[name]:
        print('|', weather)         # weather
