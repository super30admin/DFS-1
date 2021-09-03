# // Time Complexity : O(nm)
# // Space Complexity : 0(nm) 
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO

from collections import deque 
class Solution:
    def isValid(self,i,j,r,c,mat):
        return i>=0 and j>=0 and i<r and j<c and mat[i][j]==-1
    
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        numRows = len(mat)
        numCols = len(mat[0])
                
        queue = deque()
        
        for i in range(numRows):
            for j in range(numCols):
                if mat[i][j]==0:
                    queue.append([i,j])
                else:
                    mat[i][j]=-1
        
        directions = [[-1,0],[1,0],[0,1],[0,-1]]
        
        level = 0 
        
        while len(queue)>0:
            level +=1 
            count = len(queue)
            
            while count>0:
                curr = queue.popleft()
                
                for i in range(len(directions)):
                    curr_row = curr[0]+directions[i][0]
                    curr_col = curr[1]+directions[i][1]
                    
                    if self.isValid(curr_row,curr_col,numRows,numCols,mat):
                        mat[curr_row][curr_col] = level
                        queue.append([curr_row,curr_col])
                
                count-=1 
        
        return mat