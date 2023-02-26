N, M = map(int, input().split())
numList = list(map(int, input().split())) # list 자료형으로 type casting 해주어야 인덱싱이 가능하다.

max = 0

for i in range(N-2):
  for j in range(i+1, N-1):
    for k in range(j+1, N):
      sum = numList[i] + numList[j] + numList[k]

      if numList[i] + numList[j] + numList[k] > M:
        continue
      else:
        res = numList[i] + numList[j] + numList[k]
        if max <= res:
          max = res
          
print(max)