N, X = list(map(int, input().split()))

num_list = list(map(int, input().split()))
res_list = list()

for i in num_list:
  if(i < X):
    res_list.append(i)

print(*res_list)