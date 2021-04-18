# Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return matrix

        m = len(matrix)
        n = len(matrix[0])

        q = list()

        for i in range(m):
            for j in range(n):

                if matrix[i][j] == 0:
                    q.append((i, j))

                else:
                    matrix[i][j] = -1

        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        while q:

            r, c = q.pop(0)

            for d in dirs:
                row = r + d[0]
                col = c + d[1]

                if 0 <= row < m and 0 <= col < n and matrix[row][col] == -1:
                    matrix[row][col] = matrix[r][c] + 1
                    q.append((row, col))

        return matrix
