class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # Time Complexity: O(n*m)
        # Space Complexity: O(n*m)
        rowlen = len(mat)
        collen = len(mat[0])
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        lvl = prv_lvl = 0
        # BFS APPROACH
        dq = collections.deque()
        for r in range(rowlen):
            for c in range(collen):
                if mat[r][c] == 0:
                    dq.append((r, c, lvl))
                if mat[r][c] == 1:
                    mat[r][c] = -1
        # print(dq)
        # print(mat)
        while dq:
            r, c, lvl = dq.popleft()

            # mat[r][c] = lvl
            # print(r,c, mat[r][c])

            for dirr in dirs:
                nr = r + dirr[0]
                nc = c + dirr[1]
                if nr >= 0 and nr < rowlen and nc >= 0 and nc < collen and mat[nr][nc] == -1:
                    mat[nr][nc] = lvl + 1
                    dq.append((nr, nc, lvl + 1))
            # print(mat)
            # print(dq)
        return mat