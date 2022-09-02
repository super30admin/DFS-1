'''
Time complexity - O(m*n)
Space complexity - O(m*n)
'''


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if len(mat) == 0:
            return mat
        m = len(mat)
        n = len(mat[0])
        q = deque()
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        dist = 0
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    q.append((i, j))
        if len(q) == 0:
            return mat
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    r = curr[0] + d[0]
                    c = curr[1] + d[1]
                    if r >= 0 and r < m and c >= 0 and c < n and mat[r][c] == -1:
                        q.append((r, c))
                        mat[r][c] = dist + 1
            dist += 1
        return mat
