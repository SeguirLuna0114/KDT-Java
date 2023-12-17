# data/test.txt 파일 읽기 :  read() 함수
# read() : 텍스트 파일의 모든 내용을 읽어와서 문자형 리턴

# 1. 읽기모드로 test.txt 파일 열기 : 상대경로
file = open('../data/test.txt', 'r', encoding='utf-8')

# 읽기모드로 test.txt 파일 열기 : 절대경로
# file = open('C:/Users/user/PycharmProjects/python3/src/2020_11_30/data/test.txt', 'r', encoding='utf-8')

# 2. test.txt 파일의 모든 내용을 읽어와서 str 변수에 저장
str = file.read()
print(type(str))            # <class 'str'>
print(str)

# 3. 파일 닫기
file.close()
