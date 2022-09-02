'''
Time complexity - O(m*n)
Space complexity - O(m*n)
'''


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color:
            return image
        m = len(image)
        n = len(image[0])

        prev = image[sr][sc]
        self.dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        self.helper(image, prev, color, sr, sc, m, n)
        return image

    def helper(self, image, prev, color, r, c, m, n):
        if r < 0 or r == m or c < 0 or c == n or image[r][c] != prev:
            return
        if image[r][c] == prev:
            image[r][c] = color

        for d in self.dirs:
            self.helper(image, prev, color, r+d[0], c+d[1], m, n)
        return
