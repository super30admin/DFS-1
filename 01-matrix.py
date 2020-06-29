# Time Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
# Space Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
from collections import deque
class Solution(object):
    # This approach uses a BFS where neighbors are processed level by level from
    # all 0s present in the matrix. The distance is incremented with every level
    # and set at the respective positions and the next level is added for processing.
    def updateMatrix(self, matrix):
        if not matrix:
            return matrix

        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        n, m = len(matrix), len(matrix[0])

        # queue init
        q = deque()
        # add all 0s to queue and placeholder at the place of 1s
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    q.appendleft((i, j))
                else:
                    matrix[i][j] = -1

        dist = 1
        # BFS
        while len(q) != 0:
            size = len(q)
            # visiting all nodes in level
            for _ in range(size):
                curr = q.pop()
                # visiting all neighbors for every node
                for dir in dirs:
                    r = dir[0] + curr[0]
                    c = dir[1] + curr[1]
                    # bounds and placeholder check
                    if 0 <= r < n and 0 <= c < m and matrix[r][c] == -1:
                        matrix[r][c] = dist
                        q.appendleft((r, c))
            dist += 1

        return matrix
