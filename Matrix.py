# BFS Approach
# Time Complexity => O(N^2)
# Space Complexity => O(N)
from pip import List
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if(len(mat)==0):
            return mat
        m = len(mat)
        n = len(mat[0])
        dirs = [[0,-1],[-1,0],[0,1],[1,0]]
        queue = []
        for i in range(m):
            for j in range(n):
                if(mat[i][j]==0):
                    queue.append([i,j])
                elif(mat[i][j]==1):
                    mat[i][j] = -1
        dist = 1
        while(len(queue)!=0):
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                for d in dirs:
                    nr = curr[0]+d[0]
                    nc = curr[1]+d[1]
                    if(nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]== -1):
                        mat[nr][nc] = dist
                        queue.append([nr,nc])
            dist+=1
        return mat