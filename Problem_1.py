# Runs on Leetcode

# DFS
        # Runtime - O(m*n)
        # Memory - O(1)
# BFS
        # Runtime - O(m*n)
        # Memory - O(n)

class Solution:
    def DFS_floodFill(self, image, sr, sc, newColor) :
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
            

class Solution:
    def BFS_floodFill(self, image, sr, sc, newColor) :
        if not len(image) or image[sr][sc] == newColor:
            return image
        
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        starting_pixel_color = image[sr][sc]
        queue = [[sr,sc]]
        
        while queue:
            pixel = queue.pop(0)
            if image[pixel[0]][pixel[1]] == starting_pixel_color:
                image[pixel[0]][pixel[1]] = newColor
            for i in directions:
                a = pixel[0] + i[0]
                b = pixel[1] + i[1]
                if a < 0 or a >= len(image) or b < 0 or b >= len(image[1]) or image[a][b] != starting_pixel_color:
                    continue
                queue.append([a,b])
        return image
