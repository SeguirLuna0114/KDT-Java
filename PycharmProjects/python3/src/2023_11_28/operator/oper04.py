# 논리 연산자 : and, or, not

#      논리 연산자                의미
# ----------------------------------------------------------
#   A  and   B               A와 B가 모두 참인 경우에만 True
#   A  or    B               A와 B중 하나 이상이 참이면 True
#   not A                    A 논리값의 반대

b1=True; b2=False; b3=True; b4=False

print(b1 and b2)            # False
print(b1 and b3)            # True
print(b2 or b3)             # True
print(b2 or b4)             # False
print(not b1)               # False
print(not b2)               # True
