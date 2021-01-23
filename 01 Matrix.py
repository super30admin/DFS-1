from collections import deque

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        #Approach: BFS
        #Time Complexity: O(m * n)
        #Space Complexity: O(m * n)
        
        m = len(matrix)
        n = len(matrix[0])
        
        de = deque()
        for r in range(m):
            for c in range(n):
                if matrix[r][c] == 0:
                    de.append((r, c))
                else:
                    matrix[r][c] = -1
        
        dirArr = [(-1, 0), (0, -1), (0, 1), (1, 0)]     
        
        while de:
            popped = de.popleft()
            
            for d in dirArr:
                r = popped[0] + d[0]
                c = popped[1] + d[1]
                
                if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == -1:
                    de.append((r, c))
                    matrix[r][c] = matrix[popped[0]][popped[1]] + 1
                    
        return matrix