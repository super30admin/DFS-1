# Time Complesity: O(m * n)
# Space Complexity: O(max(m, n)) 
# reason:DFS traversal may visit all cells in the image, so the maximum distance is equal to max(m, n).
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m, n = len(image), len(image[0])
        self.original_color = image[sr][sc]

        if self.original_color != color:
            self.dfs(image, sr, sc, color)

        return image

    def dfs(self, image, row, col, color):
        if not (0 <= row < len(image) and 0 <= col < len(image[0])) or image[row][col] != self.original_color:
            return

        image[row][col] = color

        for dr, dc in [(0, 1), (1, 0), (-1, 0), (0, -1)]:
            self.dfs(image, row + dr, col + dc, color)
