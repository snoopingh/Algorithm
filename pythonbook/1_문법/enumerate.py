a = [1, 2, 3, 2, 45, 2, 5]
print(a)

print(enumerate(a))

# list() 로 결과를 추출, 인덱스를 자동으로 부여
print(list(enumerate(a)))


b = ['a1', 'a2', 'a3']
for i in range(len(b)):
    print(i, b[i])


for i, v in enumerate(b):
    print(i, v)