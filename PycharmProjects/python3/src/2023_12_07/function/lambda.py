# lambda : 이름이 없는 한줄짜리 함수
# 일반적인 함수를 사용하기 힘든 경우나 좀더 간결하게 표현하고자 할때 사용함

# 형식 : lambda  인자1, 인자2,.... :  실행코드(리턴값)

# 예1.
add = lambda x, y : x+y             # 람수(함수)를 add변수에 저장함

result = add(1, 3)
print('result:', result)

# 예2.
funcs = [ lambda x : x+'.pptx', lambda x : x+'.docx']
result1 = funcs[0]('Intro')
result2 = funcs[1]('Report')
print('result1:', result1)
print('result2:', result2)

# 예3.
# { 'key ' : 'value' } = { '아기이름' : 출생아수 }
names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245 , 'Michale':27115,
         'Bob':5887, 'Kelly':7855}

print(sorted(names.items()))   # 아기이름을 기준으로 오름차순 정렬
# [('Aimy', 9778), ('Bob', 5887), ('Kelly', 7855), ('Mary', 10999),

# 1. 아기이름(key)을 기준으로 오름차순 정렬
print(sorted(names.items(), key= lambda x : x[0]))
# [('Aimy', 9778), ('Bob', 5887), ('Kelly', 7855), ('Mary', 10999),

# 2. 아기이름(key)을 기준으로 내림차순 정렬
print(sorted(names.items(), key= lambda x : x[0], reverse=True))
# [('Tom', 20245), ('Sams', 2111), ('Michale', 27115), ('Mary', 10999),

# 3. 출생아수(value)을 기준으로 오름차순 정렬
print(sorted(names.items(), key= lambda x : x[1]))
# [('Sams', 2111), ('Bob', 5887), ('Kelly', 7855), ('Aimy', 9778),

# 4. 출생아수(value)을 기준으로 내림차순 정렬
print(sorted(names.items(), key= lambda x : x[1], reverse=True))
# [('Michale', 27115), ('Tom', 20245), ('Mary', 10999), ('Aimy', 9778)