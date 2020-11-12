class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        from collections import deque
        q = deque()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.append((i, j))
                else:
                    matrix[i][j] = -1
        # print(matrix)
        dirs = ((1, 0), (0, 1), (-1, 0), (0, -1))
        # print(q)
        while q:
            popp = q.popleft()
            for dir in dirs:
                x = dir[0] + popp[0]
                y = dir[1] + popp[1]
                if x >= 0 and x < len(matrix) and y >= 0 and y < len(matrix[0]) and matrix[x][y] == -1:
                    matrix[x][y] = matrix[popp[0]][popp[1]] + 1
                    q.append((x, y))

        return matrix
