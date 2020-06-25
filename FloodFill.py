---------------------------------- Flood Fill ---------------------------------------------
# Time Complexity : O(MXN) M is the rows of the image and N is the cols of the image
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here to fill the new color to entire matrix, we can use dfs. so we can send the sr and sc to the dfs function and check if the color at that position is oldcolor or not.
#If not we will return to the calling function. else we will change it to new color and check its neighbors by calling the dfs function again.



class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        def dfs(i, j, image,newColor, oldColor):
            if i<0 or i>len(image)-1 or j<0 or j>len(image[0])-1 or image[i][j] != oldColor:
                return
            
            image[i][j] = newColor
            
            dfs(i+1, j,  image,newColor, oldColor)
            dfs(i-1, j,  image,newColor, oldColor)
            dfs(i, j+1,  image,newColor, oldColor)
            dfs(i, j-1,  image,newColor, oldColor)
            
            return image
    
        oldColor = image[sr][sc]
        if oldColor == newColor:
            return image
        return dfs(sr,sc, image, newColor, oldColor)