# 상속에서의 생성자
# 1. 생성자는 상속되지 않는다.
# 2. 자식클래스로 객체를 생성할때 자식클래스의 생성자가 호출된다.
#    자식클래스에 생성자가 없는 경우에는, 기본 생성자를 만들어 준다.
# 3. 자식클래스의 생성자가 호출되면 부모클래스의 기본 생성자를 연쇄적으로 호출해준다.

class A:                                # 부모 클래스
    def __init__(self):                 # 기본 생성자
        self.message = 'Hello World'

    def print_message(self):            # 메소드
        print(self.message)

class B(A):                             # 자식 클래스
    pass

if __name__=='__main__':
    # a = A()                             # 객체 생성 : 생성자 호출
    # a.print_message()

    b = B()
    b.print_message()