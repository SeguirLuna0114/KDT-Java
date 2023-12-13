# 사용자 정의 클래스
# 클래스 = 멤버변수 + 멤버함수(생성자, 메소드)

class Car:

    # 생성자는 객체가 생성될때 호출된다.
    # 생성자는 멤버변수를 초기화 시키는 역할을 한다.
    def __init__(self):             # 생성자(Constructor)
       self.color = 'red'           # 바디의 색깔
       self.wheel_size = 16         # 바퀴의 크기
       self.displacement = 2000     # 배기량

    def forward(self):              # 메소드
        print('전진')
    def backward(self):
        print('후진')
    def turn_left(self):
        print('좌회전')
    def turn_right(self):
        print('우회전')

# 객체 생성
car1 = Car()                        # 생성자 호출

# 멥버변수에 접근
print(car1.color)                   # red
print(car1.wheel_size)              # 16
print(car1.displacement)            # 2000

# 메소드 호출
car1.forward()                      # 전진
car1.backward()                     # 후진
car1.turn_left()                    # 좌회전
car1.turn_right()                   # 우회전