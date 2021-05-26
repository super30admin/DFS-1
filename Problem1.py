# time:0(N) where N is mn : total number of pixels
#space :0(1)

class Solution(object):
    def dfs_util(self,image,sr,sc,prev_c,newColor,m,n):
        
        if sr < 0 or sr >= m or sc < 0 or sc >= n :
            return
        if image[sr][sc]!= prev_c:
            return
        image[sr][sc]= newColor
        self.dfs_util(image,sr+1,sc,prev_c,newColor,m,n)
        self.dfs_util(image,sr,sc+1,prev_c,newColor,m,n)
        self.dfs_util(image,sr-1,sc,prev_c,newColor,m,n)
        self.dfs_util(image,sr,sc-1,prev_c,newColor,m,n)
    
    def floodFill(self, image, sr, sc, newColor):
        m = len(image)
        n = len(image[0])
        
        prev_c = image[sr][sc]
        
        if prev_c == newColor:
            return image
        
        self.dfs_util(image,sr,sc,prev_c,newColor,m,n)
        
        return image
        
        