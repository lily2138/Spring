
def getSum(data):
    sum=0
    for d in data:
        sum+=d
    return sum

def getMean(data):
    sum=0
    for d in data:
        sum+=d
    mean = sum/len(data)
    return mean

def getMax(data):
    max=data[0]
    for idx in range(len(data)):
        if(data[idx]>max):
            max=data[idx]
    return max

def getMin(data):
    min=data[0]
    for idx in range(len(data)):
        if(data[idx]<min):
            min=data[idx]
    return min

def getTwoSum(num2, num1=1):    #num1이 더 큰값이 왔을 때....
    sum=0
    if(num1>num2):
        num1, num2 = num2, num1 #두수를 스왑시킴
    for i in range(num1,num2+1):
        sum+=i
    return sum
