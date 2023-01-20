# print('A', 'B', sep='\n')

# 리스트를 출력할 때는 join() 으로 묶어서 처리
a = ['A', 'B']
print(' '.join(a))

idx = 1
fruit = 'Apple'
print('{0}: {1}'.format(idx + 1, fruit))
print('{}: {}'.format(idx + 1, fruit))

# f-string (formated string literal) 방법 (파이썬 3.6+ 에서만 지원, 그 이하 버전에서는 동작 x)
print(f'{idx + 1}: {fruit}')