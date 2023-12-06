# 튜플에서 지원되는 함수

# 1. len() : 튜플 원소의 갯수를 구해주는 함수
t1 = (10, 20, 30, 40, 50)
print(len(t1))                      # 튜플 원소의 갯수 : 5
print(t1)                           # (10, 20, 30, 40, 50)

# 2. count() : 튜플의 특정 원소의 갯수를 구해주는 함수
t2 = (1,100,2,100,3,100,4,100,5,100)
print(t2.count(100))                # 튜플의 원소 100의 갯수 : 5

# 3. index() : 튜플의 특정 원소의 인덱스 번호를 구해주는 함수
t3 = ('java','jsp','python','spring','R','tensorflow','keras')
print(t3.index('spring'))          # spring 원소의 인덱스 번호 : 3

