# data/movie_quotes.text 파일 읽기 : readlines()
# readlines() : 텍스트 파일을 줄 단위로 한꺼번에 읽어와서 리스트로 리턴

# 1. 파일 열기
file = open('../data/movie_quotes.txt', 'r')

# 2. 파일 읽기
# 텍스트 파일을 한꺼번에 읽어와서 리스트로 리턴
lines = file.readlines()
print(type(lines))              # <class 'list'>
print(lines)                    # ["we'll find a way we always have - Interstellar\n",

# 3. 파일 닫기
file.close()
