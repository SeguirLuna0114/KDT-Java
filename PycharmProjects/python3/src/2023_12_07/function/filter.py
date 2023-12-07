# filter() 내장 함수
# : 컬렉션과 lambda함수를 매개변수로 받아서 컬렉션의 모든 데이터를
#   lambda 함수의 매개변수로 대입해서 결과가 참인 경우에만 리턴하는 함수

li = [1, 2, 3, 4, 5]

print('lambda와 filter() 함수를 이용한 실행')
result = list(filter(lambda x : x%2==0, li))    # 짝수만 리턴
print('result:', result)

