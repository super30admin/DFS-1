#TimeComplexity:O(N*M) 
#SpaceComplexity: (N*M) for queue
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m=len(matrix)
        n=len(matrix[0])
        queue=[]
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    queue.append((i,j))
                elif matrix[i][j]==1:
                    matrix[i][j]=float('inf')
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        while(queue):
            for index in [queue.pop(0)]:
                for dir in dirs:
                    i=index[0]+dir[0]
                    j=index[1]+dir[1]
                    if (i>=0 and j>=0 and i<m and j<n and matrix[index[0]][index[1]]+1 < matrix[i][j]):
                        matrix[i][j]=matrix[index[0]][index[1]]+1
                        queue.append((i,j))
        return matrix
                    
                    
        
        