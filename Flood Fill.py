# // Time Complexity : O(n*m)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        self.new_color = newColor
        self.start = image[sr][sc]
        self.dfs(image,sr,sc)
        
        for i in range(len(image)):
            for j in range(len(image[0])):
                if image[i][j]=="#":
                    image[i][j] = self.new_color
                
        return image
    
    def dfs(self, image,i,j):
        if 0<=i<len(image) and 0<=j<len(image[0]) and image[i][j]==self.start:
            image[i][j] = "#"
            self.dfs(image,i-1,j)
            self.dfs(image,i+1,j)
            self.dfs(image,i,j-1)
            self.dfs(image,i,j+1)
                