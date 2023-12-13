# 클래스의 상속

class Add:                          # 부모 클래스, 기반 클래스
    def add(self, n1, n2):
        return n1 + n2

class Calculator(Add):              # 자식 클래스, 파생 클래스
    def sub(self, n1, n2):
        return n1 - n2

# 부모 클래스로 객체 생성
ob = Add()
print(ob.add(100, 200))             # 300
# print(ob.sub(100, 200))           # 오류발생

# 자식 클래스로 객체 생성
obj = Calculator()
print(obj.add(10, 20))              # 30
print(obj.sub(10, 20))              # -10




