class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if len(mat) == None: return mat
        m = len(mat)
        n = len(mat[0])
        q = []
        dirs = [[0, 1],[0, -1],[1, 0],[-1, 0]]
        # dirs = [right, left, down, up]
        for i in range(0, m):
            for j in range(0, n):
                if mat[i][j] == 0:
                    q.append([i, j])
                    
                elif mat[i][j] == 1:
                    mat[i][j] == -1
                    
        lvl = 1
        while q:
            size = len(q)
            for i in range(0, size):
                curr= q.pop(0)
                for val in dirs:
                    nr = curr[0] + val[0]
                    nc = curr[1] + val [1]
                    if nr > 0 and nr < m and nc >=0 and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = lvl
                        q.append([nr, nc])
            lvl = lvl + 1
            
        return mat

        #T.C=> O(m * n)
        # S.C=> O(m * n) => since we iterate through all the matraix here 
        # Approach => here we traverse through all the matrix and collect all the row and coloum data that have matrix value as 1.
        #if that values have surround 0 it reuire 1 steps . So we can just calculate the minimum path from a given colum to the value 0 to 
        # calculate steps to that point.