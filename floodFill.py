# Time Complexity : O(N) where N is the number of elements
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        rows, cols = len(image), len(image[0])
        startPx = image[sr][sc]
        # dfs function
        def dfs(r, c):
            # Check out of bounds, our base case
            if r < 0 or c < 0 or r >= rows or c >= cols or image[r][c] != startPx:
                return
            # Recursive Cases
            if image[r][c] != color:
                image[r][c] = color
                # Connected pixels
                dfs(r+1, c)
                dfs(r-1, c)
                dfs(r, c+1)
                dfs(r, c-1)
            else:
                return
        # Call the dfs
        dfs(sr, sc)
        return image
