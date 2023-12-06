# sorted() : 문자열을 정렬할때 사용되는 함수
#            특정 변수에 저장된 데이터를 오름차순으로 정렬해주는 함수
# 오름차순 정렬 :  sorted( data )
# 내림차순 정렬 :  sorted( data, reverse = True )

#      오름차순 정렬                내림차순 정렬
#------------------------------------------------------------
# 숫자   1, 2, 3, .....             10, 9, 8,.....
# 문자   사전순 정렬(a,b,c...)       사전 역순 정렬(z,y,x...)

strdata = input('정렬할 문자를 입력 하세요?')    #  python

# 오름차순 정렬
result1 = sorted(strdata)
print(type(result1))                # <class 'list'>
print(result1)                      # ['h', 'n', 'o', 'p', 't', 'y']

# 내림차순 정렬
result2 = sorted(strdata, reverse= True)
print(type(result2))                # <class 'list'>
print(result2)                      # ['y', 't', 'p', 'o', 'n', 'h']
