# Time Complexity:O(mn) (where m:rows,n:columns)
# Space Complexity:O(mn) (where m:rows,n:columns)
# Did this code successfully run on LeetCode?:Yes
# Problems faced while coding this:None
# Approach: BFS approach

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if image is None or len(image) == 0 or image[sr][sc] == newColor:
            return image

        q = deque()

        row = len(image)
        col = len(image[0])

        original_color = image[sr][sc]
        image[sr][sc] = newColor
        
        q.append((sr, sc))
        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]

        while q:

            cr, cc = q.popleft()

            for dir in dirs:
                r = cr + dir[0]
                c = cc + dir[1]

                if r >= 0 and r < row and c >= 0 and c < col and image[r][c] == original_color and image[r][c] != newColor:
                    image[r][c] = newColor
                    q.append((r,c))

        return image