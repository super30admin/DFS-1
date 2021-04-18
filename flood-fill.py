# Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image:
            return image

        color = image[sr][sc]

        if color == newColor:
            return image

        m = len(image)
        n = len(image[0])

        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(r, c):

            if r < 0 or r >= m or c < 0 or c >= n or image[r][c] != color:
                return

            image[r][c] = newColor

            for d in dirs:
                row = r + d[0]
                col = c + d[1]

                dfs(row, col)

        dfs(sr, sc)

        return image