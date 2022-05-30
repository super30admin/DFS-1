# BFS
# Time Complexity: 0(m*n)
# Space Complexity: 0(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image) == 0:
            return image
        
        if image[sr][sc] == newColor:
            return image
        
        old_color = image[sr][sc]
        m = len(image)
        n = len(image[0])
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        q = list()
        q.append([sr,sc])
        while len(q) != 0:
            curr = q.pop(0)
            r = curr[0]
            c = curr[1]
            image[r][c] = newColor
            for di in dirs:
                rr = r + di[0]
                cc = c + di[1]
                if rr >= 0 and rr < m and cc >= 0 and cc < n and image[rr][cc] == old_color:
                    q.append([rr,cc])
                    
        return image

# DFS
# Time Complexity: 0(m*n)
# Space Complexity: 0(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image) == 0:
            return image
        
        if image[sr][sc] == newColor:
            return image
        
        m = len(image)
        n = len(image[0])
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        old_color = image[sr][sc]
        
        self.dfs(image, sr, sc, newColor, old_color, m, n, dirs)
                
        return image
    
    def dfs(self, image, i, j, newColor, old_color, m, n, dirs):
        if i < 0 or i >= m or j < 0 or j >= n or image[i][j] != old_color:
            return
        image[i][j] = newColor
        for di in dirs:
            r = i + di[0]
            c = j + di[1]
            self.dfs(image,r,c,newColor,old_color,m,n,dirs)