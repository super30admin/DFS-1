class Solution:
    def updateMatrix(self, mat):
        m = len(mat)
        n = len(mat[0])

        INF = 100000

        dist = [[INF] * n for _ in range(m)]
       # two -  pass DFS DP approach
        # top-left -> bottom-right
        for r in range(m):
            for c in range(n):
                if mat[r][c] == 0:
                    dist[r][c] = 0
                else:
                    if r > 0:
                        dist[r][c] = min(dist[r][c], dist[r-1][c] + 1)
                    if c > 0:
                        dist[r][c] = min(dist[r][c], dist[r][c-1] + 1)

        # bottom-right -> top-left
        for r in range(m-1, -1, -1):
            for c in range(n-1, -1, -1):
                if r < m-1:
                    dist[r][c] = min(dist[r][c], dist[r+1][c] + 1)
                if c < n-1:
                    dist[r][c] = min(dist[r][c], dist[r][c+1] + 1)

        return dist

    # TC = O(mxn)
    # SC = O(mxn)