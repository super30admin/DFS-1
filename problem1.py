#Time complexity O(n, space O(1))
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        #Initializing old color with the given image pixel
        x=image[sr][sc]
        
        #If the pixel is equal to newcolor return the image
        if image[sr][sc] == newColor:
            return image
        #Calling dfs
        self.dfs(image,newColor,sr,sc,x)
        
        return image
    
 #Dfs for all the 4 directions   
    def dfs(self,image,newColor,sr,sc,x):
        
        if sr<0 or sr>=len(image) or sc<0 or sc>=len(image[0]) or image[sr][sc]!=x:
            return 
        image[sr][sc]=newColor
        self.dfs(image,newColor,sr-1,sc,x)
        self.dfs(image,newColor,sr+1,sc,x)
        self.dfs(image,newColor,sr,sc-1,x)
        self.dfs(image,newColor,sr,sc+1,x)
