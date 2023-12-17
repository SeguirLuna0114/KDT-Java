# 예외처리 : try ~ except ~ else
# try에 대한 else가 아니라, except에 대한 else

'''
try:
     예외가 발생할 가능성이 있는 문장
except:
    예외가 발생 했을때 실행될 문장
else:
    except절이 실행되면  실행안됨
    except절이 실행되지 않는 경우에 실행
'''

list = [1, 2, 3]

try:
    index = int(input('첨자(index번호)를 입력하세요?'))   # 0, 1, 2
    print('list[{0} : {1}]'.format(index, list[index]))
except Exception as err:
    print('예외발생:{0}'.format(err))
else:
    print('리스트의 요소 출력에 성공 했습니다.')