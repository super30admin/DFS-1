# time: O(mn)
# space: O(mn)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        row, col = len(mat)-1, len(mat[0])-1

        def dfs(r,c):
            for nr,nc in [(0,1),(1,0), (-1,0), (0,-1)]:
                if 0<=nr<row and 0<=nc<col:
                    if mat[nr][nc] > mat[r][c] + 1:
                        mat[r][c] = mat[nr][nc] + 1
        
        for x in range(row):
            for y in range(col):
                dfs(x,y)
        
        return mat