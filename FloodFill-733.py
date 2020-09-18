
# Time Complexity : O(nm)
# Space Complexity : O(nm) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# start from the source coordiantes and keep on changing the old color to new using basic dfs
class Solution(object):
    def dfs(self, r, c, newColor, oldColor, dirs, image ):
        image[r][c] = newColor
        
        for d in dirs:
            row = r + d[0]
            col = c + d[1]
            
            if 0 <= row < len(image) and 0 <= col < len(image[0]) and image[row][col] == oldColor:
                self.dfs(row,col, newColor, image[row][col], dirs, image)
                
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        
        if image == None or len(image) == 0 or image[sr][sc] == newColor:
            return image
        
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        self.dfs(sr, sc, newColor, image[sr][sc], dirs, image)
        return image
