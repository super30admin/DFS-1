# Time complexity: O(m * n)
# Space compleity: O(h) where h is the height of the the tree

# The code sucessfully ran on Leetcode

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[sr][sc] == color:    return image
        
        oldColor = image[sr][sc]
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        self.m = len(image)
        self.n = len(image[0])
        
        self.dfs(image, sr, sc, color, oldColor)
        
        return image
        
    def dfs(self, image, row, col, color, oldColor):
        # Base
        if row < 0 or col < 0 or row == self.m or col == self.n or image[row][col] != oldColor: return
        
        # Logic
        image[row][col] = color
        
        for i in self.dirs:
            nr = row + i[0]
            nc = col + i[1]
            
            self.dfs(image, nr, nc, color, oldColor)