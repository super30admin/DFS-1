# time complexity: m*n
# space: m*n


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = collections.deque()
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        dist = 1

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    mat[i][j] = -1
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dir in directions:
                    r = curr[0] + dir[0]
                    c = curr[1] + dir[1]
                    if 0 <= r < m and 0 <= c < n and mat[r][c] == -1:
                        mat[r][c] = dist
                        q.append((r, c))
            dist += 1
        return mat
