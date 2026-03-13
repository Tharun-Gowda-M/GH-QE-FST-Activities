# Calculate the sum of numbers (if input is 10 then it goes on like 10+9+8+7....+1 )
# using recursion
def sum(n):
  if n <= 1:
    return n
  else:
    return n + sum(n-1)
  
num = int(input("Enter a number: "))
print("The sum is: ", sum(num))