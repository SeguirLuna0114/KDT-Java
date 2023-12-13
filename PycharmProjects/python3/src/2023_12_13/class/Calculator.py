# 정적 메소드(static method)
# 1. 정적 메소드는 공유를 목적으로 하는 경우에 사용한다.
# 2. 정적 메소드를 만들기 위해서는 메소드 위에 @staticmethod 데코레이터를
#    붙여서 만들다.
# 3. 정적 메소드는 객체를 생성하지 않고, 클래스명.정적메소드 형식으로 호출한다.
# 4. 정적 메소드는 self를 사용하지 않는다.

class Calculator:

    @staticmethod
    def plus(a,b):                  # 정적 메소드
        return a+b

    @staticmethod
    def minus(a,b):
        return a-b

    @staticmethod
    def multiply(a,b):
        return a*b

    @staticmethod
    def divide(a,b):
        return a/b

if __name__=='__main__':             # 정적 메소드 호출
    print('{0}+{1}={2}'.format(7,4, Calculator.plus(7,4)))
    print('{0}-{1}={2}'.format(7,4, Calculator.minus(7,4)))
    print('{0}*{1}={2}'.format(7,4, Calculator.multiply(7,4)))
    print('{0}/{1}={2}'.format(7,4, Calculator.divide(7,4)))

