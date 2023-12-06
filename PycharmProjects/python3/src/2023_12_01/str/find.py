# find() : 특정 문자의 index번호를 구해주는 함수

txt = 'A lot of things occur each day, every day.'

offset1 = txt.find('e')         # 가장 먼저 나오는 'e'의 인덱스 번호를 리턴
offset2 = txt.find('day')       # 가장 먼저 나오는 'day'의 인덱스 번호를 리턴
offset3 = txt.find('day', 30)   # 인덱스번호 30번 이후에 나오는 'day'의 인덱스 번호를 리턴
offset4 = txt.find('j')         # 찾을 문자가 없을 경우에는 -1을 리턴

print('offset1:', offset1)
print('offset2:', offset2)
print('offset3:', offset3)
print('offset4:', offset4)