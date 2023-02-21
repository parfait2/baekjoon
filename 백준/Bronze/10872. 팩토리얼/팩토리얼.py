def factorial(N):
  res = 1

  if N > 0:
    res = N * factorial(N-1)

  return res

N = int(input())

print(factorial(N))