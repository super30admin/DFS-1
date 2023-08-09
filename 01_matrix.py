# Time Complexity :O(m*N)
# Space Complexity :O(M*N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



from collections import deque


class Solution: 
    #BFS
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
        





        
