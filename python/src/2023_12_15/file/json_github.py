# github의 repository정보를 json 파일로 저장 후 읽어오기

import urllib.request as req
import os.path
import json

# json 파일 다운로드
url = 'https://api.github.com/repositories'
savename = 'repo.json'

if not os.path.exists(savename):        # 현재 디렉토리에 repo.json파일이 없으면
    req.urlretrieve(url, savename)      # repo.json 파일 다운로드

# repo.json 파일 읽어오기
items = json.load(open(savename, 'r', encoding='utf-8'))
print(type(items))                      # <class 'list'>
print(items)

# 출력 하기
for item in items:
    print(item['name']+'-'+item['owner']['login'])