# isdigit() : 문자인지 숫자인지 판별할 때 사용되는 함수
# : 문자열을 구성하는 요소가 모두 숫자이면  True를 리턴
#   문자(영문자, 특수문자)가 포함되어 있으면 False를 리턴

txt1 = '010-1234-5678'
txt2 = 'R2D2'
txt3 = '1212'

result1 = txt1.isdigit()
result2 = txt2.isdigit()
result3 = txt3.isdigit()

print('result1:', result1)          # False : 하이픈('-')
print('result2:', result2)          # False : 영문 알파벳
print('result3:', result3)          # True
