# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Use a queue to visit neighbors with the same old color.
# Each valid neighbor is colored and added to the queue for further expansion.

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        oldColor = image[sr][sc]
        if oldColor == color:
            return image
        
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        rows, cols = len(image), len(image[0])

        q = deque()
        q.append([sr,sc])
        image[sr][sc] = color

        while q:
            curr = q.popleft()
            for dx, dy in dirs:
                r = curr[0] + dx
                c = curr[1] + dy

                if r >= 0 and c >= 0 and r < rows and c < cols and image[r][c] == oldColor:
                    image[r][c] = color
                    q.append([r, c])

        return image