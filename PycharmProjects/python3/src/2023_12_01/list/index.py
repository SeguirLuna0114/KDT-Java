#  index() : 리스트에서 특정 원소의 인덱스 번호를 구해주는 함수

solarsys = ['태양','수성','금성','지구','화성','목성','토성','천왕성','해왕성','지구']
planet = '지구'

# 가장 먼저 나오는 '지구'의 인덱스 번호를 구함
pos = solarsys.index(planet)                # 인덱스 번호 : 3
print('%s은(는) 태양계에서 %d번째 위치하고 있습니다.'%(planet, pos))

# 인덱스 5번 이후에 나오는 '지구'의 인덱스 번호를 구함
pos = solarsys.index(planet, 5)                # 인덱스 번호 : 9
print('%s은(는) 태양계에서 %d번째 위치하고 있습니다.'%(planet, pos))

# 찾는 원소가 없는 경우에는 오류 발생
# pos = solarsys.index('명왕성')
# print(pos)
