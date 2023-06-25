#Time complexity is: O(m*n)
#Space complexity is: O(m*n)
#Code ran successfully on leetcode
#No issues faced while coding

#dfs approach

class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        if(image==None or len(image)==0):
            return image
        self.dir=[[0,1],[0,-1],[-1,0],[1,0]]
        #Taking the original color from the matrix
        self.orig=image[sr][sc]
        #If the color is same as the original color, we will return the image
        if(self.orig==color):
            return image
        self.dfs(image,sr,sc,self.orig,color)
        return image

    def dfs(self,image,r,c,orig,color):
        #Checking the bounding conditions
        if(r<0 or c<0 or r==len(image) or c==len(image[0]) or image[r][c]!=orig):
            return
        #Updating the image color at the index with required color
        image[r][c]=color
        #Iterating through direction array 
        for d in self.dir:
            nr=r+d[0]
            nc=c+d[1]
            self.dfs(image,nr,nc,orig,color)
