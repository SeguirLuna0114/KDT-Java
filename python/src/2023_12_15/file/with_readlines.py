# data/stockcode.txt 파일을 읽어와서 출력
# readlines() : 텍스트 파일을 한꺼번에 읽어와서 리스트로 리턴

with open('../data/stockcode.txt', 'r', encoding='utf-8') as file:
    lines = file.readlines()
    print(type(lines))          # <class 'list'>
    print(lines)                # ['000020 동화약품\n', '000040 S&T모터스\n', '000050 경방\n'

    # enumerate() : 리스트의 인덱스 번호와 원소를 리턴하는 함수
    for num, line in enumerate(lines):
        print('%d %s' %(num+1, line), end='')

