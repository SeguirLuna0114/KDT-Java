# data/stockcode.txt 파일을 읽어와서 출력
# read() : 텍스트 파일의 모든 내용을 읽어와서 문자형으로 리턴

with open('../data/stockcode.txt', 'r', encoding='utf-8') as file:
    data = file.read()
    print(data)


