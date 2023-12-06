# 리스트의 인덱싱

s = ['자바','파이썬','오라클','스프링','텐스플로우']

print(s)
print(s[0])                     # 자바
print(s[1])                     # 파이썬
print(s[2])                     # 오라클
print(s[3])                     # 스프링
print(s[4])                     # 텐스플로우
print(s[-1])                    # 가장 마지막 원소 인덱싱 : 텐스플로우
print(s[-2])                    # 끝에서 2번빼 원소를 인덱싱 : 스프링

# 중첩 리스트
listdata = [1, 2, 'a', 'b', 'c', [4, 5, 6]]
data1 = listdata[1]
data2 = listdata[3]
data3 = listdata[5]
data4 = listdata[5][1]
data5 = listdata[-1]

print('data1:', data1)          # 2 출력
print('data2:', data2)          # b 출력
print('data3:', data3)          # [4, 5, 6] 출력
print('data4:', data4)          # 5 출력
print('data5:', data5)          # [4, 5, 6] 출력

# 삼중 리스트
list = [1, 2, ['a', 'b', ['Life', 'is']]]
data = list[2][2][0]
print('data:', data)            # Life 출력