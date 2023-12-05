# replace() : 특정 문자열을 다른 문자열로 치환할 때 사용되는 함수
# replace('data1', 'data2') : data1을 data2로 치환

txt = 'My password is 1234'
result1 = txt.replace('1', '0')         # '1'을 '0'으로 치환
result2 = txt.replace('1', 'python')    # '1'을 'python'으로 치환
print('result1:', result1)              #  My password is 0234
print('result2:', result2)              # My password is python234
