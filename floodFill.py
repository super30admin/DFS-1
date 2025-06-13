"""
Keep the original color at (sr, sc)
If original color != new color, start DFS from (sr, sc)
Recolor the pixel and all its connected neighbors in 4 directions
"""
"""
Time Complexity: O(N) —  N = number of pixels visited once
Space Complexity: O(N) — recursion stack 
"""

from typing import List

class floodFill:
    def floodFills(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        rows, cols = len(image), len(image[0])
        original_color = image[sr][sc]

        if original_color == color:
            return image

        def dfs(r, c):
            if r < 0 or c < 0 or r >= rows or c >= cols:
                return
            if image[r][c] != original_color:
                return
            image[r][c] = color
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        dfs(sr, sc)
        return image
    
if __name__ == "__main__":
    obj = floodFill()
    image = [[1,1,1],[1,1,0],[1,0,1]]
    sr, sc, new_color = 1, 1, 2
    result = obj.floodFills(image, sr, sc, new_color)
    for row in result:
        print(row)


