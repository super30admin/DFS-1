#timecomplexity O(m*n)
#spacecomplexity O(m*n)
#https://leetcode.com/problems/01-matrix/
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        queue=[]
        m=len(matrix)
        n=len(matrix[0])
        dist=1
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    queue.append([i,j])
                else:
                    matrix[i][j]=-1 #making it -1 to keep a track as visited
        
        _dir=[[0,1],[1,0],[-1,0],[0,-1]]
        while queue:
            size=len(queue) #getting size so that processing element which are present first at level 1 and then so on
            for s in range(size):
                temp=queue.pop(0)
                for d in _dir:
                    x=temp[0]+d[0]
                    y=temp[1]+d[1]
                    if (x>=0 and x<m) and (y>=0 and y<n) and matrix[x][y]==-1:
                        queue.append([x,y])
                        matrix[x][y]=dist
            dist+=1
        return matrix
                    
            
            
                    