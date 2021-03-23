'''
TC: O(n)
SC: O(n)
'''
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return matrix
        n = len(matrix)
        m = len(matrix[0])
        q = []
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    q.append([i, j])
                else:
                    matrix[i][j] = float('inf')

        while q:
            n, m = q.pop(0)

            if n >= 0 and n < len(matrix) and m >= 0 and m < (len(matrix[0]) - 1) and matrix[n][m + 1] == float('inf'):
                matrix[n][m + 1] = matrix[n][m] + 1
                q.append([n, m + 1])

            if n >= 0 and n < len(matrix) and m > 0 and m < len(matrix[0]) and matrix[n][m - 1] == float('inf'):
                matrix[n][m - 1] = matrix[n][m] + 1
                q.append([n, m - 1])

            if n >= 0 and n < (len(matrix) - 1) and m >= 0 and m < (len(matrix[0])) and matrix[n + 1][m] == float(
                    'inf'):
                matrix[n + 1][m] = matrix[n][m] + 1
                q.append([n + 1, m])

            if n > 0 and n < len(matrix) and m >= 0 and m < (len(matrix[0])) and matrix[n - 1][m] == float('inf'):
                matrix[n - 1][m] = matrix[n][m] + 1
                q.append([n - 1, m])

        return matrix