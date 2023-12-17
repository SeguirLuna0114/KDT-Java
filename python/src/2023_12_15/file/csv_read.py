# pandas로 csv파일 읽기

import pandas as pd

# pandas 모듈을 이용해서 CSV파일을 읽어와서 데이터프레임을 만든다.
df = pd.read_csv('../data/list-utf8.csv', encoding='utf-8')
print(type(df))
print(df)
#      ID    이름    가격
# 0   1000   비누    300
# 1   1001   장갑    150
# 2   1002   마스크  230

# 컬럼명으로 해당 정보 구하기
print(df['ID'])
print(df['이름'])
print(df['가격'])

