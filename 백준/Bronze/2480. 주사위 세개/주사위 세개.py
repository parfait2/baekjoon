dice = list(map(int, input().split()))
dice.sort() # case3: 6 2 5 -> (2,5,6)

diceSet = set(dice)

if len(diceSet) == 3:
  total = dice[2]*100
elif len(diceSet) == 2:
  total = 1000 + dice[1]*100 # (5,5,3) or (5,3,3) 이므로 sort한 상태에서는 가운데에 있는 값을 사용하면 된다.
else:
  total = 10000 + dice[0]*1000

print(total)