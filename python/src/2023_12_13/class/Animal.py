# 사용자 정의 클래스
# 클래스 = 멤버변수 + 멤버함수(생성자, 메소드)

class Animal:
    name = 'dog'              # 멤버변수
    age = 5

# 객체 생성
a1 = Animal()
# print(name)                 # 오류 발생
print(a1.name)                # dog
print(a1.age)                 # 5

a1.name = 'cat'
a1.age = 10
print(a1.name)                # cat
print(a1.age)                 # 10

# 객체 생성
a2 = Animal()
print(a2.name)                # dog
print(a2.age)                 # 5


