#Time Complexity: O(m*n)
#Space :O(m*n)
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix==None or len(matrix)==0:
            return matrix
        q=deque()
        m=len(matrix)
        n=len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    q.append((i,j))
                else:
                    matrix[i][j]=-1
        dist=0
        dirs=[[-1,0],[0,-1],[0,1],[1,0]]
        while q:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                for dir in dirs:
                    nr= curr[0]+dir[0]
                    nc=curr[1]+dir[1]
                    #check bounds
                    if nr>=0 and nc>=0 and nr<m and nc<n and matrix[nr][nc]==-1:
                        matrix[nr][nc]=dist+1
                        q.append((nr,nc))
            dist+=1
        return matrix
                        
                        
                    