n =  int(input())

num_list = list(map(int, input().split()))
target =  int(input())

count = 0

for i in num_list:
  if(i == target):
    count+=1

print(count)