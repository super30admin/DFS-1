from collections import deque


class Solution:
    def floodFillBFS(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        """
            https://leetcode.com/problems/flood-fill/
            // Time Complexity : O(mn)
                'm' is the noOfRows, 'n' is the noOfCols
            // Space Complexity : O(mn)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                    - Initialise variable to keep track of originalColor at given image[sr][sc]
                    - Start Level order traversal(BFS), Traverse in 4 directions
                    - At each point, when ever the current original_color == prevColor
                        - Change to the newColor
        """
        rows = len(image)
        cols = len(image[0])
        # edge case
        if not image or not rows: return image
        # no need to make change to the image
        if image[sr][sc] == newColor: return image

        #        right   left      up      down
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        queue = deque()
        queue.append((sr, sc))
        original_color = image[sr][sc]
        image[sr][sc] = newColor

        while queue:
            pixel = queue.popleft()
            # traverse to adj pixels
            for dir in dirs:
                row = pixel[0] + dir[0]
                col = pixel[1] + dir[1]
                if (row >= 0 and row < rows) and (col >= 0 and col < cols) and (image[row][col] == original_color):
                    image[row][col] = newColor
                    queue.append((row, col))
        return image

    def floodFillDFS(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        """
            https://leetcode.com/problems/flood-fill/
            // Time Complexity : O(mn)
                'm' is the noOfRows, 'n' is the noOfCols
            // Space Complexity : O(mn)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                   - Directions list, edge case for DFS
                   - change the pixel color to newColor if the current pixel
                     color is same as originalColor
        """
        # edge case
        if not image or not len(image[0]) or image[sr][sc] == newColor:
            return image

        #        right   left      up      down
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        self._dfs(image, dirs, sr, sc, image[sr][sc], newColor)
        return image

    def _dfs(self, image, dirs, row, col, originalColor, newColor):
        # base
        if (row < 0 or row >= len(image)) or (col < 0 or col >= len(image[0])) or (
                image[row][col] != originalColor): return
        # logic
        image[row][col] = newColor
        for dir in dirs:
            self._dfs(image, dirs, row + dir[0], col + dir[1], originalColor, newColor)
