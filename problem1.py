#Flood Fill

# // Time Complexity :O(N) - Going though every pixels
# // Space Complexity : O(N) as the recursive stack could hold almost n pixels
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution(object):
    def floodFill(self, image, sr, sc, newColor):                           #DFS approach
        if image[sr][sc]==newColor: return image
        self.directions=[[0,1],[1,0],[0,-1],[-1,0]]                         #all 4 directions that you have to look at
        self.color=image[sr][sc]                                            #color you start with
        self.dfs(image,sr, sc, newColor)
        return image
    
    def dfs(self,image, sr, sc, newColor):
        #base
        if(sr<0 or sc<0 or sr>=len(image) or sc>=len(image[0]) or image[sr][sc]!=self.color):       #if the pixel is not the old color or if its out of bounds, then just return
            return
        
        #logic
        image[sr][sc]=newColor                                                                      #if not, set the pixel to the new color
        for i in self.directions:                                                                   #for every direction, run the dfs
            newr=sr+i[0]
            newc=sc+i[1]
            self.dfs(image, newr,newc,newColor)

