# raise문: 프로그래머가 강제로 예외를 발생

def some_function():
    num = int(input('1~10 사이의 정수를 입력하세요?'))
    if num<1 or num>10:     # 강제로 예외발생 시킴
        raise  Exception('유효하지 않는 숫자입니다.{0}'.format(num))
    else:
        print('입력한 숫자는 {0}입니다.'.format(num))

try:
    some_function()                     # 함수 호출
except Exception as err:
    print('예외가 발생 했습니다.{0}'.format(err))