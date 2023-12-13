# 1 ~ 12월을 3자리 약어로 출력하는 프로그램 작성
#  ex) January  ->  Jan

months = ['January','February','March','April','May','June',
          'July','August','September','October','November','December']

#        range(12)
for i in range(len(months)):    # 0 ~ 11
    months[i] = months[i][:3]
    # print(months[i])
    # print(months[i][:3])

print(months)