# Time Complexity : O(M*N) where m is number of rows and n is number of columns.
# Space Complexity : O(M*N)
# Did this code successfully run on LeetCode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def updateMatrix(self, matrix):
        # edge case
        if not matrix:
            return matrix
        queue = deque()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    queue.append((i, j))
                else:
                    matrix[i][j] = 9999  # change the original matrix

        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        while queue:
            size = len(queue)
            for i in range(size):
                current = queue.popleft()
                for dir in dirs:
                    new_row = dir[0] + current[0]
                    new_col = dir[1] + current[1]
                    if (0 <= new_row < len(matrix) and 0 <= new_col < len(matrix[0]) and matrix[new_row][new_col] >
                            matrix[current[0]][current[1]] + 1):
                        queue.append((new_row, new_col))
                        matrix[new_row][new_col] = (matrix[current[0]][current[1]]) + 1

        return matrix
