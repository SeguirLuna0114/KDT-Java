# 1 ~ 45 사이의 정수를 6개를 추출하는 프로그램을 작성하세요?
# 단, 중복되지 않는 정수 6개를 추출하세요.

import random

lot = []                           # 비어있는 리스트

# lot.append(random.randint(1,45))
# lot.append(random.randint(1,45))
# print(lot)

while True:
    r = random.randint(1,45)       # 1 ~ 45 사이의 난수 발생
    if r not in lot:               # 발생된 난수가 list에 없으면 추가
        lot.append(r)
        if len(lot) == 6:          # list 에 6개의 난수가 저장되면
            break                  # 무한루프를 빠져나옴

print(sorted(lot))                 # list 를 오름차순으로 정렬해서 출력