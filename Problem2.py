#Time Complexity : O(M*N)
#Space Complexity : O(M*N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = []
        row = len(mat)
        col = len(mat[0])
        dirr = [[0,1],[1,0],[0,-1],[-1,0]]
        
        for i in range(row):
            for j in range(col):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j] = -1
        
        count = 1
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)
                for k in dirr:
                    r = node[0] + k[0]
                    c = node[1] + k[1]
                    if r >=0 and c>=0 and r < row and c < col and mat[r][c] == -1:
                        mat[r][c] = count
                        queue.append([r,c])
            count +=1           
        return mat
                    
        
                        
                                                    
        
        