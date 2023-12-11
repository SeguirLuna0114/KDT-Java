# calculator 모듈을 사용하는 파일

# from  모듈명  import  변수 또는 함수명
from calculator import plus     # calculator 모듈의 plus함수를 import
from calculator import minus    # calculator 모듈의 minus함수를 import

print(calculator.plus(10, 5))   # 오류 발생
print(plus(10, 5))
print(minus(10, 5))

# multiply, divide 함수는 import 하지 않았기 때문에 사용할 수 없다.
print(multiply(10, 5))          # 오류 발생
print(divide(10, 5))            # 오류 발생

