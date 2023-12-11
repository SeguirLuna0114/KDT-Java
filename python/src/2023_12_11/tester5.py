# calculator 모듈을 사용하는 파일

# import  모듈명  as  별칭
import calculator  as c

# 별칭이 부여된 다음에는 별칭명만 사용할 수 있다
# print(calculator.plus(10, 5))           # 오류발생

print(c.plus(10,5))
print(c.minus(10,5))
print(c.multiply(10,5))
print(c.divide(10,5))
