# 딕셔너리의 값 수정

# { 'key ' : 'value' } = { '아기이름' : 출생아수 }
names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245 , 'Michale':27115,
         'Bob':5887, 'Kelly':7855}

print(names)
print(names['Aimy'])            # 9778
print(names.get('Aimy'))        # 9778

# 딕셔너리의 값 수정 : Aimy 의 값을 9778에서 10000으로 수정
names['Aimy'] = 10000

print(names['Aimy'])            # 10000