# // Time Complexity : O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
class Solution:
    dirs = list()
    color = int()
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or image[sr][sc] == newColor:
            return image
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(image)
        n = len(image[0])
        q = list()
        self.color = image[sr][sc]
        self.dfs(image, sr, sc, newColor,m,n)
        
        return image
    
    def dfs(self, image, sr, sc, newColor, m, n):
        
        # base
        if sr< 0 or sc < 0 or sr >= m or sc >= n or image[sr][sc] != self.color:
            return
        
        #logic
        image[sr][sc] = newColor
        for direction in self.dirs:
            nr = sr + direction[0]
            nc = sc + direction[1]
            
            self.dfs(image, nr, nc, newColor,m,n)
            
        
        
        
    
    
            
                    
                    
                
        
        