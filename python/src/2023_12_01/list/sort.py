# sort() : 리스트에 있는 원소를 오름차순으로 정렬해주는 함수
# 사용형식 :  리스트.sort()

# 오름차순 정렬 : 리스트.sort()
# 내림차순 정렬 : 리스트.sort( reverse = True)
# sort() 함수를 이용해서 정렬을 하면 원본 리스트가 변경된다.

#        오름차순 정렬                내림차순 정렬
#------------------------------------------------------------
# 숫자    1, 2, 3, .....             10, 9, 8,.....
# 문자   사전순 정렬(a,b,c...)       사전 역순 정렬(z,y,x...)


namelist = ['Mary','Sams','Aimy','Tom','Michale','Bob','Kelly']

namelist.sort()               # 오름차순 정렬
print('namelist:', namelist)  # ['Aimy', 'Bob', 'Kelly', 'Mary', 'Michale', 'Sams', 'Tom']

namelist.sort(reverse=True)    # 내림차순 정렬
print('namelist:', namelist)  # ['Tom', 'Sams', 'Michale', 'Mary', 'Kelly', 'Bob', 'Aimy']
