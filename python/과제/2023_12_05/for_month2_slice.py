# 영어로 1 ~ 12월 정보를 가진 리스트에서 각 달을 3자리 약어로 출력

# list
months = ['January','February','March','April','May','June',
               'July','August','September','October','November','December']

# 방법1) 새로운 리스트에 결과값을 저장
# 약어를 저장할 빈 리스트
m = []

for idx in months:
    mon = idx[:3]
    print(mon)
    m.append(mon)   # 리스트에 추가

print("출력 : ", m)



# 방법2) 기존 리스트의 값 변환
for i in range(len(months)):    # range(12) : 0 ~ 11
    months[i] = months[i][:3]
    print(months[i])
    print(months[i][:3])

print(months)