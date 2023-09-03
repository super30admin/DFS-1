# ## Problem2 (https://leetcode.com/problems/01-matrix/)


# BFS Approach
# // Time Complexity :O(m * n)
# // Space Complexity :O(m * n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :Difficulty visualising q and how it would work


# // Your code here along with comments explaining your approach
from collections import deque


class Solution:
    def updateMatrix(self, mat):
        # if matrix not present
        if not mat:
            return mat
        # variables for no(rows) and no(cols)
        m = len(mat)
        n = len(mat[0])
        # 4 directional array
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        # queue of all 0 coordinates
        q = deque()
        # converting all 0s to -1
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    # else adding it to q
                    q.append((i, j))
        # starting with distance 1
        distance = 1
        # starting BFS
        while q:
            size = len(q)
            for i in range(size):
                # popping left most element
                node = q.popleft()
                for direction in directions:
                    nr = node[0] + direction[0]
                    nc = node[1] + direction[1]
                    # in bounds and not processed till now
                    if (0 <= nr < m and 0 <= nc < n and mat[nr][nc] == -1):
                        mat[nr][nc] = distance
                        q.append((nr, nc))
            distance += 1
        return mat
