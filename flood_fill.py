"""
APPROACH:
1. Note the original color of the starting pixel, and return early if it already matches the target color.
2. Otherwise, start BFS from the starting pixel, changing its color right away to avoid reprocessing it.
3. For each pixel processed, check its 4 neighbors (up, down, left, right).
4. If a neighbor matches the original color, change it to the new color and add it to the queue.
5. Continue until no more matching neighbors remain, meaning the entire connected region is filled.

PATTERN:
Grid BFS / Flood Fill

TIME COMPLEXITY:
O(m x n) - every pixel is visited and processed at most once

SPACE COMPLEXITY:
O(m x n) - queue can hold up to all pixels in the worst case

EXAMPLE:
Input:
image = [
  [1,1,1],
  [1,1,0],
  [1,0,1]
]
sr = 1, sc = 1, color = 2

Output:
[
  [2,2,2],
  [2,2,0],
  [2,0,1]
]
Why: starting pixel's color (1) spreads to all connected 1s, isolated 1 at (2,2) is untouched
"""

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
         
        q = collections.deque()  # queue used for BFS

        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]  # up, down, right, left
        rows = len(image)  # number of rows
        columns = len(image[0])  # number of columns

        existing_color = image[sr][sc]  # original color of starting pixel

        # if target color is same as original, no changes needed
        if existing_color == color:
            return image
        
        q.append([sr, sc])  # start BFS from the given pixel
        image[sr][sc] = color  # color the starting pixel right away

        while q:
            curr = q.popleft()  # process next pixel
            curr_row = curr[0]
            curr_column = curr[1]

            # check all 4 neighbors of current pixel
            for dir in dirs:
                next_row = curr_row + dir[0]
                next_column = curr_column + dir[1]

                # check neighbor is inside image bounds
                if next_row >= 0 and next_row < rows and next_column >= 0 and next_column < columns:
                    # only fill neighbor if it matches the original color
                    if image[next_row][next_column] == existing_color:
                        q.append([next_row, next_column])  # add neighbor to queue
                        image[next_row][next_column] = color  # color the neighbor
              
        return image  # image with flood fill applied