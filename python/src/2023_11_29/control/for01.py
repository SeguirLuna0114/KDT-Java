# 반복문 : for문

# for  변수  in  range() :
#    반복 실행할 문장

# range(초기값, 최종값, 증감값) : 초기값 ~ 최종값-1까지 증감
for i in range(1, 10, 2):
    print(i, end=' ')                   # 1 3 5 7 9
print()

# range(초기값, 최종값) : 초기값 ~ 최종값-1까지 1씩 증가
for i in range(1, 10):                  # 1 ~ 9
    print(i, end=' ')                   # 1 2 3 4 5 6 7 8 9
print()

# range(최종값) : 0 ~ 최종값-1까지 1씩 증가
for i in range(10):                     # 0 ~ 9
    print(i, end=' ')                   # 0 1 2 3 4 5 6 7 8 9
print()

# 10부터 2까지 1씩 감소
for i in range(10, 1, -1):
    print(i, end=' ')                   # 10 9 8 7 6 5 4 3 2