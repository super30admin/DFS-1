// Time Complexity :(n*m)
// Space Complexity :(n*m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
from collections import deque
class Solution:

    
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or not image[0] or not len(image) or not len(image[0]):
            return image
        
        if image[sr][sc]==newColor: //if new color is same as previous color of specified indices we will simply return same image array
            return image
        
        self.dirs=[[-1,0],[1,0],[0,-1],[0,1]]   //initialize all the required variables
        self.old=image[sr][sc]
        self.new=newColor
        self.recurr(image,sr,sc)    //calling recursive function to check
        return image        //at last return image array
        
    def recurr(self,image,i,j):
        image[i][j]=self.new    //set the color of current location as newcolor
        
        for dir in self.dirs:   //search for old color in all four directions
            r=i+dir[0]
            c=j+dir[1]
            
            if r>=0 and r<len(image) and c>=0 and c<len(image[0]) and image[r][c]==self.old:    //if we find some location having old color then again call the recursive fucntion 
                self.recurr(image,r,c)
