# 다음 리스트 [10, -2, 3, -5, 8, -3]에서 음수를 제거한후, 오름차순으로 정렬 시키는
# 프로그램을 작성하세요 ?

li = [10, -2, 3, -5, 8, -3]

result = list(filter(lambda x : x>0 , li))

# sort()함수로 오름차순 정렬
result.sort()
print(result)

# sorted()함수로 오름차순 정렬
print(sorted(result))
