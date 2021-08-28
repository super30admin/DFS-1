from queue import Queue
import sys


class Solution:
    """
    Time complexity: no. of zeroes * O(r*c)
    Space complexity: O(1)
    """

    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix is None or len(matrix) is 0:
            return matrix

        r = len(matrix)
        c = len(matrix[0])
        q = Queue()

        for i in range(r):
            for j in range(c):
                if matrix[i][j] is 0:
                    q.put((i, j))
                elif matrix[i][j] is 1:
                    matrix[i][j] = sys.maxsize

        dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        while not q.empty():

            front = q.get()

            for dirs in dir:
                i = front[0] + dirs[0]
                j = front[1] + dirs[1]

                if i >= 0 and i < r and j >= 0 and j < c and matrix[front[0]][front[1]] + 1 < matrix[i][j]:
                    q.put((i, j))
                    matrix[i][j] = matrix[front[0]][front[1]] + 1

        return matrix
