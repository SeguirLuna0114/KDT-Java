# 예외 처리 : try ~ except ~ except
# Exception 클래스로 예외를 받으면 다른 except이 무시되어서 사용이 안된다.

list = [1, 2, 3]

try:
    index = int(input('첨자(index번호)를 입력하세요?'))   # 0, 1, 2
    print(list[index]/0)
except Exception as err:
    print('예외발생:{0}'.format(err))
except ZeroDivisionError as err:               # 0 으로 나눌때 예외발생
    print('0으로 나눌수 없습니다.{0}'.format(err))
except IndexError as err:                      # 첨자(index번호)를 잘못 입력 했을때 예외발생
    print('잘못된 첨자 입니다.{0}'.format(err))
except ValueError as err:                      # 잘못된 값을 입력 했을때 예외 발생
    print('숫자를 입력 하세요.{0}'.format(err))
# except Exception as err:
#     print('예외발생:{0}'.format(err))