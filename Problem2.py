# 542. 01 Matrix
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        q = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                elif mat[i][j] == 1:
                    mat[i][j] = -1

        print(q)
        dist = 1
        while q:
            # print(dist)
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dir_ in dirs:
                    nr = curr[0] + dir_[0]
                    nc = curr[1] + dir_[1]

                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = dist
                        q.append([nr,nc])
            dist += 1

        return mat


        