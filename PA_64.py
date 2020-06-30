#LC 542 - 01 Matrix
#Time Complexity - O(m*n)
#Space Complexity - O(m*n)
from collections import deque
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if not matrix:
            return matrix
        q = deque()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.append([i,j])
                else:
                    matrix[i][j] = -1
        if len(q) == 0:
            return matrix
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        level = 1
        while q:
            l = len(q)
            for i in range(l):
                x,y = q.popleft()
                for d in dirs:
                    r = x + d[0] 
                    c = y + d[1]
                    if r >=0 and r < len(matrix) and c >= 0 and c < len(matrix[0]) and matrix[r][c] == -1:
                        matrix[r][c] = level
                        q.append([r,c])
            level = level + 1
        return matrix