a, b = map(int, input().split())

if (b < 45 and b >= 0) :
  if (a == 0) :
    a = 23
  else :
    a -= 1
  b += 15
else :
  b -= 45

print(a, b)