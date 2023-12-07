# 함수를 변수에 담아서 사용하기

# 예1. 함수명을 변수에 담아서 사용하기
def something(a):
    print(a)

p = something           # 함수 이름을 변수 p에 저장
p(123)                  # 변수 p를 이용해서 something() 함수 호출
p('abc')                # 변수 p를 이용해서 something() 함수 호출

# 예2. 함수명을 리스트에 담아서 사용하기
def plus(a,b):
    return a+b

def minus(a,b):
    return a-b

first = [plus, minus]      # plus()함수와 minus()함수를 리스트에 저장
print(first[0](1,2))       # first[0]은 plus()함수를 의미함
print(first[1](1,2))       # first[1]은 minus()함수를 의미함

# 예3. 함수명을 매개변수로 전달해서 사용하기
def hello_korean():
    print('안녕하세요')
def hello_english():
    print('Hello')
def greet(hello):           # 함수명을 매개변수로 전달
    hello()                 # 함수 호출

greet(hello_korean)         # greet() 함수 호출
greet(hello_english)        # greet() 함수 호출

