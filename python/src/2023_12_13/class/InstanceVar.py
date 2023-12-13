# if __name__=='__main__':
# 1. __name__ 은 현재 모듈 이름을 가진 내장변수
# 2. 외부에서 import해서 사용하지 못하고, 현재의 인터프리터에 의해서
#    직접 실행하고 싶은 경우에 사용한다.

class InstanceVar:
    def __init__(self):             # 생성자
        self.text_list = []         # 멤버변수 : 비어있는 리스트

    def add(self, *text):           # 메소드 : 리스트에 값을 추가
        self.text_list.append(text)

    def print_list(self):           # 메소드 : 리스트를 출력
        print(self.text_list)

if __name__=='__main__':
    a = InstanceVar()               # 객체 생성 : 생성자 호출
    a.add('파이썬','오라클','스프링')
    a.print_list()                  # [('파이썬', '오라클', '스프링')]
    print(a.text_list)              # [('파이썬', '오라클', '스프링')]

    b = InstanceVar()               # 객체 생성 : 생성자 호출
    b.add('자바','JSP','tensorflow','keras')
    b.print_list()                  # [('자바', 'JSP', 'tensorflow', 'keras')]
    print(b.text_list)              # [('자바', 'JSP', 'tensorflow', 'keras')]
