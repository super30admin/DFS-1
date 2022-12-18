""" 
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Time Complexity: O(m*n)
Space Complexity: O(m*n)
"""

#using BFS

from collections import deque
def floodFill(image, sr, sc, color):
    if not image or image[sr][sc] == color:
            return image
    
    dirs = [(0,1), (0,-1), (1,0), (-1,0)]
    
    queue = deque()
    queue.append((sr,sc))
    src_color = image[sr][sc]
    image[sr][sc] = color
    
    while queue:
        r, c = queue.popleft()
        
        for dr, dc in dirs:
            nr = r + dr
            nc = c + dc
            
            if 0 <= nr < len(image) and 0 <= nc < len(image[0]) and image[nr][nc] == src_color:
                queue.append((nr,nc))
                
            image[r][c] = color
        
    return image


#using DFS

def floodFill(image, sr, sc, color):
    if not image or image[sr][sc] == color:
            return image
    
    dirs = [(0,1), (0,-1), (1,0), (-1,0)]
    
    def dfs(r, c):
        if 0 <= r < len(image) and 0 <= c < len(image[0]) and image[r][c] == src_color:
            image[r][c] = color
            for dr, dc in dirs:
                dfs(r+dr, c+dc)
    
    src_color = image[sr][sc]
    dfs(sr, sc)
    return image