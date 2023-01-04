hour, min = map(int, input().split())
time = int(input())

t1 = divmod(time, 60) # case1일 경우 : (1, 20)

hour += t1[0]
min += t1[1]

if min > 60 :
  hour += 1
  min -= 60
elif min == 60 :
  hour += 1
  min = 0
  
if hour > 23 :
  hour -= 24

print(hour, min)