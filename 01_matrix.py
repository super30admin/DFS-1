# Time Complexity :bfs=O(m*N) DFS=O(MN*MN)
# Space Complexity :O(M*N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


# BFS
from collections import deque
class Solution: 
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q= deque([])
        m=len(mat)
        n=len(mat[0])
        result=[[None for i in range(n)] for i in range(m)]
        directions=[(-1,0),(0,-1),(1,0),(0,1)]
        for i in range(m):
            for j in range(n):
                if(mat[i][j]==0):
                    q.append((i,j))
                    result[i][j]=0
        print(result)
        while(len(q)):
            curr=q.popleft()
            for d in directions:
                nr=curr[0]+d[0]
                nc=curr[1]+d[1]
                if(nr>=0 and nr<m and nc>=0 and nc<n and result[nr][nc]==None):
                    if(mat[nr][nc]==1):
                        result[nr][nc]=result[curr[0]][curr[1]]+1
                        q.append((nr,nc))
        return result
    
# DFS
from collections import deque
class Solution:        
    def dfs(self, mat, i, j, result):
        if(i<0 or i>=len(mat) or j<0 or j>=len(mat[0])):
            return float('inf')
        
        if(mat[i][j]==0):
            return 0
        # top
        if(i>0 and mat[i-1][j]==0):
            return 1
        # left
        if(j>0 and mat[i][j-1]==0):
            return 1
        # down
        if(i<len(mat)-1 and mat[i+1][j]==0):
            return 1
        # right
        if(j<len(mat[0])-1 and mat[i][j+1]==0):
            return 1

        if(i>0 and result[i-1][j]!=None):
            top=result[i-1][j]
        else:
            top=float('inf')
        if(j>0 and result[i][j-1]!=None):
            left=result[i][j-1]
        else:
            left=float('inf')
        down=self.dfs(mat, i+1, j, result)
        right=self.dfs(mat, i, j+1, result)

        return min(top, left, down, right)+1
        
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m=len(mat)
        n=len(mat[0])
        result=[[None for i in range(n)] for j in range(m)]
        for i in range(m):
            for j in range(n):
                result[i][j]=self.dfs(mat, i, j, result)
        return result




        
