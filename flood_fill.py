# Did this code successfully run on Leetcode : YES

# TC: O(M*N)
# SC: O(M*N)

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        starting_pixel = image[sr][sc]
        if starting_pixel == newColor:
            return image
        q = deque([[sr, sc]])
        while q:
            [x, y] = q.popleft()
            if 0 <= x < len(image) and 0 <= y < len(image[0]) and image[x][y] == starting_pixel:
                image[x][y] = newColor
                q.append([x+1, y])
                q.append([x-1, y])
                q.append([x, y-1])
                q.append([x, y+1])
        return image