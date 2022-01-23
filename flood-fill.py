'''
TC: O(m*n)
SC: O(m*n)

m , n are rows and columns respectively
'''
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        r = len(image)
        if not r:
            return []
        
        c = len(image[0])
        
        if image[sr][sc] == newColor:
            return image
        
        def dfs(x, y, color, image, oric):
            nonlocal r, c
            image[x][y] = color
            dirx = [0, 0, 1, -1]
            diry = [1, -1, 0, 0]
            
            for i in range(4):
                newx = x + dirx[i]
                newy = y + diry[i]

                if newx >= 0 and newy >= 0 and newx < r and newy < c and image[newx][newy] == oric:
                    dfs(newx, newy, color, image, oric)
            
        dfs(sr, sc, newColor, image, image[sr][sc])
        
        return image
                
            
        