# 멤버연산자 in 을 이용하여 특정 값이 딕셔너리의 key로 존재하는지 확인 하는 프로그램 작성

# { 'key ' : 'value' } = { '아기이름' : 출생아수 }
names = {'Mary':10999, 'Sams':2111, 'Aimy':9778, 'Tom':20245 , 'Michale':27115,
         'Bob':5887, 'Kelly':7855}

k = input('아기이름을 입력하세요?')

if k in names:  # 키보드로 입력한 이름이 딕셔너리에 있으면 True 리턴
    print('이름이 %s인 출생아수는 %d명 입니다.'%(k, names[k]))
else:
    print('자료에 %s인 이름이 존재하지 않습니다.'%k)
    names[k] = 1000;

print(names)