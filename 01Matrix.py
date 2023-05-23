#TC: O(m x n)
#SC: O(m x n)

from collections import deque

class Solution(object):

    def __isValid(self, matrix, r, c, nRows, nCols):
        if (r >= 0 and r < nRows and c >= 0 and c < nCols and matrix[r][c] == 1):
            return True
        return False

    def updateMatrix(self, matrix):
        
        if (matrix == None and len(matrix) == 0):
            return matrix

        nRows = len(matrix); nCols = len(matrix[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        visited = [[False for c in range(nCols)] for r in range(nRows)]

        queue = deque()

        for r in range(nRows):
            for c in range(nCols):
                if (matrix[r][c] == 0):
                    queue.append([r, c])
                    visited[r][c] = True

        level = 0

        while (len(queue) > 0):

            size = len(queue)
            for i in range(size):

                frontCell = queue.popleft()
                matrix[frontCell[0]][frontCell[1]] = level

                for direction in dirs:
                    newRow = frontCell[0] + direction[0]
                    newCol = frontCell[1] + direction[1]

                    if (self.__isValid(matrix, newRow, newCol, nRows, nCols) and
                            not visited[newRow][newCol]):
                        queue.append([newRow, newCol])
                        visited[newRow][newCol] = True

            level += 1

        return matrix
