# 리스트 컴프리헨션 : 기존 리스트를 기반으로 새로운 리스트를 만들어내는 구문
list1: list = list(map(lambda x: x + 10, [1, 2, 3]))
print(list1)


list2: list = [n * 2 for n in range(1, 10 + 1) if n % 2 == 1]
print(list2)