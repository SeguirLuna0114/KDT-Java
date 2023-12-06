# 구구단 2~9단 까지 출력하는 프로그램 작성
# 각 단을 열방향으로 출력

for d in range(2,10):
    print('[',d,'단]', end='\t\t\t')
print()
for i in range(1, 10):
    for dan in range(2, 10):
        print(dan,'*',i,'=',dan*i, end='\t\t')
    print()