# reverse() : 리스트의 원소의 순서를 역순으로 바꾸어 주는 함수
# 사용형식 : 리스트.reverse()
# reverse() 함수는 원본 리스트 자체를 변경한다.

listdata = list(range(10))          # 0 ~ 9
print(listdata)                     # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

listdata.reverse()                  # listdata 역순으로 변경
print('listdata:', listdata)        # [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]


# [1, 3, 5, 4, 2] 라는 리스트를 [5, 4, 3, 2, 1]로 변경 하세요?
list = [1, 3, 5, 4, 2]

# 방법1. sort()
list.sort(reverse=True)                 # 내림차순 정렬
print('list:', list)

# 방법2. sort(), reverse()
list.sort()                             # 오름차순 정렬
list.reverse()                          # 역순으로 정렬
print('list:', list)

# 방법3. sorted()
list2 = sorted(list, reverse=True)      # 내림차순 정렬
print('list2:', list2)

# 방법4. sorted(), reverse()
list3 = sorted(list)                    # 오름차순 정렬
list3.reverse()                         # 역순으로 정렬
print('list3:', list3)



