# iterator 를 생성해주는 함수, 함수안에 yield 키워드를 사용함
def test_generator():
    yield 1
    yield 'string'
    yield True

gen = test_generator()
print(gen)
print(type(gen))

print(next(gen))
print(next(gen))
print(next(gen))