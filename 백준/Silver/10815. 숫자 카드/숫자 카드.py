N = int(input())
NSet = set(map(int, input().split()))
M = int(input())
MList = list(map(int, input().split()))

res = []

for i in range(M):
  if MList[i] in NSet:
    res.append(1)
  else:
    res.append(0)

print(*res)