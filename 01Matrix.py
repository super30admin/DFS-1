class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        rows = len(mat)
        cols = len(mat[0])

        dirs = [[0,1], [1,0], [-1,0], [0,-1]]

        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 1:
                    mat[r][c] = -1
                elif mat[r][c] == 0:
                    q.append((r, c))
        
        distance = 0
        while q:
            distance += 1
            for i in range(len(q)):
                curr = q.popleft()

                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]

                    if 0 <= nr < rows and 0 <= nc < cols and mat[nr][nc] == -1:
                        q.append((nr, nc))
                        mat[nr][nc] = distance
        return mat






                
        

        

