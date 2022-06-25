"""
TC/SC:  O(m*n) / O(m*n)
"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        queue = [[sr,sc]]
        dirs = [[0,1],[0,-1],[-1,0],[1,0]]
        ROWS, COLS = len(image), len(image[0])
        orig_col = image[sr][sc]
        if orig_col == color:
            return image
        while queue:
            row,col = queue.pop()
            image[row][col] = color
            for i,j in dirs:
                r = i + row
                c = j + col
                if r >-1 and c >-1 and r < ROWS and c < COLS and image[r][c] == orig_col :
                    queue.append([r,c])
        return image
            
                
