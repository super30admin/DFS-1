#Time Complexity - O(n)
#Space Complexity - O(n)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if image[sr][sc]==newColor:
            return image
        color=image[sr][sc]
        
        def fill(sr,sc,newColor,color):
            if image[sr][sc]==color:
                image[sr][sc]=newColor
                if sr+1<len(image):
                    fill(sr+1,sc,newColor,color)
                if sr>0:
                    fill(sr-1,sc,newColor,color)
                if sc+1<len(image[0]):
                    fill(sr,sc+1,newColor,color)
                if sc>0:
                    fill(sr,sc-1,newColor,color)
        fill(sr,sc,newColor,image[sr][sc])
        return image
                
        
        
        