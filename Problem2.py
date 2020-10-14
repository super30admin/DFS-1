# Did not pass. Need a more optimized solution
# Will update the solution after the classs
class Solution:
    
    def helper(self, i, j):
        
        min_zero = -1
        
        for k in range(len(self.x_vals)):
            
            x, y = i + x_vals[k], y + self.y_vals[k]
            
            if x >= 0 and y >= 0 and x < len(self.matrix) and y < len(matrix[0]):
                
                
                       
        
    
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        if len(matrix) == 0:
            return
        self.visited = set()
        self.matrix = matrix
        self.x_vals = [0, 0, -1, 1]
        self.y_vals = [-1, 1, 0, 0]
        
        
        for i in range(len(matrix)):
            
            for j in range(len(matrix[0])):
                
                if (i, j) not in visited and self.matrix[i][j] == 1:
                    
                    self.helper(i, j)
        return self.matrix