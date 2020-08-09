# Leetcode 733. Flood Fill

# Time Complexity :  O(m X n) where m X n is the size of the grid

# Space Complexity : O(m X n) where m X n is the size of the grid

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# DFS:: Store the present color for future comparision and start dfs on givenn target. In every dfs
# iteration change the color to target and call dfs recursively on its neighbours. If the color is not
# same as the original color then return else return the image at the end of dfs.
# BFS :: store the color for comparision. and update the color to target. Start with the first cordinates in queue
# and Pop the left from queue and if the color of the negihbours is same as original color, then update to
# target color and them to queue. Once the  queue is empty return

# Your code here along with comments explaining your approach

# DFS
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # base
        # If image length is 0 or image is null or if the present color == target then return image
        if not image or len(image) == 0 or image[sr][sc] == newColor:
            return image
        # Store the old color for comparision
        color = image[sr][sc]
        self.dfs(image, sr, sc, newColor, color)
        return image

    def dfs(self, image, sr, sc, newColor, color):
        # Base or exit
        # If the matrix coordinates are out of bounds or if image color != original color
        if len(image) <= sr or sr < 0 or len(image[0]) <= sc or sc < 0 or image[sr][sc] != color:
            return
        # Logic
        dirs = {(0, 1), (0, -1), (1, 0), (-1, 0)}
        # Update the color with target and call dfs recursively on its neighbours
        image[sr][sc] = newColor
        for direc in dirs:
            r = direc[0] + sr
            c = direc[1] + sc
            self.dfs(image, r, c, newColor, color)


# BFS
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # base
        # If image length is 0 or image is null or if the present color == target then return image
        if not image or len(image) == 0 or image[sr][sc] == newColor:
            return image
        # Store the old color for comparision
        color = image[sr][sc]
        # Update the color to target before adding it to queue
        image[sr][sc] = newColor
        q = deque()
        # Add the original cordinates to queue
        q.append((sr, sc))

        dirs = {(0, 1), (0, -1), (1, 0), (-1, 0)}
        # While q is not empty
        while q:
            # Remove. from q
            i, j = q.popleft()

            for direc in dirs:
                r = direc[0] + i
                c = direc[1] + j
                # if the neighbours are of original color and in the matrix bounds update color
                # and add them to the queue
                if len(image) > r >= 0 and len(image[0]) > c >= 0 and image[r][c] == color:
                    image[r][c] = newColor
                    q.append((r, c))
        # When the queue is empty return the image
        return image
