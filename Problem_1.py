# Runs on Leetcode
DFS
# Runtime - O(m*n)
# Memory = O(1)


class Solution:
    def floodFill(self, image, sr, sc, newColor) :
        if not len(image) or image[sr][sc] == newColor:
            return image
        self.image = image
        self.newColor = newColor
        self.starting_pixel_color = image[sr][sc]
        self.helper(sr,sc)
        return self.image
    
    def helper(self,x,y):
        if x < 0 or x >= len(self.image) or y < 0 or y >= len(self.image[1]):
            return
        if self.image[x][y] != self.starting_pixel_color:
            return
        self.image[x][y] = self.newColor
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        for i in directions:
            new_x = x + i[0]
            new_y = y + i[1]
            self.helper(new_x,new_y)
