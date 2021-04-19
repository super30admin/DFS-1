from collections import deque

class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """

        # If color to change is same as current color, return
        if image[sr][sc] == newColor:
            return image
        
        directions = [(0,1), (0,-1), (1,0), (-1,0)]
        m,n = len(image), len(image[0])
        color = image[sr][sc]
        
        ### DFS
        def dfs(row, col):
            
            # Base Case
            if row < 0 or col < 0 or row == m or col == n or image[row][col] != color:
                return
            
            # Update Color, Visit all neighbor nodes
            image[row][col] = newColor
            for dx,dy in directions:
                new_r, new_c = row+dx, col+dy
                dfs(new_r, new_c)
        
        dfs(sr,sc)

        return image

### Complexity Analysis

# Time Complexity: O(mxn) --> m = number of rows, n = number of cols. We visit the entire matrix in worst case
# Space Complexity: O(mxn) --> Recursive stack can contain entire matrix in worst case.

