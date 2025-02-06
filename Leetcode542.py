#Time Complexity = O(m*n)
#Space Complexity = O(m*n)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m,n = len(mat) , len(mat[0])

        dirs = [(1,0),(0,1),(-1,0),(0,-1)]

        visited = [[False] * n for i in range(m)]

        q = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                    visited[i][j] = True
        level = 1
        while q:
            size = len(q)
            for i in range(size):
                cr,cc = q.popleft()
                for dr, dc in dirs:
                    nr, nc = dr+ cr ,  dc + cc
                    if nr < 0 or nr >= m or nc < 0 or nc >= n or visited[nr][nc]:
                        continue
                    mat[nr][nc] = level
                    visited[nr][nc] = True
                    q.append((nr,nc))
            level += 1
        
        return mat
