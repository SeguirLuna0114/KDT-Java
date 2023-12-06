# pop() : 리스트의 마지막 원소를 삭제하고 리턴하는 함수
# pop( 인덱스 번호 ) : 인덱스 번호의 원소를 삭제하고 리턴

list = [10, 20, 30, 40, 50]
data1 = list.pop()              # 마지막 원소인 50을 삭제하고 50을 리턴
print('data1:', data1)          # 50
print('list:', list)            # [10, 20, 30, 40]

data2 = list.pop(2)             # 인덱스 2번 원소(30)를 삭제하고 리턴
print('data2:', data2)          # 30
print('list:', list)            # [10, 20, 40]
