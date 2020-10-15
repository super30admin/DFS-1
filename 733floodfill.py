# Space Complexity - O(N)
# Time Complexity - O(N)

# Ran on Leetcode - Yes


class Solution:
    
    
    def isValid(self, row, col, rows, cols):
        
        if row < 0 or row > rows-1:
            return False
        
        if col < 0 or col > cols-1:
            return False
        
        return True
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        output = []
        queue = []
        
        if image==None:
            return output
        
        rows = len(image)
        cols = len(image[0])
        
        dirs = [[-1,0],[0,-1],[0,1],[1,0]]
        
        
        queue.append((sr,sc))
        startPixel = image[sr][sc]
        
        visited = dict()
        
        while queue:
            
            size = len(queue)
            
            for i in range(size):
                
                row, col = queue.pop(0)
                
                image[row][col] = newColor
                
                for each_dir in dirs:
                    
                    new_row, new_col = row + each_dir[0], col + each_dir[1] 
                    if (new_row,new_col) in visited:
                        continue
                    visited[(new_row, new_col)] = 1
                    if self.isValid(new_row, new_col, rows, cols):
                        if image[new_row][new_col] == startPixel:
                            image[new_row][new_col] = newColor
                            queue.append((new_row,new_col))
                            
                  
        return image
                            
