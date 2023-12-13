# n 번째 피보나치 수열을 구하는 코드를 작성하시오
# (1,1,2,3,5,8,13.. f(n) = f(n-1) + f(n-2) 단,f(1)=1, f(2)=1)

'''
피보나치 수열: 첫번째와 두번째는 무조건 1
              세번째 부터는 앞의 2개의 합
    1,1,2,3,5,8,13,21,34....
    예측이나 그래프 등을 그릴 때 많이 사용하는 알고리즘
'''

n = int(input('몇번째 피보나치 수열을 구하세요?'))    # n=3
a = [1, 1]

for b in range(2, n):               # b = 2
    a.append(1)
    a[b] = a[b - 2] + a[b - 1]      # a[2] = a[0] + a[1] = 2
print(n, '번째 값 : ', a[n - 1])
