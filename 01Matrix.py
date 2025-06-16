# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or len(mat) == 0: return mat
        m = len(mat)
        n = len(mat[0])
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    q.append((i,j))
        dist = 1
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for row, col in dirs:
                    nr = row + curr[0]
                    nc = col + curr[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        q.append((nr,nc))
                        mat[nr][nc] =dist
            dist += 1
        return mat
