# O(N*M) TIME AND O(N*M) SPACE WHERE N,M ARE ROWS,COLS OF MATRIX
from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        que = deque()
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == 0:
                    que.append((i,j))
                elif matrix[i][j] == 1:
                    matrix[i][j] = float("inf")
        
        while que:
            row,col = que.popleft()
            directions = [[1,0],[0,1],[-1,0],[0,-1]]
            for direction in directions:
                i = row + direction[0]
                j = col + direction[1]
                if i >= 0 and i < len(matrix) and j >= 0 and j < len(matrix[0]) and matrix[i][j] > 1 + matrix[row][col]:
                    matrix[i][j] = 1 + matrix[row][col]
                    que.append((i,j))
        return matrix