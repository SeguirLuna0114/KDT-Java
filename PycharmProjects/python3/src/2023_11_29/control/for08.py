# 반복문 : for문
# for  변수  in  컬렉션:

# 리스트(list)
list = ['사과','딸기','포도','배','키위','바나나']
print(type(list))              # <class 'list'>
print(list)                    # ['사과', '딸기', '포도', '배', '키위', '바나나']
print(list[0])                 # 사과

for i in list:
    print(i, end=' ')           # 사과 딸기 포도 배 키위 바나나
print()

# 튜플(tuple)
t = ('red','orange','yellow','green','blue','navy','purlpe')
print(type(t))                  # <class 'tuple'>
print(t)                        # ('red', 'orange', 'yellow', 'green', 'blue', 'navy', 'purlpe')
print(t[0])                     # red

for i in t:
    print(i, end=' ')           # red orange yellow green blue navy purlpe
print()

# 딕셔너리(dictionary) : { 'key' : 'value' }
dic = {'애플' : 'http://www.apple.com',
       '구글' : 'http://www.google.com',
       '네이버' : 'http://www.naver.com'}

print(type(dic))                # <class 'dict'>
print(dic)                      # {'애플': 'http://www.apple.com', '구글': 'http://www.google.com', '네이버': 'http://www.naver.com'}
print(dic['애플'])               # http://www.apple.com

for k, v in dic.items():
    print(k,':', v)








