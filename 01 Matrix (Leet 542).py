# BFS
# Time Complexity: 0(m*n)
# Space Complexity: 0(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or len(mat) == 0:
            return mat
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(mat)
        n = len(mat[0])
        q = list()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else: mat[i][j] = -1
        

        while len(q) != 0:
            curr = q.pop(0)
            for di in dirs:
                r = curr[0] + di[0]
                c = curr[1] + di[1]
                if r >= 0 and r < m and c >= 0 and c < n and mat[r][c] == -1:
                    mat[r][c] = mat[curr[0]][curr[1]] + 1
                    q.append([r,c])
        return mat
        