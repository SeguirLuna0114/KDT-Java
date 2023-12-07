# 일반 매개변수와 가변 매개변수가 같이 사용되는 함수
# : 일반 매개변수와 가변 매개변수를 같이 사용할 경우에는 일반 매개변수를 먼저
#   사용하고, 가변 매개변수는 가장 마지막에 사용해야 한다.

def print_args(n, *args):
    for i in range(n):
        print(args[i], end='')
    print()

# 함수 호출
print_args(1, '파이썬')
print_args(2, '파이썬','자바')
print_args(3, '파이썬','자바','오라클')
