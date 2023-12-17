# pandas로 데이터프레임을 생성하고, 생성된 데이터프레임을 CSV파일에 저장

import pandas as pd

data = [[1,2,3,4],[5,6,7,8]]        # 중첩 리스트

# 데이터프레임 생성
df = pd.DataFrame(data)
print(df)
#    0  1  2  3            컬럼번호
# 0  1  2  3  4            인덱스번호 : 0
# 1  5  6  7  8            인덱스번호 : 1

# 데이터프레임을 CSV파일로 저장
df.to_csv('../data/df.csv', header=False, index=False)
print('저장 성공')