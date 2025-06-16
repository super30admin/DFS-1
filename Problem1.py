"""
I implemented the solution using DFS traversal to perform a flood fill on the image. The algorithm starts from the given pixel and recursively updates all connected pixels with the same original color to the new color.
Time Complexity: O(nm)
Space Complexity: O(nm)
"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc] == newColor:
            return image
        
        originalColor = image[sr][sc]
        self.dfs(image, sr, sc, newColor, originalColor)
        return image

    def dfs(self, image: List[List[int]], sr: int, sc: int, newColor: int, originalColor: int):
        if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] != originalColor:
            return
        
        image[sr][sc] = newColor

        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        for dr, dc in directions:
            self.dfs(image, sr + dr, sc + dc, newColor, originalColor)     