# 재귀함수(Recursive Function)
# : 함수 안에서 자기자신의 함수를 호출하는 함수를 재귀함수라고 한다.

    
def call():                 # 재귀함수
    print('무한출력')
    
    call()                  # 자기자신의 call() 함수 호출
    
    
# 외부에서 call() 함수 호출
call()