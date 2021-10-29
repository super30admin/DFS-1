
#Time Complexity : O(n^2)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n = len(mat) # height of matrix
        m = len(mat[0])#width of matrix
        
        q = []
        
        for i in range( n):
            for j in range (m):
                if mat[i][j] ==0:
                    q.append((i,j))
                    
                else:
                    mat[i][j] = "-1"
                    
                
        for r,c in q:
            for(( dx, dy) )in ((1,0), (-1,0), (0,1),(0,-1)):
                nr = r+dx
                nc = c+dy
                
                if 0<= nr< n and 0<= nc< m and mat[nr][nc] =="-1" :
                    mat[nr][nc] = mat [r][c] +1
                    q.append((nr,nc))
        return mat
