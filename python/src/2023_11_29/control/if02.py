# 조건문 : if문
# if  조건식 :
#     조건식이 참인 경우에 실행될 문장

# 키보드로 입력한 값이 양수인지 음수인지 판별하는 프로그램 작성
n = input('정수를 입력하세요?')
print(type(n))              # <class 'str'>
n = int(n)                  # int() : 문자형을 정수로 변환

if n>=0 :
    print(n, '은(는) 양수')

if n<0:
    print(n, '은(는) 음수')



