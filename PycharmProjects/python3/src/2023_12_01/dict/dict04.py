# 딕셔너리의 특정 데이터 삭제 : del 명령
# 딕셔너리의 모든 원소를 삭제 : clear() 함수

# { 'key ' : 'value' } = { '아기이름' : 출생아수 }
names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245 , 'Michale':27115,
         'Bob':5887, 'Kelly':7855}

# names 딕셔너리 에서 key가 'Sams' 인 원소 삭제
del names['Sams']
del names['Bob']

# 삭제 확인
print(names)

# 딕셔너리의 모든 원소를 삭제
names.clear()

# 삭제 확인
print(names)            # 비어있는 딕셔너리 : {}

mydic = {}              # 비어있는 딕셔너리 선언