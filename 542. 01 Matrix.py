# Time: O(m * n)
# Space: O(m * n)

# At first loop through the matrix and put all the zeros in the queue and if it's 1 then change it to -1 to keep track of the 1s given in the question
# After that loop on every level in bfs and every level is dist away from the nearest zero.
# So check in all directions and then when we find -1 add that to the q and change the curr value to the dist.
# On every level add 1 to the distance and at the end return the matrix
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                elif mat[i][j] == 1:
                    mat[i][j] = -1

        direc = [[0,1],[1,0],[0,-1],[-1,0]]
        dist = 1
        while q:
            size = len(q)
            for i in range(size):
                currR, currC = q.popleft()
                for r,c in direc:
                    nr = currR + r
                    nc = currC + c
                    if 0 <= nr < m and 0 <= nc < n and mat[nr][nc] == -1:
                        q.append((nr,nc))
                        mat[nr][nc] = dist
            dist += 1
        return mat