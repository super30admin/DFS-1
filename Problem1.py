# Time Complexity: O(N)
# Space Complexity: O(N) Stack space
# Passed Leetcode

class Solution:
    def helper(self, i, j):
        
        self.image[i][j] = self.newColor
        self.visited.add((i, j))
        for k in range(len(self.x_vals)):
            
            x, y = i + self.x_vals[k], j + self.y_vals[k]
            
            if 0 <= x and 0 <= y and x < len(self.image) and y < len(self.image[0]) and self.image[x][y] == self.color_to_replace and (x, y) not in self.visited:
                
                self.helper(x, y)
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        
        if len(image) == 0:
            return
        
        self.x_vals = [0,0,-1,1]
        self.y_vals = [-1,1,0,0]
        self.visited = set()
        self.image = image
        self.color_to_replace = self.image[sr][sc]
        self.newColor = newColor
        self.helper(sr, sc)
        
        return self.image