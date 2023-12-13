# 사용자 정의 모듈 파일 생성

# if __name__=='__main__':
# 1. __name__ 은 현재 모듈 이름을 가진 내장변수
# 2. 외부에서 import해서 사용하지 못하고, 현재의 인터프리터에 의해서
#    직접 실행하고 싶은 경우에 사용한다.

def add(a, b):
    return a+b

def sub(a, b):
    return a-b

if __name__=='__main__':
    print(add(20, 10))              # 30
    print(sub(20, 10))              # 10



