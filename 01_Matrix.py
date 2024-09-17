# BFS Approach since we want to get the nearest distance
# Time - O(M * N)
# Space - O(M * N)

from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        if not matrix or len(matrix) == 0:
            return matrix
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        q = deque()
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 0:
                    q.append((i,j))
                    
                else:
                    matrix[i][j] = -1
                    
        distance = 1
        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]

        while q:
            size = len(q)
            
            for i in range(size):
                
                r, c = q.popleft()
                for dir in dirs:
                    cr = r + dir[0]
                    cc = c + dir[1]
                    
                    if cr >= 0 and cr < rows and cc >= 0 and cc < cols and matrix[cr][cc] == -1:
                        q.append((cr, cc))
                        matrix[cr][cc] = distance
                        
            distance += 1
                
        return matrix
                
            
            
        