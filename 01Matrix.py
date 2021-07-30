# Time Complexity : O(m*n)
# Space Complexity :O(m*n)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or len(mat) == 0:
            return mat
        q = deque()
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    mat[i][j] = -1

        while q:
            curr = q.popleft()
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                if r >= 0 and r < m and c >= 0 and c < n and mat[r][c] == -1:
                    q.append((r, c))
                    mat[r][c] = mat[curr[0]][curr[1]] + 1
        return mat