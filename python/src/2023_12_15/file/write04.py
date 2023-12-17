# 키보드로 입력한 내용을 파일로 저장하기 : writelines()
# writelines() : 리스트의 내용을 읽어와서 파일로 저장하는 역할

count = 1
data = []                       #  비어있는 리스트
print('파일에 내용을 저장 하려면, Enter키를 누르세요.')

while True:
    text = input('[%d] 파일에 저장할 내용을 입력하세요?'%count)
    if text == '':              # 아무런 값을 입력하지 않고 Enter키 누르면
        break
    data.append(text+'\n')
    count += 1

print(data)

with open('../data/save01.txt', 'w', encoding='utf-8') as file:
    file.writelines(data)
