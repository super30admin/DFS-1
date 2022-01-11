# Time Complexity - O(2*m*n) - First traversal to put all the 0's in. Second traversal is for the BFS.
# Space Complexity - O(m*n)
from collections import deque
class Solution:
    def updateMatrix(self, mat) :
        # BFS Approach
        if mat is None or len(mat) == 0: return mat
        m = len(mat)
        n = len(mat[0])

        q = deque()
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                elif mat[i][j] == 1:
                    mat[i][j] = -1

        level = 1
        while q:
            qLen = len(q)
            for i in range(qLen):
                curr = q.popleft()
                for direction in dirs:
                    new_row = curr[0] + direction[0]
                    new_col = curr[1] + direction[1]
                    if new_row >= 0 and new_row < m and new_col < n and mat[new_row][new_col] == -1:
                        mat[new_row][new_col] = level
                        q.append((new_row, new_col))

            level += 1

        return mat