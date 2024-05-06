## Problem1 (https://leetcode.com/problems/flood-fill/)

# Approach
# If original color and new color are same, return. Add the row,column of start in a queue. 
# While queue is not empty, for each element check all 4 neighbors. If the neighbors have original_color, change it to new color and add it to the queue
# Traverse till queue is empty. Return image

# Time Complexity: O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        if image[sr][sc]==color:
            return image
        
        og_color = image[sr][sc]
        image[sr][sc] = color
        q = deque([[sr,sc]])
        directions = [[-1,0],[0,-1],[1,0],[0,1]]

        while q:
            size = len(q)
            for i in range(size):
                r,c = q.popleft()
                for d in directions:
                    nr = r + d[0]
                    nc = c + d[1]
                    if (0<=nr<m and 0<=nc<n and image[nr][nc] == og_color):
                        image[nr][nc] = color
                        q.append([nr,nc])
                  
        return image


