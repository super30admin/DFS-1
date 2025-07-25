# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        m = len(mat)
        n = len(mat[0])
        queue = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append([i, j])
                else:
                    mat[i][j] *= -1

        while queue:
            curr = queue.popleft()
            for k in dirs:
                nr = curr[0] + k[0]
                nc = curr[1] + k[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                    queue.append([nr, nc])
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1

        return mat