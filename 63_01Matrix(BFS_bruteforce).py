# Accepted in leetcode(542)
# Time complexity - O(M^2*N^2), space - O(1)
# 1. we write a bfs function and for each cell call bfs to get the distance for 0.
class Solution:
    def updateMatrix(self, matrix):
        # edge case
        if len(matrix) == 0 or matrix is None:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] != 0:
                    matrix[i][j] = self.bfs(matrix, i, j)  # call bfs for each cell

        return matrix

    def bfs(self, matrix, i, j):
        queue = []
        queue.append([i, j])
        distance = 0
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]  # initialize a dirs array for moving.
        while queue:  # until queue is not empty
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)  # pop first element
                for dir in dirs:
                    r = dir[0] + curr[0]
                    c = dir[1] + curr[1]
                    if (r >= 0 and r < len(matrix) and
                            c >= 0 and c < len(matrix[0])):
                        if matrix[r][c] == 0:
                            return distance + 1
                        queue.append([r, c])
            distance = distance + 1