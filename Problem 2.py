# Time: O(n*m)
# Space: O(n*m)
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # Time complexity: O(m*n)
        # Space comlexity: O(m*n)
        q = []
        dirs = [[0,1], [0,-1], [1, 0], [-1, 0]]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        level = 0
        while len(q) != 0:
            ln = len(q)
            for i in range(ln):
                curr = q.pop(0)
                for dr in dirs:
                    row = curr[0]+dr[0]
                    col = curr[1]+dr[1]
                    if row >=0 and row <len(mat) and col >=0 and col <len(mat[0]) and mat[row][col] == -1:
                        q.append([row, col])
                        mat[row][col] = 1+level
            level += 1
        return mat
            
                    
                
            
            
        
                    
        
        
