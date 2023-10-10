# TC- O(n)  where n is the number of pixels in the image
# SC- O(n)
class Solution:
    def floodFill(self, image, sr, sc, newColor):
        color = image[sr][sc]
        if newColor != color:
            self.dfs(image, sr, sc, color, newColor)
        return image

    def dfs(self, image, r, c, color, newColor):
        if image[r][c] == color:
            image[r][c] = newColor
            if r >= 1:
                self.dfs(image, r - 1, c, color, newColor)
            if c >= 1:
                self.dfs(image, r, c - 1, color, newColor)
            if r + 1 < len(image):
                self.dfs(image, r + 1, c, color, newColor)
            if c + 1 < len(image[0]):
                self.dfs(image, r, c + 1, color, newColor)