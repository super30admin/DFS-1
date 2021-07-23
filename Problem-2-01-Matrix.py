class Solution:
    def updateMatrix(self, mat) :
        if mat == None or len(mat) == 0:
            return mat

        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        m = len(mat)
        n = len(mat[0])
        queue = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j))
                else:
                    mat[i][j] = -1

        while queue:
            curr = queue.popleft()
            for dir in dirs:
                r = curr[0] + dir[0]
                c = curr[1] + dir[1]
                if r >= 0 and r < m and c >= 0 and c < n and mat[r][c] == -1:
                    queue.append((r, c))
                    mat[r][c] = mat[curr[0]][curr[1]] + 1
        return mat
