# 예외처리 : try ~ except ~ finally
'''
try:
    예외가 발생할 가능성이 있는 문장
except:
    예외가 발생 했을때 실행될 문장
finally:
    예외 유무에 상관없이 무조건 실행됨
    파일 닫기, 데이터베이스와 연결을 끊는 내용
'''

try:
    print('안녕 하세요.')
    print(param)                    # 예외 발생
except:
    print('예외가 발생 했습니다.')
finally:
    print('무조건 실행')