## Problem2 (https://leetcode.com/problems/01-matrix/)

# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode: Yes
# Approach: BFS

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        queue = deque()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append((i, j))
                else:
                    matrix[i][j] = -1
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while queue:
            curr = queue.popleft()
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == -1:
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1
                    queue.append((r, c))
        return matrix