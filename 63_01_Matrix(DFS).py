# Gave me wrong answer on leetcode
# it is returning all 1's , not sure why.
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        # edge case
        if not matrix: return matrix
        # storing num of rows and columns
        m = len(matrix)
        n = len(matrix[0])
        # initializing dirs array
        # dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        result = [[0 for i in range(m)] for j in range(n)]
        # adding 0 to queue and making 1 as infinity.
        for i in range(m):
            for j in range(n):
                result[i][j] = self.dfs(matrix, result, i, j)
        return result

    def dfs(self, matrix, result, i, j):
        # edge case
        if not matrix: return matrix
        # base case
        if i < 0 or i >= len(matrix) or j < 0 or j >= len(matrix[0]): return float('inf')

        if i > 0 and matrix[i - 1][j] == 0: return 1
        if j > 0 and matrix[i][j - 1] == 0: return 1
        if i < len(matrix) - 1 and matrix[i + 1][j] == 0: return 1
        if j < len(matrix[0]) - 1 and matrix[i][j + 1] == 0: return 1

        top = left = float('inf')  # declare thema as infinity
        if i > 0 and result[i - 1][j] != 0:
            top = result[i - 1][j]
        if j > 0 and matrix[i][j - 1] != 0:
            left = result[i][j - 1]
        bottom = self.dfs(matrix, result, i + 1, j)
        right = self.dfs(matrix, result, i, j + 1)
        return min(left, right, top, bottom) + 1