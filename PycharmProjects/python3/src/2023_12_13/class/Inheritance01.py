# 상속(Inheritance)
# : 부모 클래스의 메소드는 상속된다.

class Base:                     # 부모 클래스, 기반 클래스
    def base_method(self):
        print('부모 메소드')

# Base 클래스를 상속
class Derived(Base):            # 자식 클래스, 파생 클래스
    pass

base = Base()                   # 부모 클래스로 객체 생성
base.base_method()              # 메소드 호출

derived = Derived()             # 자식 클래스로 객체 생성
derived.base_method()           # 상속 받은 메소드 호출


