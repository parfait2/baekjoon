x, y, w, h = list(map(int, input().split()))
a = []
a.append(x)
a.append(y)
a.append(abs(x-w))
a.append(abs(y-h))

a.sort()

print(a[0])