# 01 Matrix

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)
        columns = len(mat[0])

        result = [[0 for j in range(columns)] for i in range(rows)]
        
        for i in range(rows):
            for j in range(columns):
                if mat[i][j] == 1:
                    result[i][j] = self.dfs(mat, result, i, j)
                    

        return result
    

    def dfs(self, mat, res, row, column):

        #base case

        #top
        if row>0 and mat[row-1][column] == 0:
            return 1
        #right
        if column<(len(mat[0])-1) and mat[row][column+1] == 0:
            return 1
        #bottom
        if row<len(mat)-1 and mat[row+1][column] == 0:
            return 1
        #left
        if column>0 and mat[row][column-1] == 0:
            return 1
        
        top = 10001
        right = 10001
        bottom = 10001
        left = 10001

        #top
        if row>0 and res[row-1][column] != 0:
            top =  res[row-1][column]
        
        if column>0 and res[row][column-1] != 0:
            left = res[row][column-1]

        if column<(len(mat[0])-1):
            if res[row][column+1] == 0:
                res[row][column+1] = self.dfs(mat, res, row, column+1)
            right = res[row][column+1]

        if row<len(mat)-1:
            if res[row+1][column] == 0:
                res[row+1][column] = self.dfs(mat, res, row+1, column)
            bottom = res[row+1][column]

        return 1 + min(top, right, bottom, left)
        

        # if i < 0 or j<0 or i == rows or j == columns or mat[i][j] == 1:
        #     return
        
        # result[i][j] = min(result[i][j],depth)

        # for r, c  in dirs:
        #     if i < 0 or j<0 or i == rows or j == columns or mat[r][c] == 1: 
        #         continue
        #     self.dfs(mat, r+i, j+c, result, dirs, depth+1, rows, columns)

        # return