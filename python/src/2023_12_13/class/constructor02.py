# 상속에서의 생성자
# 1. 자식클래스에 생성자가 있는 경우에는, 부모클래스의 기본 생성자를 자동으로
#    호출해주지 않는다.
# 2. 자식클래스에서 부모클래스의 생성자를 호출하기 위해서는 super()를 이용해서 호출한다.
#    ex) super().__init__()

class A:                                # 부모 클래스
    def __init__(self):                 # 기본 생성자
        print('부모 생성자')
        self.message = 'Hello'

class B(A):                             # 자식 클래스
    def __init__(self):                 # 기본 생성자
        print('자식 생성자')
        super().__init__()              # 부모 클래스의 생성자 호출
        print(self.message)

if __name__=='__main__':
    b = B()