# 입력으로 들어오는 모든 수의 평균 값을 계산해 주는 함수를 작성해 보자

# 입력 개수에 상관없이 사용하기 위해 가변 매개변수 *n를 사용
def avg(*n):
#    sum = 0
#    for i in n:
#        sum += i
   return sum(n) / len(n)

print(avg(1, 2))
print(avg(1, 2, 3))
print(avg(1, 2, 3, 4))
print(avg(1, 2, 3, 4, 5))

# n = input('정수를 입력 하세요?').split()
# print(type(n))
# print(n)
# list = map(int, n)          # n에 저장된 문자를 int()함수로 정수형으로 형변환
# print(avg(*list))

