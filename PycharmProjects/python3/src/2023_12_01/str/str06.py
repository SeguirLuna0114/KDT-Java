# 문자 변경 : pithon -> python

s = 'pithon'
print(s[1])                       # i

# i -> y 변경
# s[1] = 'y'                      # 오류발생

s = s[:1] + 'y' + s[2:]           # python
print(s)

