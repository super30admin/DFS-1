// Time Complexity : O(n)
// Space Complexity : O(n) where n is the number of elements in image
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we have used a DFS approach for this problem.we start by taking the given indices as the start position and check whether the surrounding elements are having the same color as the start position then we color that position.In the same manner we color all the surrounding elements which are reachable.

# using DFS
from collections import deque
class Solution(object):
    def helper(self,image,sr,sc,newColor,start):
        if sr<0 or sr>=len(image) or sc<0 or sc>=len(image[0]):
            return
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        for i in dirs:
            row=sr+i[0]
            col=sc+i[1]
            if 0<=row<len(image) and 0<=col<len(image[0]) and image[row][col]==start:
                image[row][col]=newColor
                self.helper(image,row,col,newColor,start)
        
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if image==None or len(image)==0 or image[sr][sc]==newColor:
            return image
        start=image[sr][sc]
        image[sr][sc]=newColor
        self.helper(image,sr,sc,newColor,start)
        return image
                
                
