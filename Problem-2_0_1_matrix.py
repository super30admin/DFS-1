# APPROACH  1
# Time Complexity : O(nm), n: number of rows of the matrix, m: number of columns of the matrix
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Add all cell positions to the queue whose value is 0. Can start BFS with it. 
# 2. Set all non-zero nodes with negative sign (to mark it as not visited and then we can change it to distance value and not process again).
# 3. Run BFS, check if it's a valid position and if negative value, set it to distance
# 4. Distance is inc by 1 after processing a level (by maintaining a size var).

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        if matrix is None:
            return None
        
        queue, dist, dirs = deque(), 1, [[0, -1], [0, 1], [-1, 0], [1, 0]]
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 0:
                    queue.append((row, col))                
                else:
                    matrix[row][col] = -1
           
        
        while len(queue) > 0:
            size =  len(queue)
            while size > 0:
                pos = queue.popleft()
                for nei in dirs:
                    if pos[0] + nei[0] >= 0 and pos[0] + nei[0] < len(matrix) and pos[1] + nei[1] >= 0 and pos[1] + nei[1] < len(matrix[0]) and matrix[pos[0] + nei[0]][pos[1] + nei[1]] == -1:
                        matrix[pos[0] + nei[0]][pos[1] + nei[1]] = dist
                        queue.append((pos[0] + nei[0], pos[1] + nei[1]))
                        
                size -= 1
                
            dist += 1
            
        return matrix
                        
                        
                        
                        

# APPROACH  2
# Time Complexity : O(nm), n: number of rows of the matrix, m: number of columns of the matrix
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as Approach 1. Instead of maintaining a dist var, set cell distance as 1 + that cell's value from which this cell is accessed.

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        if matrix is None:
            return None
        
        queue, dirs = deque(), [[0, -1], [0, 1], [-1, 0], [1, 0]]
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 0:
                    queue.append((row, col))                
                else:
                    matrix[row][col] = -1
           
        
        while len(queue) > 0:
            size =  len(queue)
            while size > 0:
                pos = queue.popleft()
                for nei in dirs:
                    if pos[0] + nei[0] >= 0 and pos[0] + nei[0] < len(matrix) and pos[1] + nei[1] >= 0 and pos[1] + nei[1] < len(matrix[0]) and matrix[pos[0] + nei[0]][pos[1] + nei[1]] == -1:
                        matrix[pos[0] + nei[0]][pos[1] + nei[1]] = matrix[pos[0]][pos[1]] + 1
                        queue.append((pos[0] + nei[0], pos[1] + nei[1]))
                        
                size -= 1
                
            
        return matrix
                        
                        
                        
                        
                        

# APPROACH  3
# Time Complexity : O(nm), n: number of rows of the matrix, m: number of columns of the matrix
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as Approach 1. Instead of setting non-zero nodes as negative set as infinty.
# 2. In BFS, check if the cells value is greater than the 1 + that cell's value from which this cell is accessed. If so update it with min value.

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        if matrix is None:
            return None
        
        queue, dirs = deque(), [[0, -1], [0, 1], [-1, 0], [1, 0]]
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 0:
                    queue.append((row, col))                
                else:
                    matrix[row][col] = float('inf')
           
        
        while len(queue) > 0:
            size =  len(queue)
            while size > 0:
                pos = queue.popleft()
                for nei in dirs:
                    if pos[0] + nei[0] >= 0 and pos[0] + nei[0] < len(matrix) and pos[1] + nei[1] >= 0 and pos[1] + nei[1] < len(matrix[0]) and matrix[pos[0] + nei[0]][pos[1] + nei[1]] > matrix[pos[0]][pos[1]] + 1:
                        matrix[pos[0] + nei[0]][pos[1] + nei[1]] = matrix[pos[0]][pos[1]] + 1
                        queue.append((pos[0] + nei[0], pos[1] + nei[1]))
                        
                size -= 1
                
            
        return matrix
                        
