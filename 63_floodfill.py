# S30 Big N Problem #63 {Easy }

# LC - 733. 
# Flood Fill

# Time Complexity : O(n*m) n=no. of rows m=no. of columns
# Space Complexity : O(n*m) n=no. of rows m=no. of columns
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach
# get the starting color from sr and sc. add the coordinates around the pixel in queue
# get the elements from the queue and update with new color and add the adjacent non-visited elements 
# iterate it till the queue is not empty 

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        direction=((-1,0),(1,0),(0,-1),(0,1))
        
        queue=[(sr,sc)]
        
        startcolor=image[sr][sc]
        
        while queue:
            
            x,y=queue.pop(0)
            
            
            
            image[x][y]=newColor
            
            for dx,dy in direction:
                
                if x+dx>=0 and x+dx<len(image) and y+dy>=0 and y+dy<len(image[0]):
                    if image[x+dx][y+dy]==startcolor:
                        
                        if (x+dx,y+dy) not in queue and image[x+dx][y+dy]!=newColor:
                            queue.append((x+dx,y+dy))
                    
                    
        return image
                    
                    
                    
            
            
            
            
        
        