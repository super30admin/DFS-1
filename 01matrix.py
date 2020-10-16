"""
Problem: 733. Flood Fill
Leetcode: https://leetcode.com/problems/flood-fill/
Solution: BFS with memoization
Time Complexity: O(m*n), where m and n are rows and columns
Space Complexity: O(m*n), as we're storing all zero's in the queue
"""

from collections import deque


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:

        # variables
        nrows = len(matrix)
        ncols = len(matrix[0])
        dirs = [(-1, 0), (0, 1), (0, -1), (1, 0)]
        queue = deque()

        # base case
        if matrix is None or nrows is 0 or ncols is 0:
            return matrix

        # Put indexes of zeroes in queue and assign max value to non-zero's in matrix
        for i in range(nrows):
            for j in range(ncols):
                if matrix[i][j] == 0:
                    queue.append((i, j))
                else:
                    matrix[i][j] = float('inf')

        # Iterate through queue
        while queue:
            qsize = len(queue)
            # for each zero in the queue
            row_idx, col_idx = queue.popleft()
            # traverse around each direction of zero
            for dire in dirs:
                new_x = row_idx + dire[0]
                new_y = col_idx + dire[1]
                # if the new index is valid index in matrix and has non-zero value
                # and value of new index is greater than value of old index +1
                if self.isValid(new_x, new_y, matrix) and matrix[new_x][new_y] > matrix[row_idx][col_idx] + 1:
                    matrix[new_x][new_y] = matrix[row_idx][col_idx] + 1
                    # add this valid index to the queue
                    queue.append((new_x, new_y))
        # since we updated the input matrix in place
        return matrix

    def isValid(self, x, y, matrix):
        nrows = len(matrix)
        ncols = len(matrix[0])
        if 0 <= x < nrows and 0 <= y < ncols and matrix[x][y] != 0:
            return True
        return False

