# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def fill(self,image,i,j,color,newColor):
        # if you passed borded or color is not equal old color return
        if i<0 or i>= len(image) or j <0 or j >= len(image[0]) or image[i][j] != color:
            return
        #change colot to new color
        image[i][j] = newColor
        #expand in 4 directions
        self.fill(image,i+1,j,color,newColor)
        self.fill(image,i-1,j,color,newColor)
        self.fill(image,i,j+1,color,newColor)
        self.fill(image,i,j-1,color,newColor)
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        #if color =  new color return image
        if image[sr][sc] == newColor:
            return image
        #recurse
        self.fill(image,sr,sc,image[sr][sc],newColor)
        #return image
        return image
        