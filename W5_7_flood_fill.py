class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        m = len(image)
        n = len(image[0])

        self.original = image[sr][sc]

        if self.original == color:
            return image

        self.dfs(image, sr, sc, color)

        return image

    def dfs(self, grid, r, c, color):
        
        # Base
        if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] != self.original:
            return

        # Logic
        grid[r][c] = color

        for dir in self.dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            self.dfs(grid, nr, nc, color)

        return grid

# Time complexity: O(m * n), where m is the number of rows and n is the number of columns.
# Each cell is visited at most once.

# Space complexity: O(m * n), due to the DFS recursion stack in the worst case.