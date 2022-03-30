// Time Complexity : O(N), N is the number of elements in the image array
   i.e n*m, where n is the number of rows and m is the number of cols 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

'''
Approach:

1. Find the elements we need to explore.
2. Return from the paths we need not explore.
3. Once we find an elements we want to explore, 
   set its colour to new colour and explore its 4 other neighbhours

'''

class Solution:
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int,
            newColor: int) -> List[List[int]]:
            startColour=image[sr][sc]
            self.ff(image,sr,sc,startColour,newColor)
            return image
        
        
    def ff(self,image,row,col,sc,nc):
        dir=[[0,1],[0,-1],[-1,0],[1,0]]
        
        if (row <0 or row>=len(image) or 
            col <0 or col>=len(image[0]) or 
            image[row][col] != sc or sc==nc):
            return
        
        
        #set colour
        image[row][col] = nc
        
        
        #explore children
        for v in dir:
            self.ff(image,row+v[0],col+v[1],sc,nc)
            
        
        
        
        
        