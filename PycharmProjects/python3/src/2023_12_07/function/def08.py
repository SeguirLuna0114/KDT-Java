# 가변 매개변수(Arbitary Argument Variable)
# 1. 매개변수 앞에 * 를 붙이면 가변 매개 변수가 된다.
# 2. 가변 매개변수는 입력 갯수가 달라져도 모두 받을 수 있다.
# 3. * 가 붙은 가변 매개변수는 입력받은 값들을 튜플(tuple)로 처리한다.

def merge_string(*text):
    print(type(text))                   # tuple
    print(text)

    result =''
    for s in text:
        result += s
    return result

print(merge_string('나는'))
print(merge_string('나는', '학교에'))
print(merge_string('나는', '학교에','간다'))
print(merge_string('아버지가', '방에','들어 가신다'))

