"""
733. Flood Fill

Time = O(m*n) where m = num of rows, n= num of cols
space = O(m*n) where m = num of rows, n= num of cols
Successfully excecuted on leetcode


Approach --
1. DFS recursive
2. Get old color by storing the image[sr][sc] value
3. If old color and new color are not same, do dfs on sr,sc
4. Check all neighbors of sr,sc with valid row and col index; if the cell has old color again call dfs and change the cell colors

"""


class Solution:

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        print("image", image, type(image),image[0])

        def dfs(i, j): #
            image[i][j] = newColor
            for x, y in ((i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)):
                if 0 <= x < len_rows and 0 <= y < len_cols and image[x][y] == old_color: # check for valid row,col index
                    dfs(x, y)
                    
        old_color = image[sr][sc]
        len_rows = len(image)
        len_cols = len(image[0])
        
        if old_color != newColor: 
            dfs(sr, sc)
        return image