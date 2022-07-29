
# BFS
# Time Complexity = O(m * n)
# Space Complexity = O(m * n)

# 2 queues solution
class Solution:
    def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:
        # If the cell already has the new color, then return the image as it is
        if image == None or len(image) == 0 or image[sr][sc] == color:
            return image
        
        m = len(image)
        n = len(image[0])
        
        # Directions array - up, down, left, right
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        
        # 2 queues declaration
        rows = []
        cols = []
        
        # Capture the old color
        oldColor = image[sr][sc]
        
        rows.append(sr)
        cols.append(sc)
        
        # Change the first cell to new color
        image[sr][sc] = color
        
        
        while rows:
            currR = rows.pop(0)
            currC = cols.pop(0)
            for d in dirs:
                nr = currR + d[0]
                nc = currC + d[1]
                if (nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == oldColor):
                    rows.append(nr)
                    cols.append(nc)
                    image[nr][nc] = color
                    
                    
                    
        return image
     




# DFS Solution
# Time Complexity = O(m * n)
# Space Complexity = O(m * n)

class Solution:
    def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:
        # If the cell already has the new color, then return the image as it is
        if image == None or len(image) == 0 or image[sr][sc] == color:
            return image
        
        self.m = len(image)
        self.n = len(image[0])
        
        # Directions array - up, down, left, right
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        
        # Capture the old color
        self.oldColor = image[sr][sc]
        
        self.dfs(image, sr, sc, self.oldColor, color)
        
        return image
    
    
    def dfs(self, image, row, col, oldColor, color):
        # Base case
        # If cell is not of the old color, return
        if row < 0 or row == self.m or col < 0 or col == self.n or image[row][col] != self.oldColor:
            return
        
        # Logic
        # Change the first cell to new color
        image[row][col] = color
        
        for d in self.dirs:
            nr = row + d[0]
            nc = col + d[1]
            self.dfs(image, nr, nc, oldColor, color)
                
                
        