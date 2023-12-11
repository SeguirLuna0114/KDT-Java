# my_package패키지 안의 calculator 모듈 파일 불러오기

# 방법1.
# from  패키지명  import  모듈파일명
from  my_package  import  calculator

print(calculator.plus(10, 5))
print(calculator.minus(10, 5))
print(calculator.multiply(10, 5))
print(calculator.divide(10, 5))

# 방법2.
# import  패키지명.모듈명
import my_package.calculator

print(my_package.calculator.plus(10, 5))
print(my_package.calculator.minus(10, 5))
print(my_package.calculator.multiply(10, 5))
print(my_package.calculator.divide(10, 5))

# 방법3.
# import  패키지명.모듈명  as  별칭명
import my_package.calculator  as  cal

print(cal.plus(10, 5))
print(cal.minus(10, 5))
print(cal.multiply(10, 5))
print(cal.divide(10, 5))