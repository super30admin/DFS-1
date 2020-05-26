#Time Complexity: O(N), where NN is the number of pixels in the image. We might process every pixel.
#Space Complexity: O(N), the size of the implicit call stack when calling dfs.
#Ran successfully on Leetcode: Yes
#Algorithm:
# Firstly we set the given locations color as current color. 
# then the given location is added to queue, and assign it the newcolor given
# Then we explore its neighbpur and assign them also with newcolor.
# This is done uisng a queue in BFS method and using a recursive stack in DFS method.



#BFS Solution:
# class Solution:
#     def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
#         color=image[sr][sc]   
#         if not image or len(image)==0 or color==newColor:
#                 return image
#         q=[]
#         if image:
#             q.append((sr,sc))
#             image[sr][sc] =newColor
#         while q:
#             curr=q.pop(0)

#             for dx,dy in [[0,1],[0,-1],[-1,0],[1,0]]:
#                 r=dx+curr[0]
#                 c=dy+curr[1]
#                 if r>=0 and c>=0 and r<len(image) and c<len(image[0]) and image[r][c]==color:
#                     image[r][c]=newColor
#                     q.append((r,c))
#         return image
                    
#DFS Solution:

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        color=image[sr][sc] 
        if not image or len(image)==0 or color==newColor:
                return image
        image[sr][sc]=newColor
            
            
        def dfs(image,sr,sc,newColor):
            
            
            dirs=[[0,1],[0,-1],[-1,0],[1,0]]
            for dx, dy in dirs:
                r=dx+sr
                c=dy+sc
                if r>=0 and c>=0 and r<len(image) and c<len(image[0]) and image[r][c]==color:
                    image[r][c]=newColor
                    dfs(image,r,c,newColor)
     
        dfs(image,sr,sc,newColor)
        return image
   
      
            
        
        
        
        
        
