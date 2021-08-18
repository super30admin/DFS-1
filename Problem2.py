# 542. 01 Matrix
#   Time Complexity :  (mXn) ^ 2
#   Space Complexity : 0(MXn)
#   Did this code successfully run on Leetcode : No, time limit exceeded; 48 / 50 test cases passed.
#   Any problem you faced while coding this : No

# This solution runs BFS on each and every element

class Solution:
    
    def bfs(self, i, j, mat):
        
        r = []
        c = []
        r.append(i)
        c.append(j)
        k = -1
        flag = False
        
        while(len(r)!=0 and flag == False):
            
            size = len(r)
            k = k + 1

            for i in range(0, size):
                
                row = r.pop(0)
                col = c.pop(0)
                if mat[row][col] == 0:
                    flag = True
                    break
                dirs =[[-1,0],[1,0],[0,-1],[0,1]]
                
                for direc in dirs:
                    # check bounds
                    
                    new_row = row+direc[0]
                    new_col = col+direc[1]
                    if new_row >= 0 and new_row < len(mat) and new_col >= 0 and new_col < len(mat[0]):
                        r.append(row+direc[0])
                        c.append(col+direc[1])
         
        return k
            
            
    
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        for i in range(0, len(mat)):
            for j in range(0, len(mat[0])):
                
                if mat[i][j] != 0:
                    mat[i][j] = self.bfs(i, j, mat)
        
        return mat

        
        
            