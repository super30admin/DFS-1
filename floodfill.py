class Solution:
    def floodFill(
        self, image: List[List[int]], sr: int, sc: int, color: int
    ) -> List[List[int]]:
        # T: O(m * n), S: O(m * n)
        rows, cols = len(image), len(image[0])
        original_color = image[sr][sc]

        if original_color == color:
            return image  # No need to change anything

        def dfs(r, c):
            # Base case: If out of bounds or color is different, stop
            if (
                r < 0
                or r >= rows
                or c < 0
                or c >= cols
                or image[r][c] != original_color
            ):
                return

            # Change color
            image[r][c] = color

            # Recur for 4 directions
            dfs(r + 1, c)  # Down
            dfs(r - 1, c)  # Up
            dfs(r, c + 1)  # Right
            dfs(r, c - 1)  # Left

        dfs(sr, sc)
        return image
