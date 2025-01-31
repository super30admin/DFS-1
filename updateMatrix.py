class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # BFS approach
        # TC : O(m*n)
        # SC : O(m*n)
        if mat is None or len(mat) == 0:
            return mat
        m,n =len(mat),len(mat[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        level = 0
        directions = [(0,1),(1,0),(-1,0),(0,-1)] # U L R D
        while q:
            cursize = len(q)
            while cursize > 0:
                i,j = q.popleft()
                cursize -= 1
                for di,dj in directions:
                    x,y = i+di,j+dj
                    if 0<=x<m and 0<=y<n and mat[x][y] == -1:
                        q.append((x,y))
                        mat[x][y] = level+1
            level += 1
        return mat
