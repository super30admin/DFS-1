# Time Complexity: O(m*n) as we would be going through each element in the matrix
# Space Complexity: O(m*n) as we would be storing the elements in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The required actions are performed by keeping a queue, where we put in the starting row and column at first. 
Then we keep on popping the elements from the queue and check if the color of the popped element is same as 
the color of the starting element. If yes, we change the color of the popped element to the new color. We put 
the left element in the queue. We keep on doing this until the queue is empty. Finally, we return the image.
"""


from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) == 0 or color == None : return image

        q = deque()
        q.append((sr, sc))
        val = image[sr][sc]
        image[sr][sc] = color
        directions = [[-1,0], [1,0],[0,-1], [0,1]]

        if color == val: return image

        while q:
            cr, cc = q.popleft()
            for direction in directions:
                nr, nc = cr + direction[0], cc + direction[1]
                if nr >= 0 and nc >= 0 and nr < len(image) and nc < len(image[0]) and image[nr][nc] == val:
                    image[nr][nc] = color
                    q.append((nr, nc))

        return image
