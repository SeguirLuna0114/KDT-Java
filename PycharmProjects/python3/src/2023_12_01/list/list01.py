# 리스트
# 1.순차적인 자료구조 (인덱스 번호 순으로 저장)
# 2.대괄호( [ ] )안에 데이터를 저장한다.
# 3.리스트의 원소들은 수정 가능하다.
# 4.여러가지 자료형의 데이터를 혼용해서 저장할 수 있다.

# 방법1.
a = []                            # 비어있는 리스트
b = [10, 20, 30]
c = ['파이썬','자바','오라클','JSP','Spring','tensorflow','keras']
d = [30, 3.14, True, False, 'java']
list1 = ['사과','포도','바나나','키위','복숭아']
print(type(list1))                # <class 'list'>
print(list1)                      # ['사과', '포도', '바나나', '키위', '복숭아']
print(list1[0])                   # 사과
print(list1[1])                   # 포도
list1[0] = 'apple'                # '사과'를 apple로 수정
print(list1[0])                   # apple

# 방법2.
# list(), range() 함수를 이용해서 연속적인 데이터를 가진 리스트 생성
list2 = list(range(10))           # 0 ~ 9
list3 = list(range(1,11))         # 1 ~ 10
list4 = list(range(1,11,2))       # 1, 3, 5, 7, 9

print('list2:', list2)            # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
print('list3:', list3)            # [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print('list4:', list4)            # [1, 3, 5, 7, 9]
