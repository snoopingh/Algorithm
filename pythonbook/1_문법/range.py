import sys

print(list(range(5)))
print(range(5))
print(type(range(5)))

for i in range(5):
    print(i, end=' ')


a = [n for n in range(1000000)]
print(len(a))


b = range(1000000)
print(len(b))


# 똑같이 숫자 100만 개를 갖고 있으나 range 클래스를 이용하는 b 변수의 메모리 점유율이 훨씬 더 작다.
# 생성 조건만 보관하고 있기 때문에 개수가 늘어나도 b 변수의 메모리는 동일하다.
print(sys.getsizeof(a))
print(sys.getsizeof(b))


print(b[999])
