# // Time Complexity : O(r.c) where r is row and c is column
# // Space Complexity : O(r.c)
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : No


class Solution:
    def updateMatrix(self, mat):
        height = len(mat)
        width = len(mat[0])
        q = []
        
        # loops through the entire matrix
        for i in range(height):
            for j in range(width):
                if mat[i][j] == 0:
                    q.append((i,j))   # add to the queue if 0                 
                else:
                    mat[i][j] = "#"   # else change it to #
                    
        # check the adjacent cells
        for row, col in q:
            for dx, dy in (1,0),(-1,0),(0,1),(0,-1):
                nr = row + dx
                nc = col + dy
                
                # add 1 to the cell with # and append to the queue
                if 0<=nr<height and 0<=nc<width and mat[nr][nc] == "#":
                    mat[nr][nc] = mat[row][col] + 1
                    q.append((nr,nc))
        return mat