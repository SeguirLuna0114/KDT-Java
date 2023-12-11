# calculator 모듈을 사용하는 파일
# 와일드카드(*)를 이용해서 모듈안에 있는 모든 변수와 함수를 import

# from  모듈명  import  *
# : calculator 모듈의 모든 변수와 함수를 import 한다.
from calculator import *

# print(calculator.plus(10, 5))   # 오류 발생
print(plus(10, 5))
print(minus(10, 5))
print(multiply(10, 5))
print(divide(10, 5))

