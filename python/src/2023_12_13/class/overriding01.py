# 메소드 오버라이딩(Method Overriding)
# 1. 부모클래스로 부터 상속받은 메소드를 자식클래스에서 재정의 해서 사용하는 것을 의미한다.
# 2. 부모클래스의 메소드 이름과 형식을 그대로 가지면서, 내용만 다르게 기술하는 것을
#    의미한다.
# 3. 메소드 오버라이딩을 하면, 메소드 오버라이딩된 메소드만 호출된다.
# 4. 부모클래스의 은닉된 메소드를 호출하려면, 자식클래스의 메소드 안에서 super()를
#    이용해서 호출하면 된다.   ex)  super().mymethod()

class A:                            # 부모 클래스
    def mymethod(self):             # 은닉 메소드
        print('부모 메소드')

class B(A):                         # 자식 클래스
    def mymethod(self):             # 메소드 오버라이딩
        super().mymethod()          # 부모 클래스의 은닉 메소드를 호출함
        print('B클래스의 메소드')

class C(A):                         # 자식 클래스
    def mymethod(self):             # 메소드 오버라이딩
        print('C클래스의 메소드')

a = A()
a.mymethod()

b = B()
b.mymethod()                       # 메소드 오버라이딩된 메소드가 호출된다.

c = C()
c.mymethod()                       # 메소드 오버라이딩된 메소드가 호출된다.