class Solution:
    """
    Simply treat the ones and zeros as levels and lookl in all direction
    TC - O(nxm)
    SC - O(nxm)
    """
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        r = []
        c = []
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    r.append(i)
                    c.append(j)
                else:
                    mat[i][j] = -1
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        lvl = 1
        while len(r) > 0:
            size = len(r)
            for i in range(size):
                row = r.pop(0)
                col = c.pop(0)
                for d in dirs:
                    nr = d[0] + row
                    nc = d[1] + col
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                        r.append(nr)
                        c.append(nc)
                        mat[nr][nc] = lvl
            lvl += 1
        return mat
