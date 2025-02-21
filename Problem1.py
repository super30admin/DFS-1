# Problem 1 : Flood Fill
# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        # if the starting position already has the color then simply return the image
        if image[sr][sc] == color: 
            return image
        
        def dfs(image: List[List[int]], sr: int, sc: int, color: int, original_color: int):
            # Base Case
            # check boundary condition and also the color is not matching with original color then simpley return
            if (sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] != original_color):
                return
            # change the color of the point
            image[sr][sc] = color
            # move in four direction ie left, right, top, bottom
            dfs(image, sr-1, sc, color, original_color)
            dfs(image, sr+1, sc, color, original_color)
            dfs(image, sr, sc-1, color, original_color)
            dfs(image, sr, sc+1, color, original_color)
        
        # get the original color of the starting position
        original_color = image[sr][sc]
        # call dfs for starting position
        dfs(image, sr, sc, color, original_color)

        return image