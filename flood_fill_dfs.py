#Time Complexity : O(n)
#Space Complexity : O(n)
#Approach : DFS

#Approach : DFS
from collections import deque
class Solution:
    global original_color
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if image == [[]] or image[sr][sc] == newColor:
            return image
        global original_color
        original_color = image[sr][sc]
        m = len(image)
        n = len(image[0])        
        
        self.dfs(image, sr, sc, newColor, m,n)
        return image
    
    def dfs(self, image: List[List[int]], sr: int, sc: int, newColor: int,m: int, n: int)->None:
        global original_color
        
        #base
        if sr < 0 or sc < 0 or sr == m or sc == n or image[sr][sc] != original_color:
            return
        
        #logic
        dirs = [[0,1],[0,-1],[-1,0],[1,0]]
        image[sr][sc] = newColor
        for dire in dirs:
            nr = dire[0] + sr
            nc = dire[1] + sc
            
            self.dfs(image, nr, nc, newColor, m,n)
            
            


        
