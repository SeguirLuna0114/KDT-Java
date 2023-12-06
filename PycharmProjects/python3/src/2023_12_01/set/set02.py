# 교집합 : &, intersection()
# 합집합 : |, union()
# 차집합 : -, difference()

s1 = set([1,2,3,4,5,6])
s2 = set([4,5,6,7,8,9])

# 1. 교집합
print(s1 & s2)                          # {4, 5, 6}
print(s1.intersection(s2))              # {4, 5, 6}

# 2. 합집합
print(s1 | s2)                          #  {1, 2, 3, 4, 5, 6, 7, 8, 9}
print(s1.union(s2))                     #  {1, 2, 3, 4, 5, 6, 7, 8, 9}

# 3. 차집합
print(s1 - s2)                          # {1, 2, 3}
print(s1.difference(s2))                # {1, 2, 3}

print(s2 - s1)                          # {8, 9, 7}
print(s2.difference(s1))                # {8, 9, 7}
