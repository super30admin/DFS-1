# // Time Complexity : O(mn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 

# Use BFS
# put -1 for 1 
# if 0 in matrix put that in queue as first level
# go through levels in BFS manner
# use directions array inside while -> for usin nested for i.e. while -> for -> for
# in that for loop change the value to level also update queue



class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        if len(matrix)==0: return matrix
        q = deque()
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==0:
                    q.append((i,j))
                else:
                    matrix[i][j]=-1
        directions = [(0,1),(1,0),(0,-1),(-1,0)]
        level=1
        while q:
            size = len(q)
            
            for i in range(size):
                cur = q.popleft()
                
                for dir in directions:
                    rd = cur[0]+dir[0]
                    cd = cur[1]+dir[1]
                    if(rd>=0 and cd>=0 and rd<len(matrix) and cd<len(matrix[0]) and matrix[rd][cd] == -1):
                        matrix[rd][cd] = level
                        q.append((rd,cd))
                        
            level+=1
        return matrix
                        
                    
                
        
                    
                    
                    
        