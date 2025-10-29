class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        ROWS, COLS = len(mat), len(mat[0])
        res = [[inf]*COLS for _ in range(ROWS)]
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        q = deque()
        for r in range(ROWS):
            for c in range(COLS):
                if mat[r][c] == 0:
                    res[r][c] = 0
                    q.append((r,c))

        while q:
            l = len(q)
            for _ in range(len(q)):
                cur = q.popleft()
                for i, j in dirs:
                    newr, newc = cur[0]+i, cur[1]+j
                    if 0<= newr < ROWS and 0<= newc < COLS and mat[newr][newc] == 1:
                        res[newr][newc] = 1 + res[cur[0]][cur[1]]
                        mat[newr][newc] = -1
                        q.append((newr,newc))
        return res        
