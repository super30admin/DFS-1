"""
Time complexity O(M x N)
Space complexity O(M x N)

BFS Solution
"""


class Sol_updateMatrix_BFS:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix is None and len(matrix)==0:
            return matrix
        
        m=len(matrix)
        n=len(matrix[0])
        q=[]
        for i in range(m):
            for j in range(n):
                if(matrix[i][j]==0):
                    q.append([i,j])
                else:
                    matrix[i][j]=-1
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        while q:
            curr=q.pop(0)
            for dir in dirs:
                r=dir[0]+curr[0]
                c=dir[1]+curr[1]
                if(r>=0 and r<m and c>=0 and c<n and matrix[r][c]==-1):
                    matrix[r][c]=matrix[curr[0]][curr[1]]+1
                    q.append([r,c])
                    
        return matrix
        