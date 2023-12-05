# sorted() : 리스트에 있는 원소를 오름차순으로 정렬해주는 함수
# 사용 형식 : sorted( 리스트 )
# 오름차순 정렬 : sorted( 리스트 )
# 내림차순 정렬 : sorted( 리스트, reverse = True )
# sorted() 함수를 이용해서 정렬을 하면 원본 리스트가 변경되지 않는다.

#        오름차순 정렬                내림차순 정렬
#------------------------------------------------------------
# 숫자    1, 2, 3, .....             10, 9, 8,.....
# 문자   사전순 정렬(a,b,c...)       사전 역순 정렬(z,y,x...)

namelist = ['Mary','Sams','Aimy','Tom','Michale','Bob','Kelly']

result1 = sorted(namelist)                  # 오름차순 정렬
result2 = sorted(namelist, reverse= True)   # 내림차순 정렬
print(type(result1))                        # <class 'list'>
print(type(result2))

print('result1:', result1)  # ['Aimy', 'Bob', 'Kelly', 'Mary', 'Michale', 'Sams', 'Tom']
print('result2:', result2)  # ['Tom', 'Sams', 'Michale', 'Mary', 'Kelly', 'Bob', 'Aimy']

# sorted() 함수로 정렬하더라도 원래 namelist는 변경되지 않는다.
print('namelist:', namelist)