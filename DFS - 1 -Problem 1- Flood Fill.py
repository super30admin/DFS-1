"""
FAANMG Problem #65 {Easy}

733. Flood Fill


Time Complexity : O(N*M)


Space Complexity : O(N*M)


Did this code successfully run on Leetcode : Yes

BFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        if ( len(image) == 0):
            return image
        
        rows = len(image)
        cols = len(image[0])
        
        source = image[sr][sc]
        
        if( source == color):
            return image
        
        q = deque()
        
        q.append([sr,sc])
        image[sr][sc]= color
    
        
        directions = [[0,1], [1,0], [0,-1], [-1,0]]
        
        while q:
            r, c = q.popleft()
            
            for dr, dc in directions:
                nr = dr + r
                nc = dc + c
                
                if( 0<=nr<rows and 0<= nc < cols and image[nr][nc] == source ):
                    q.append([nr, nc])
                    image[nr][nc]= color
                    
        return image
                    
                
 """
FAANMG Problem #65 {Easy}

733. Flood Fill


Time Complexity : O(N)


Space Complexity : O(N)


Did this code successfully run on Leetcode : Yes

DFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    
    def dfs(self,image, r , c , color, source, rows, cols):
        
        #base
        # check for boundary conditions and also if the color is not the old color, then we simply return
        if( r < 0 or r == rows or  c < 0 or c == cols or image[r][c] != source):
            return
        
        #logic
        #change the color to new
        image[r][c] = color
        
         # recursively do it for all the neighbors
        for dr, dc in self.directions:
            nr = dr + r
            nc = dc + c
            
            self.dfs(image, nr, nc , color, source,rows,cols)
           
            
        
        
        
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        if ( len(image) == 0):
            return image
        
        rows = len(image)
        cols = len(image[0])
        
        source = image[sr][sc]
        
        if( source == color):
            return image
        
     
    
        
        self.directions = [[0,1], [1,0], [0,-1], [-1,0]]
        
        self.dfs(image, sr,sc, color, source,rows,cols)        

                    
        return image
                    
                
            
        
        
        
           
        
        
        
        
        