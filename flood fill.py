class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if(image == None or len(image) == None or len(image[0]) == None or image[sr][sc] == newColor):
            return image
        
        oldColor = image[sr][sc]
        self.directions = [[1,0],[-1,0],[0,1],[0,-1]]
        
        self.recurr(image, sr, sc, oldColor, newColor)
        
        return image
        
        
    def recurr(self, image, sr, sc, oldColor, newColor):
        image[sr][sc] = newColor
            
        for dirs in self.directions:
            r = sr + dirs[0]
            c = sc + dirs[1]
                
            if(r >=0 and r < len(image) and c>=0 and c<len(image[0]) and image[r][c] == oldColor):
                self.recurr(image, r, c, oldColor, newColor)
