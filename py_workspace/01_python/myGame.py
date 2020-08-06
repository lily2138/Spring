import random

def makeLotto(num):
    for idx in range(num):
        randNum = random.sample(range(1, 46), 6)
        randNum.sort()
        print(randNum)
        
# A+ : 4.5, A : 4.3, A- : 4.0, B+ : 3.5, B: 3.3, B-: 3.0, C : 2.5, D : 1.5
def meanGrade(grade):
    score = grade.split(',')
    sum=0
    for s in score:
        if s=='A+':
            sum+=4.5
        elif s=='A':
            sum+=4.3
        elif s=='A-':
            sum+=4.0
        elif s=='B+':
            sum+=3.5
        elif s=='B':
            sum+=3.3
        elif s=='B-':
            sum+=3.0
        elif s=='C':
            sum+=2.5
        elif s=='D':
            sum+=1.5
        else:
            errorResult="잘못된 학점이 있습니다"
            return errorResult
        mean = sum/len(score)
    return mean
