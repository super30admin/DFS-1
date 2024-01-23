#Time Complexity :O(m * n)
#Space Complexity :O(m * n)
#Did this code successfully run on Leetcode : yes
#Method: BFS


from ast import List
import collections


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        vis = [[0] * n for _ in range(m)]
        dist = [[0] * n for _ in range(m)]
        q = collections.deque()
        dirc = [(0, -1), (0, 1), (-1, 0), (1, 0)]
        for r in range(m):
            for c in range(n):
                if mat[r][c] == 0:
                    q.append((r,c,0))
                    vis[r][c] = 1
                else:
                    vis[r][c] = 0
        while q:
            row, col, steps = q.popleft()
            dist[row][col] = steps

            for i in range(4):
                nrow = row + dirc[i][0]
                ncol = col + dirc[i][1]

                if 0 <= nrow < m and 0 <= ncol < n and vis[nrow][ncol] == 0:
                    q.append((nrow, ncol, steps + 1))
                    vis[nrow][ncol] = 1
        return dist

        