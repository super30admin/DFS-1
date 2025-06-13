# Time Complexity: O(M * N), M * N is the size of the image
# Space Complexity: O(M * N)
# Did this code successfully run on Leetcode: Yes

from collections import deque
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original_color = image[sr][sc]

        if original_color ==  color:
            return image
        
        m = len(image)
        n = len(image[0])
        
        queue = deque()
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        queue.append([sr, sc])
        image[sr][sc] = color

        while len(queue):
            popped = queue.popleft()

            for direction in directions:
                new_row = popped[0] + direction[0]
                new_col = popped[1] + direction[1]

                if new_row >= 0 and new_col >= 0 and new_row < m and new_col < n and image[new_row][new_col] == original_color:
                    queue.append([new_row, new_col])
                    image[new_row][new_col] = color
        
        return image

