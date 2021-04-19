from collections import deque

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        queue = deque()
        m,n = len(matrix), len(matrix[0])
        
        # Change all positive values to negative indicating they are yet to proceed, append zeros to queue
        for row in range(m):
            for col in range(n):
                value = matrix[row][col]
                if value:
                    matrix[row][col] *= -1
                else:
                    queue.append((row,col))
                
        
        directions = [(0,1), (0,-1), (1,0), (-1,0)]
        
        ### BFS
        while queue:
            row, col = queue.popleft()
            
            for dx,dy in directions:
                new_r, new_c = row+dx, col+dy
                
                # Negative value means that cell has not been processed yet.
                if new_r >= 0 and new_c >= 0 and new_r < m and new_c < n and matrix[new_r][new_c] < 0: 
                    matrix[new_r][new_c] = matrix[row][col] + 1
                    queue.append((new_r, new_c))
                    
        return matrix

### Complexity Analysis

# Time Complexity: O(mxn) --> Visiting the entire matrix in worst case
# Space Complexity: O(mxn) --> Space occupied by the queue 