# 파일 생성(파일 쓰기) : write()

# 1. 쓰기 모드로 열기
file = open('../data/text.txt', 'w', encoding='utf-8')

# 2. 파일 쓰기(저장)
file.write('안녕\n반갑습니다.\n')
print('저장 성공')

# 3. 파일 닫기
file.close()