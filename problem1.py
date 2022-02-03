#TIme Complexity =O(n)
#Space Complexity = O(h)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if (image[sr][sc] == newColor):
            return image;
        dire = [(0,-1),(-1,0),(1,0),(0,1)]
        color = image[sr][sc]
        self.helper(image,sr,sc,newColor,dire,color)
        return image
        
        
    def helper(self,image,sr,sc,newColor,dire,color ):
        if(sr>=len(image) or sr<0 or sc>=len(image[0]) or sc<0 or image[sr][sc]!=color):
            return 
        image[sr][sc] = newColor
        for i,j in dire:
            self.helper(image,sr+i,sc+j,newColor,dire,color)
        
            
        
        