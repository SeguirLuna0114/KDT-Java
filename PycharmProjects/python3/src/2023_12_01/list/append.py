# append() : 리스트에 새로운 원소를 추가할 때 사용되는 함수

a = [1, 2, 3]
a.append(4)                 # 4 추가
print('a:', a)              # [1, 2, 3, 4]

a.append([5, 6])            # [5, 6] 추가
print('a:', a)              # [1, 2, 3, 4, [5, 6]]

#-----------------------------------------------------------
listdata = []               # 비어있는 리스트

for i in range(3):          # 0 ~ 2
    text = input('리스트에 추가할 값을 입력하세요?[%d/3]'%(i+1))
    listdata.append(text)
    print(listdata)

print(listdata)

