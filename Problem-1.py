# Time Complexity : O(m * n)
# Space Complexity : O(m * n)  # Recursion stack in worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# This code performs a flood fill on an image starting from the pixel (sr, sc).
# It uses DFS to recursively change the color of all connected pixels with the same original color.
# The algorithm checks boundaries and avoids revisiting pixels already changed to the new color.
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original_color = image[sr][sc]

        if original_color == color:
            return image

        self.dfs(sr, sc, image, original_color, color)
        return image

    def dfs(self, sr, sc, image, original_color, color):
        if image[sr][sc] != original_color:
            return
        
        image[sr][sc] = color
        
        if sr+1 < len(image):
            self.dfs(sr+1, sc, image, original_color, color)
        if sr-1 >= 0:
            self.dfs(sr-1, sc, image, original_color, color)
        if sc+1 < len(image[0]):
            self.dfs(sr, sc+1, image, original_color, color)
        if sc-1 >= 0:
            self.dfs(sr, sc-1, image, original_color, color)