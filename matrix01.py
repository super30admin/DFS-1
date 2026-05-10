# 4 solutions to this problem: bfs from 0 or 1's, dfs from 0's or 1's
# bfs is ideal because it will find nearest 0 (upper parts of the tree)


# BFS FROM ZEROES
# time O(n*m), space O(n*m)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = deque()
        print(m)

        for i in range(0, m):
            for j in range(0, n):
                print(i)
                if mat[i][j] == 0:
                    q.append([i, j])
                else:
                    mat[i][j] *= -1

        directions = [(0, 1), (-1, 0), (1, 0), (0, -1)]
        dist = 1
        
        while q:
            for _ in range(len(q)):
                row, col = q.popleft()
                for dir in directions:
                    nr = row + dir[0]
                    nc = col + dir[1]
                    if nr in range(m) and nc in range(n) and mat[nr][nc] == -1:
                        q.append([nr, nc])
                        mat[nr][nc] = dist
            dist += 1

        return mat



# bfs from ones
# O(n^2*m^2) time, o(nm) space

class Solution:
    def updateMatrix(self, mat):
        self.dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        self.m = len(mat)
        self.n = len(mat[0])

        def bfs(i, j):
            q = deque()
            q.append([i, j])
            visited = [[False]*self.n for _ in range(self.m)]
            visited[i][j] = True
            dist = 1
            print('---')
            print(q)
            while q:
                size = len(q)
                print(q)
                print(dist)
                for _ in range(size):
                    curr = q.popleft()
                    for d in self.dirs:
                        r = curr[0] + d[0]
                        c = curr[1] + d[1]
                        if 0 <= r < self.m and 0 <= c < self.n:
                            if mat[r][c] == 0:
                                return dist
                            elif not visited[r][c]:
                                visited[r][c] = True
                                q.append([r, c])
                dist += 1

            return -1

        for i in range(self.m):
            for j in range(self.n):
                if mat[i][j] == 1:
                    mat[i][j] = bfs(i, j)

        return mat
