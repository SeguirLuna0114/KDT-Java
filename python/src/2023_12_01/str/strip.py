# lstrip() : 문자열 좌측의 공백을 없애주는 함수
# rstrip() : 문자열 우측의 공백을 없애주는 함수
# strip() : 문자열 좌.우의 공백을 없애주는 함수

txt = '    양쪽에 공백이 있는 문자열입니다.    '

result1 = txt.lstrip()
result2 = txt.rstrip()
result3 = txt.strip()

print('<'+txt+'>')
print('<'+result1+'>')
print('<'+result2+'>')
print('<'+result3+'>')