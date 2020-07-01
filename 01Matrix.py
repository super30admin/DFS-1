from queue import Queue
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m=len(matrix)
        n=len(matrix[0])
        q=Queue()
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    q.put([i,j])
                else:
                    matrix[i][j]=-1
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        dist=1
        while(not(q.empty())):
            size=q.qsize()
            #level processing
            for i in range(size):
                curr=q.get()
                for dir in dirs:
                    r=curr[0]+dir[0]
                    c=curr[1]+dir[1]
                    if r>=0 and r<m and c>=0 and c<n and matrix[r][c]==-1:
                        matrix[r][c]=dist
                        q.put([r,c])
                        
            dist+=1
        return matrix
Time is O(mn)
Space is O(mn) maximum element in Queue is m*n//2 as BFS
