# Time complexity - O(m*n)
# Space complexity - O(m*n)
# BFS
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:      
        if not image or len(image)== 0 :
            return image
        if image[sr][sc] == color: 
            return image
        m = len(image)
        n = len(image[0])   
        q = [[sr,sc]]
        orig = image[sr][sc]
        image[sr][sc] = color
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        while q : 
            curr = q.pop(0)          
            for each in dirs: 
                nr = curr[0] + each[0]
                nc = curr[1] + each[1]             
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == orig:                 
                    q.append([nr,nc])
                    image[nr][nc] = color

        
        return image



# Time complexity - O(m*n)
# Space complexity - O(m*n)
# DFS

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:      
        if not image or len(image)== 0 :
            return image
        if image[sr][sc] == color: 
            return image
        m = len(image)
        n = len(image[0])
       
      
        orig = image[sr][sc]
        
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        self.dfs(image,sr,sc,color,orig,m,n)
        return image


    def dfs(self,image,sr,sc,color,orig,m,n):
        if sr < 0 or sc <0 or sr == m or sc == n or image[sr][sc] != orig:
            return
        
        image[sr][sc] = color
        for each in self.dirs:
            nr = sr + each[0]
            nc = sc + each[1]
            self.dfs(image,nr,nc,color,orig,m,n)

    
           






       



