"""
Time Complexity : O(mxn) m is no. of row and n is no. of cols
Space Complexity : O(mxn) m is no. of row and n is no. of cols
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if len(image) == 0 or newColor == image[sr][sc]:
            return image
        m = len(image)
        n = len(image[0])
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        color = image[sr][sc]
        # Adding starting element into the list
        q = deque([[sr,sc]])
        # Storing the starting element
        image[sr][sc] = newColor
        # Going through the queue and adding element as we go through pixels
        while q:
            curr = q.popleft()
            # Traverse through the dirs list and find the pixel with same color
            for item in dirs:
                r = curr[0] + item[0]
                c = curr[1] + item[1]
                if r >= 0 and r < m and c >= 0 and c < n and image[r][c] == color:
                    q.append([r,c])
                    image[r][c] = newColor
        return image
        