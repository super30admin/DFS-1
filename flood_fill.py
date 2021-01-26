# Time complexity: O(m*n) 
# Space complexity: O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution: 
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
		# Base condition
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
			
        m = len(image)
        n = len(image[0])
        
		# set to image[sr][sc] to color for the reference
        self.color = image[sr][sc]
        
		# DFS call
        self.dfs(image, sr, sc, newColor)
        return image
        
    def dfs(self, image, sr, sc, newColor):
		# Boundary Check and make sure that my image change to newColor( image[sr][sc] != self.color)
		# Color variable reference is used here
        if sr < 0 or sc < 0 or sr == len(image) or sc == len(image[0]) or image[sr][sc] != self.color:
            return 
        
        #logic part of changing to newColor and check all directions
        image[sr][sc] = newColor
        directions = [(-1,0), (1,0), (0,1), (0, -1)]
        for dir in directions:
            r = dir[0] + sr
            c = dir[1] + sc
            self.dfs(image, r, c, newColor)
