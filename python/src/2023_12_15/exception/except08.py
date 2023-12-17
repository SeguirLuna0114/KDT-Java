# 사용자 정의 예외 클래스

# 사용자 정의 예외 클래스
class MyException(Exception):       # Exception클래스를 상속 받아서 만든다.
    def __init__(self, arg):        # 생성자
      super().__init__('정수가 아닙니다.:{0}'.format(arg)) # 부모(Exception)의
                                                          # 생성자 호출

# 문자를 숫자로 변환 해주는 함수
def convert(text):
    if text.isdigit():              # 숫자 형태의 문자면 True 리턴
        return int(text)
    else:
        raise MyException(text)     # 강제로 예외발생

try:
    text = input('정수를 입력하세요?')
    number = convert(text)         # 함수 호출
except MyException as err:
    print('예외가 발생 했습니다.{0}'.format(err))
else:
    print('정수 형식으로 변환되었습니다.{0} {1}'.format(number, type(number)))
