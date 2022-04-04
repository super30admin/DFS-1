
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        color = image[sr][sc]
        if color == newColor:
            return image
        def dfsHelper(i,j,oldColor):
            if len(image)> i >= 0 and len(image[0]) > j >=0:
                if image[i][j] == oldColor:
                    image[i][j] = newColor
                    dfsHelper(i,j+1,oldColor)
                    dfsHelper(i+1,j,oldColor)
                    dfsHelper(i-1,j,oldColor)
                    dfsHelper(i,j-1,oldColor)
        dfsHelper(sr,sc,color)
        return image
                
                
                