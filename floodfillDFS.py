# Time Complexity: O(m*n)
# Space Complexity : O(m*n); recursive stack space
  
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        m = len(image)
        n = len(image[0])
        orgColor = image[sr][sc]
        if image[sr][sc] == color:
            return image
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        self.dfs(image, sr, sc, color, m, n, dirs, orgColor)   
        return image
    
    def dfs(self, image, sr, sc, color, m, n, dirs, orgColor):
        #base
        if (sr < 0 or sc < 0 or sr == m or sc == n):
            return
        if image[sr][sc] != orgColor:
            return
        #logic
        image[sr][sc] = color
        
        for d in dirs:
            nR = sr + d[0]
            nC = sc + d[1]
            self.dfs(image, nR, nC, color, m, n, dirs, orgColor)
                    
        
        
