# 사용자가 키보드로 입력한 내용을 파일로 저장하기 : write()

text = input('파일에 저장할 내용을 입력하세요?')

with open('../data/save.txt', 'w', encoding='utf-8') as file:
    file.write(text)

print('저장 성공')