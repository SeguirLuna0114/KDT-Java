# 매개변수가 있는 생성자

class ContactInfo:
    def __init__(self, name, email):            # 매개변수가 있는 생성자
        self.name = name                        # name = '홍길동'
        self.email = email                      # email = 'hong@naver.com'

    def print_info(self):
        print('{0} : {1}'.format(self.name, self.email))

if __name__=='__main__':
    ahn = ContactInfo('홍길동','hong@naver.com')  # 객체생성 : 생성자 호출
    ahn.print_info()
    print('name:', ahn.name)
    print('email:', ahn.email)

    ca = ContactInfo('choongang','master@gmail.com')
    ca.print_info()
    print('name:', ca.name)
    print('email:', ca.email)

