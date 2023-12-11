# calculator 모듈을 사용하는 파일

# from  모듈명  import  변수 또는 함수명
# : 모듈 안에 들어있는 import한 변수나 함수만 사용할 수 있다.
from calculator import plus, minus

# print(calculator.plus(10, 5))   # 오류 발생
print(plus(10, 5))
print(minus(10, 5))

# multiply, divide 함수는 import 하지 않았기 때문에 사용할 수 없다.
# print(multiply(10, 5))          # 오류 발생
# print(divide(10, 5))            # 오류 발생

