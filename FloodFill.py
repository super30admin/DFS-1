#Time 0(m*n)
#Space 0(m*n)
#Using BFS Method

class Solution:
    
    def dfs(self, image, r, c, newColor, baseColor):
        
        if r<0 or r == len(image) or c < 0 or c == len(image[0]) or image[r][c]!=baseColor or image[r][c]==newColor:
            return
                   
        image[r][c] = newColor

        dirArr = [[0,1],[0,-1],[-1,0],[1,0]]
        for dir in dirArr:
            sr = dir[0]+r
            sc = dir[1]+c
            self.dfs(image, sr, sc, newColor, baseColor)       
            
            
            
    
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        
        #Base case
        if not image or len(image) == 0:
            return
        
        #Use queue, append the starting point and get the value of base color
 
        baseColor = image[sr][sc]
        
        self.dfs(image, sr, sc, newColor, baseColor)
        
        return image

        
#         #Base case
#         if not image or len(image) == 0:
#             return
        
#         #Use queue, append the starting point and get the value of base color
#         queue = deque()
#         queue.append((sr, sc))
#         row = len(image)
#         col = len(image[0])
        
#         baseColor = image[sr][sc]
        
#         image[sr][sc] = newColor
        
#         #direction array in 4 ways
#         dirArr = [[0,1],[0,-1],[-1,0],[1,0]]
        
#         #if the currentt color is same as base and not equal to the new color update its value tto new color
#         while queue:
            
#             curr = queue.popleft()
            
#             for dir in dirArr:
                
#                 r = dir[0]+curr[0]
#                 c = dir[1]+curr[1]
                
#                 if r >= 0 and r < row and c >= 0 and c < col and image[r][c]==baseColor and  image[r][c]!=newColor:
#                     image[r][c] = newColor
#                     queue.append((r,c))
                            
                
#         return image
                
        
        
        
        
