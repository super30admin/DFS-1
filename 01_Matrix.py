class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        dir = [[0,1],[1,0],[-1,0],[0,-1]]
        q = []
        m = len(mat)
        n = len(mat[0])
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    q.append([i,j])
        
        if len(q) == len(mat)*len(mat[0]) or len(q) == 0:
            return mat
        while len(q) != 0:
            curr = q.pop(0)
            for x,y in dir:
                row = x + curr[0]
                col = y + curr[1]
                if row >= 0 and col >= 0 and row < m and col < n and mat[row][col] == -1:
                    q.append([row,col])
                    mat[row][col] = mat[curr[0]][curr[1]] + 1
                    
        return mat