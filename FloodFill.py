# Time Complexity: O(N), where N is the number of cells in the image
# Space Complexity: O(N), where N is the number of cells in the image
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # Check if the given starting cell has the same color as the new color.
        if image[sr][sc] == color:
            return image
        
        # Call the DFS function to color all the cells which have the same color as the starting cell.
        def dfs(image, sr, sc, color, original_color):
            # Base case
            if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] != original_color:
                return
            
            # Color the current cell with the new color.
            image[sr][sc] = color
            
            # Perform DFS on the neighbors which have the same color as the starting cell.
            dfs(image, sr + 1, sc, color, original_color)
            dfs(image, sr - 1, sc, color, original_color)
            dfs(image, sr, sc + 1, color, original_color)
            dfs(image, sr, sc - 1, color, original_color)
        
        # Call the DFS function on the given starting cell.
        dfs(image, sr, sc, color, image[sr][sc])
        
        # Return the modified image.
        return image