'''
// Time Complexity : 0(m*n) worst case
// Space Complexity : 0(m*n) worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''

class Solution:
    
    def __init__(self):
        
        self.dirMatrix = [
            [0,1],  # right
            [0,-1], # left
            [-1,0], # top
            [1,0]   # bottom
        ]
    
    def dfsWay(self,image,sr,sc,newColor,oldColor):
        
        # logic-case
        if image[sr][sc] != newColor:
            
            # update to newColor
            image[sr][sc] = newColor
            
            # check 4 directions
            for dir in self.dirMatrix:
                
                temp_row = dir[0] + sr
                temp_col = dir[1] + sc
                
                # check bounds
                if ((temp_row >= 0 and temp_row < len(image)) and (temp_col >= 0 and temp_col < len(image[0]))) and (image[temp_row][temp_col] == oldColor):
                    
                    # perform check and recursive call
                    self.dfsWay(image,temp_row,temp_col,newColor,oldColor)
        
        
        # return the image
        return image
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        return self.dfsWay(image,sr,sc,newColor,image[sr][sc])