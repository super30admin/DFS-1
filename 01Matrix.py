class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m=len(matrix)
        n=len(matrix[0])
        
        queue=[]
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    queue.append((i,j))
                else:
                    matrix[i][j]=-1
        
        directions=[(0,1),(0,-1),(1,0),(-1,0)]
    
        while queue:
            row,col=queue.pop(0)
            
            for r,c in directions:
                r1=row+r
                c1=col+c
                
                if (r1>=0 and r1<m) and (c1>=0 and c1<n) and matrix[r1][c1]==-1:
                    queue.append((r1,c1))
                    matrix[r1][c1]=matrix[row][col]+1

        return matrix
        
            