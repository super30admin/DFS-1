//Time complexity: o(m*n)
//space complexit: o(m*n)
from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        dirs = [[1,0],[0,1],[0,-1],[-1,0]]
        r = len(matrix)
        c = len(matrix[0])
        queue = deque()
        for i in range(r):
            for j in range(c):
                if matrix[i][j] == 0:
                    queue.append([i,j])
                else:
                    matrix[i][j] = sys.maxsize
        while queue:
            start_r,start_c = queue.popleft()
            for i in range(len(dirs)):
                r1 = start_r+dirs[i][0]
                c1 = start_c+dirs[i][1]
                if 0<=r1<r and 0<=c1<c and matrix[r1][c1] == sys.maxsize:
                    matrix[r1][c1] = 1 + matrix[start_r][start_c]
                    queue.append([r1,c1])
        return matrix
