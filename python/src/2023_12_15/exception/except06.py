# 예외처리 : try ~ except ~ else ~ finally

'''
try:
    예외가 발생할 가능성이 있는 문자
except:
    예외가 발생 했을때 실행될 문장
else:
    except절이 실행되면 실행안됨
    except절이 실행되지 않는 경우에 실행됨
finally:
    예외 유.무에 상관없이 무조건 실행
    파일 닫기, 데이터베이스와 연결을 끊는 내용
'''

list = [1,2,3]

try:
    index = int(input('첨자(인덱스 번호)를 입력하세요?'))    # 0, 1, 2
    print('list[{0} : {1}]'.format(index, list[index]))
except Exception as err:
    print('예외가 발생했습니다.{0}'.format(err))
else:
    print('리스트의 요소 출력에 성공 했습니다.')
finally:
    print('어떤 일이 있어도 마무리 합니다.')




