# count() : 문자열에서 특정 문자의 갯수를 구해주는 함수

txt = 'A lot of things occur each day, every day.'

count1 = txt.count('o')             # 영문 'o'의 갯수 구함
count2 = txt.count('day')           # 영문 'day'의 갯수 구함
count3 = txt.count(' ')             # 공백의 갯수를 구함

print('count1:', count1)
print('count2:', count2)
print('count3:', count3)