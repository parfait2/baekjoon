T = int(input())

aList = []
bList = []

for i in range(T):
  a, b = map(int, input().split())
  aList.append(a)
  bList.append(b)

for i in range(T):
  print(aList[i] + bList[i])