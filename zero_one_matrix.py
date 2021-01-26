# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I put all the zeros in BFS queue and use BFS to process all the distance 1 ones and then
# all the distance 2 ones and so on. Eventually all the positions will have their distances

from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        q = deque()
        rows = len(matrix)
        columns = len(matrix[0])
        directions = [(0, -1), (1, 0), (0, 1), (-1, 0)]
        
        for i in range(rows):
            for j in range(columns):
                if matrix[i][j] == 0:
                    q.append((i,j))
                else:
                    matrix[i][j] = matrix[i][j]*-1
                    
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                current = q.popleft()
                for direction in directions:
                    x = current[0] + direction[0]
                    y = current[1] + direction[1]
                    
                    if x >= 0 and y >= 0. and x < rows and y < columns and matrix[x][y] < 0:
                        matrix[x][y] *= -1
                        matrix[x][y] = matrix[current[0]][current[1]] + 1
                        q.append((x,y))
                        
        return matrix