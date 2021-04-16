"""
Approach 1 - BFS
TC - O(m*n)
SC - O(m*n)
"""
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if (not matrix or len(matrix) == 0):
            return matrix
        
        
        queue = []
        rows = len(matrix)
        columns = len(matrix[0])
        
        count = 0 
        for i in range(rows):
            for j in range(columns):
                if matrix[i][j] == 0:
                    queue.append((i,j))
                else:
                    count += 1
                    matrix[i][j] = -1
        #print(queue)
        if count == 0:
            return matrix
        
        level = 1
        #directions = [(0,1), (0,-1), (1,0), (-1,0)]
        while queue:
            size = len(queue)
            for i in range(size):
                current = queue.pop(0)
                directions = [(0,1), (0,-1), (1,0), (-1,0)]
                for direct in directions:
                    r = current[0] + direct[0]
                    c = current[1] + direct[1]
                    if(r >= 0 and r < rows and c >= 0 and c < columns and matrix[r][c] == -1):
                        matrix[r][c] = level
                        queue.append((r,c))
            level += 1  
        return matrix
    
"""
Approach 2 - BFS no level or size
"""
"""
Approach 1 - BFS
TC -
SC -
"""
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if (not matrix or len(matrix) == 0):
            return matrix
        
        
        queue = []
        rows = len(matrix)
        columns = len(matrix[0])
        
        count = 0 
        for i in range(rows):
            for j in range(columns):
                if matrix[i][j] == 0:
                    queue.append((i,j))
                else:
                    count += 1
                    matrix[i][j] = -1
        #print(queue)
        if count == 0:
            return matrix
        
        #level = 1
        directions = [(0,1), (0,-1), (1,0), (-1,0)]
        while queue:
            #size = len(queue)
            #for i in range(size):
            current = queue.pop(0)
            #directions = [(0,1), (0,-1), (1,0), (-1,0)]
            for direct in directions:
                r = current[0] + direct[0]
                c = current[1] + direct[1]
                if(r >= 0 and r < rows and c >= 0 and c < columns and matrix[r][c] == -1):
                    matrix[r][c] = matrix[current[0]][current[1]] + 1
                    queue.append((r,c))
            #level += 1  
        return matrix
    
"""
DFS is not good since there are times where certains nodes are not processed which are required
"""