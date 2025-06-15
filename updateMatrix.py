class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        directions = [[1,0],[0,1],[-1,0],[0,-1]]
        # cnt = 0
        q = deque()
        m = len(mat)
        n = len(mat[0])
        q = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j]==1:
                    mat[i][j]=-1
                else:
                    q.append([i,j])

        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        while q:
            r,c = q.popleft()

            for dr, dc in directions:
                row = dr+r
                col = dc+c

                if 0<=row<m and 0<=col<n and mat[row][col]==-1:
                    mat[row][col] = mat[r][c]+1
                    q.append([row,col])
 
        return mat

                    

