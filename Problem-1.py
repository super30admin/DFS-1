class Solution:
    def floodFill(self, image, sr, sc, newColor):
            rows, cols = len(image), len(image[0])
            dirs = ((-1,0),(1,0),(0,1),(0,-1))
            color = image[sr][sc] # store pixel value
            def dfs(i, j): 
                if (not(0<= i < rows and 0<= j < cols) or image[i][j] != color):
                    return
                        
                image[i][j] = newColor
                for d in dirs: # traverse neighbors
                    x, y = i+d[0], j+d[1]
                    dfs(x,y)
            if newColor != color: 
                # image[sr][sc]=newColor
                dfs(sr, sc) 
            return image