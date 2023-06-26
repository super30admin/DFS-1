# Using DFS
# Time and Space Complexity = O(mxn)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None or len(image) == 0:
            return image
        orig = image[sr][sc]
        if orig == color:
            return image
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        self.dfs(image, sr, sc, orig, color, dirs)
        return image

    def dfs(self, image: List[List[int]], r: int, c: int, orig: int, color: int, dirs: List[List[int]]):
        # base
        if r < 0 or c < 0 or r == len(image) or c == len(image[0]) or image[r][c] != orig:
            return
        # logic
        image[r][c] = color
        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            self.dfs(image, nr, nc, orig, color, dirs)
