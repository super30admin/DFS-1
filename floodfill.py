# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#

# Your code here along with comments explaining your approach
# I start at the given indices on the matrix if it is already newColor then abort else
# I use BFS to iterate all the neighbors of the elements in my queue. Only the elements that are equal to old color
# will be added to the queue 

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        old_color = image[sr][sc]
        if newColor == old_color: return image
        q = deque()
        q.append((sr,sc))
        image[sr][sc] = newColor
        directions = [(0,-1),(1,0),(0,1),(-1,0)]
        bounds = [len(image), len(image[0])]
        while len(q) > 0:
            current = q.popleft()
            for direction in directions:
                i = current[0] + direction[0]
                j = current[1] + direction[1]
                if i >=0 and i<bounds[0] and j>=0 and j<bounds[1] and image[i][j] == old_color:
                    image[i][j] = newColor
                    q.append((i,j))
                    
        return image