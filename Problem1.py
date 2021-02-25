"""
733. Flood Fill
Time Complexity - O(m*n)
Space Complexity - O(m*n)
Checking condition if given co-ordinates color is same as new color if True: No further processing required
Otherwise defined a function recurssion which will recursively go throught all the pixels and will change it to new color only in 4 direction.
"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or len(image) == 0 or image[0] == None and len(image[0]) == 0:
            return image
        if image[sr][sc] == newColor:
            return image
        self.recurssion(image,sr,sc,newColor,image[sr][sc])
        return image
        
    def recurssion(self,image,sr,sc,newColor,oldColor):
        image[sr][sc] = newColor
        dirs = ((-1,0),(0,1),(1,0),(0,-1))
        
        for dir in dirs:
            r = dir[0] + sr
            c = dir[1] + sc
            if r >= 0 and c >= 0 and r < len(image) and c < len(image[0]) and image[r][c] == oldColor:
                self.recurssion(image,r,c,newColor,oldColor)
                