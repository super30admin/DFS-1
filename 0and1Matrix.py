#Time complexity: O(n)
#Space complexity: O(n)
from collections import deque


class Solution:
    def updateMatrix(self, mat):
        q=deque()
        dirs=[(1,0),(-1,0),(0,1),(0,-1)]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    mat[i][j]=-1
        steps=1
        while q:
            for i in range(len(q)):
                ci,cj=q.popleft()
                for d in dirs:
                    r=ci+d[0]
                    c=cj+d[1]
                    if r>=0 and r<len(mat) and c>=0 and c<len(mat[0]):
                        if mat[r][c]==-1:
                            mat[r][c]=steps
                            q.append((r,c))
                        
            steps+=1
        return mat
                    
                
            
                    
        