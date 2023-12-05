# len() : 문자열의 길이를 구해주는 함수

msg = input('임의의 문장을 입력 하세요?')
print(type(msg))                # <class 'str'>
len = len(msg)                  # 문자열의 길이를 구함(글자수)

print('당신이 입력한 문장의 길이는 ', len,'입니다.')
print('당신이 입력한 문장의 길이는 {}입니다.'.format(len))
print('당신이 입력한 문장의 길이는 %d입니다.'%len)