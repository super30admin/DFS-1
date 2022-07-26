# Time Complexity : o(n^2)
# Space Complexit: o(n)
# #Did this code successfully run on Leetcode :


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        height = len(mat) # defining the height(rows) as the height of teh matrix
        width = len(mat[0])# defining the width as the column of the matrix
        q=[]
        
        for i in range(height):
            for j in range(width):
                if(mat[i][j]==0):
                    q.append((i,j))
                else:
                    mat[i][j]='#' # if 1 in encountered it is changed as # 
        
        for row, column in q:
            for dx,dy in (1,0),(-1,0),(0,1),(0,-1):
                nr = row+dx
                nc = column+dy
                
                if (0<=nr<height and 0<=nc<width and mat[nr][nc]=='#'):
                    mat[nr][nc]=mat[row][column] + 1
                    q.append((nr,nc))
        
        return mat
                
                
        
                
                
        
        
                    
        