n =  int(input())
res1 = n
count = 0

while(True) :
  res2 = res1//10
  res3 = res1%10
  res4 = (res2+res3)%10
  res1 = res3*10 + res4

  count += 1

  if(res1 == n) :
    break

print(count)