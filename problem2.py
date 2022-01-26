#Time Complexity O(n)
#Space Complexity O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        # Checing base condition
        if s == None or len(s) ==0:
            return s
        strStack = []
        numsStack = []
        curr = ""
        num = 0
        
        for i in s:
            if i.isdigit():
                num = num * 10 + ord(i) - ord('0')
            elif i == '[':
                numsStack.append(num)
                strStack.append(curr)
                num = 0
                curr = ""
            elif i == ']':
                nu = numsStack.pop()
                child = ""
                for x in range(nu):
                    child = child+curr
                parent = strStack.pop()
                curr = parent+child
            else:
                curr = curr + i
        
        return curr
                
                
            
            
        
