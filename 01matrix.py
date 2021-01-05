'''
# Time complextiy: O(m*n); n= no of rows and m = no of cols
# Space complextiy: O(m*n);  n= no of rows and m = no of cols
'''

from collections import deque

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        m = len(matrix)
        n = len(matrix[0])
        
        queue = deque()
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append([i,j])
                else:
                    matrix[i][j] = -1
        level = 1
        while queue:
            size = len(queue)
            for i in range(size):
                temp =  queue.popleft()
                
                for d in dirs:
                    r = d[0] + temp[0]
                    c = d[1] + temp[1]
                    if r>=0 and r<m and c>=0 and c<n and  matrix[r][c] == -1:
                        matrix[r][c] = level
                        queue.append([r,c])
            level+=1
            
        return matrix
        