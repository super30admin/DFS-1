from collections import deque


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or len(mat) == 0:
            return mat
        m = len(mat)
        n = len(mat[0])
        q = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i, j])
                else:
                    mat[i][j] = -1
        # dist = 1
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        while q:
            # size = len(q)
            # for i in range(size):
            curr = q.popleft()
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                if r >= 0 and c >= 0 and r < m and c < n and mat[r][c] == -1:
                    # mat[r][c] = dist
                    mat[r][c] = mat[curr[0]][curr[1]] + 1
                    q.append([r, c])
        # dist += 1
        return mat

# BFS
# Time complexity : O(m * n)
# Space complexity : O(m * n)
# Did this code successfully run on Leetcode? Yes
# Any problem you faced while coding this? No
