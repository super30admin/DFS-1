#BFS Solution
#  Time Complexity o(MXN)
# Space Complexity o(M*n)
# Perform BFS while adding new elements into the queue on each level



class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        qu = collections.deque()
        
        
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        
        target = image[sr][sc]
        
        if image[sr][sc] == newColor:
            return image
        
        image[sr][sc] = newColor
         
        qu.append([sr,sc])
        
        while(len(qu))>0:
            
            size = len(qu)
            
            for i in range(size):
                
                curr = qu.popleft()
    
                
                for a in dirs:
                    
                    nr = curr[0] + a[0]
                    
                    nc = curr[1] + a[1]
           
                    
                    if nc >=0 and nr >=0 and nc < len(image[0]) and nr < len(image) and image[nr][nc] == target:
                        image[nr][nc] = newColor
                        
                        qu.append([nr,nc])
            
        return image
                