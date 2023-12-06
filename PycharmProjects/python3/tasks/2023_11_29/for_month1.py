# 1 ~ 12월 중에서 달(Month)에 'r'이 들어있는 달(Month)을 출력

# tuple
months = ("January", "February", "March", "April", "May", "June",
          "July", "August", "September", "October", "November", "December")


# for month in months:
#     if 'r' in month.lower():
#         print(month)


for month in months:
    if month.count('r')>0:
        print(month)