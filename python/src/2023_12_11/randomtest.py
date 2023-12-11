# random 모듈을 이용한 난수 발생

import random

# random() : 0.0 ~ 1.0 사이의 난수 발생
r1 = random.random()
print('r1=', r1)

# randint(a, b) : a ~ b 사이의 정수 형태의 난수 발생
r2 = random.randint(1, 10)
print('r2=', r2)

# 1 ~ 45 사이의 난수 발생
r3 = random.randint(1, 45)
print('r3=', r3)

# choice() : 컬렉션의 원소를 random하게 선택해주는 함수
list = ['빨강','주황','노랑','초록','파랑','남색','보라']
r4 = random.choice(list)
print('r4=', r4)
