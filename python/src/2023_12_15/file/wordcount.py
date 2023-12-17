# 텍스트 파일(data/data.txt)에서 wordcount를 내림차순으로 정렬해서 출력

# 딕셔너리 = { '단어' : 빈도수 }

# 각 단어의 빈도수를 구해주는 함수
def getTextFreq(filename):
    with open(filename, 'r', encoding='utf-8') as f:
        text = f.read()          # data.txt 파일 전체 내용을 읽어옴
        tmp = text.split()       # split()함수로 파싱된 단어들을 리스트로 리턴

        fa = {}                  # 비어있는 딕셔너리
        for c in tmp:
            if c in fa:          # 딕셔너리 fa에 key(단어)가 있으면
                fa[c] += 1       # 해당단어의 빈도수를 1증가
            else:                # 딕셔너리 fa에 key(단어)가 없으면
                fa[c] = 1        # 딕셔너리에 빈도수 1 할당(처음나온 단어)

    return fa                    # 함수를 호출한 곳에 딕셔너리 fa 리턴

result = getTextFreq('../data/data.txt')
# result = getTextFreq('../data/alice.txt')
# result = getTextFreq('../data/hong.txt')
print(type(result))              # <class 'dict'>
print(result)

# 단어(key)를 기준으로 오름차순 정렬
print(sorted(result.items()))
print(sorted(result.items(), key=lambda x : x[0]))

# 단어(key)를 기준으로 내림차순 정렬
print(sorted(result.items(), key=lambda x : x[0], reverse=True))

# 단어의 빈도수를 기준으로 내림차순 정렬 : 10, 9, 8....
result = sorted(result.items(), key=lambda x : x[1], reverse=True)
print(result)

for c, freq in result:
    print('[%s] - [%d]회' %(c, freq))

