# 클래스의 다중상속
# : 2개 이상의 부모 클래스로 부터 상속을 받는 것

class Add:                          # 부모 클래스
    def add(self, n1, n2):
        print('Add')
        return n1 + n2

class Multiply:                     # 부모 클래스
    def add(self, n1, n2):
        print('Muliply')
        return n1 + n2
    def multiply(self, n1, n2):
        return n1 * n2

# 클래스의 다중상속 : Add, Multiply 클래스를 상속 받는다.
class Calculator(Add, Multiply):    # 자식 클래스
    def sub(self, n1, n2):
        return n1 - n2

obj = Calculator()
print(obj.add(10, 20))              # 30 : Add클래스의 add()실행
print(obj.multiply(10, 20))         # 200
print(obj.sub(10, 20))              # -10

