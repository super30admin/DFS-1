# Apporach: DFS Recursive 

# The apporach is simple. First change the color of current pixel and check if the pixels adjacent to it has the same old color it our current pixel has. If yes then traverse all of them and change their colors. Similarly, traverse the ajacent pixels of these pixels, check for the proeprties and if they satisfy then change their color.

# Time complexity: O(m*n) ; m = no of rows and c = no of columns
# Space complexity: O(m*n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        
        # color of source pixel
        self.color = image[sr][sc]
        
        self.m = len(image) - 1
        self.n = len(image[0]) - 1
        
        self.dfs(image, sr,sc, newColor)
        return image
    
    def dfs(self, image, row, col, newColor):
        
        if row < 0 or col < 0 or row > self.m or col > self.n or image[row][col] == newColor or image[row][col] != self.color:
            return
        
        # Logic
        image[row][col] = newColor
        dirs = [[0,1],  [0,-1], [1,0], [-1,0]]
        
        for d in dirs:
            r = row + d[0]
            c = col + d[1]
            self.dfs(image, r, c, newColor) 
            

# Apporach: BFS Iterative
# Time complexity: O(m*n) ; m = no of rows and c = no of columns
# Space complexity: O(m*n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        # Here in the base 3rd condition is very important. It helps us deal with infinite loop
        # ex = image = [[0,0,0], [0,1,1]] , sr = 1, sc = 1, newColor = 1
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        
        color = image[sr][sc]
        queue = []
        m = len(image) 
        n = len(image[0]) 
        
        image[sr][sc] = newColor
        queue.append([sr, sc])
        dirs = [[0,1],  [0,-1], [1,0], [-1,0]]

            
        while len(queue) != 0:
            # Here we do not need to use size because here are not dealing with levels. We are not supposed to work with all the elements present in the queue at a time.
            curr = queue.pop(0)
            
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                
                if r >= 0 and c >= 0 and r < m and c < n and image[r][c] != newColor and image[r][c] == color:
                    image[r][c] = newColor
                    queue.append([r,c])
        
        return image
                