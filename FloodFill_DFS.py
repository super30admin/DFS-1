# TC: O(M x N) where M = rows and N = columns of the image. 
# SC: O(M x N)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or len(image) == 0 or len(image[0]) == 0 or image[sr][sc] == newColor:
            return image
        
        rows = len(image)
        cols = len(image[0])
        color = image[sr][sc]
        
        def dfs(r, c):
            
            if r < 0 or r >= rows or c < 0 or c >= cols and image[r][c] == newColor:
                return 
            
            image[r][c] = newColor
            dirs = [(0,1),(1,0),(-1,0),(0,-1)]
            for x, y in dirs:
                new_r = r + x
                new_c = c + y
                
                if new_r >= 0 and new_r < rows and new_c >= 0 and new_c < cols and image[new_r][new_c] == color:
                    dfs(new_r, new_c)
        dfs(sr, sc)
        return image
