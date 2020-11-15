class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:

        if matrix is None or len(matrix)==0:
            return matrix

        m = len(matrix)
        n = len(matrix[0])

        q=collections.deque()

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append((i,j))
                else:
                    matrix[i][j]=-1
        dist =1
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        while q:
            size = len(q)
            for _ in range(size):
                cur = q.popleft()
                for d in dirs:
                    r = d[0] + cur[0]
                    c = d[1] + cur[1]

                    if (r in range(m) and c in range(n) and matrix[r][c]==-1):
                        matrix[r][c] = dist
                        q.append((r,c))


            dist+=1

        return matrix
