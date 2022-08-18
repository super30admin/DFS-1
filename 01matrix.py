#542. 01 Matrix
"""
Time Complexity : O(m*n)
Space Complexity :  O(m*n)
"""
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        dirs = [[1,0], [-1,0], [0,-1], [0,1]]
        #         R      L       U      D 
        q = Deque()
        visited = [[False] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                    visited[i][j] = True

        while q:
            i, j = q.popleft()
            for d in dirs:
                x = i + d[0]
                y = j + d[1]
                if x < 0 or x == m or y < 0 or y == n:
                    continue
                if visited[x][y] == False:
                    mat[x][y] = mat[i][j] + 1
                    q.append((x, y))
                    visited[x][y] = True

        return mat 
