# Time Complexity : O(MxN) (Where M is no of row and N is no of column)
# Space Complexity : O(MxN) (Where M is no of row and N is no of column)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Using dfs from starting point.
# - If source color is found update the color and run dfs for it's neighbour.


class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
#       Initialize variable that are globally available
        self.newColor = newColor
        self.rlength = len(image)
        self.clength = len(image[0])
        self.originalColor = image[sr][sc]
        self.image = image
        
#       Check that source pixel is not already flooded with new color.
        if newColor != self.originalColor:
#           Run dfs function on starting point
            self.dfs(sr, sc)
        return image
        
    def dfs(self, r, c):
#       Assign new color to current pixel
        self.image[r][c] = self.newColor
#       Check it's allowed neighbour
        for i, j in ((r-1, c), (r+1, c), (r, c+1), (r, c-1)):
#           If neighbour is not out of bound and have similer color as source than pass that pixel into dfs function.
            if 0 <= i < self.rlength and 0 <= j < self.clength and self.image[i][j] == self.originalColor:
                self.dfs(i, j)
            
