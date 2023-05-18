#Time Complexity:O(m*n)
#Space Complexity:O(m*n)

class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        self.dire=[[1,0],[-1,0],[0,1],[0,-1]]
        self.m=len(image)
        self.n=len(image[0])
        self.originalColor=image[sr][sc]
        if self.originalColor==color:
            return image
        self.dfs(image,sr,sc,color)
        return image

    def dfs(self,image,row,col,color):
        if (row<0 or col<0) or(row==self.m or col==self.n) or image[row][col]!=self.originalColor:
            return
        image[row][col]=color
        for d in self.dire:
            nr=row+d[0]
            nc=col+d[1]
            self.dfs(image,nr,nc,color)
        
        
            
       