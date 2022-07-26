class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m=len(image)
        n=len(image[0])
        
        
        l=[image[sr][sc]]
        
        def color_modify(row,col):
            if row<0 or row>=m or col<0 or col>=n or image[row][col]==color or image[row][col]!=l[0]:
                return
            
            image[row][col]=color
            
            color_modify(row-1,col)
            color_modify(row,col-1)
            color_modify(row+1,col)
            color_modify(row,col+1)
            
        color_modify(sr,sc)
                    
        return image
             
            