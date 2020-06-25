"""

    Name : Shahreen Shahjahan Psyche
    Time : O(M*N) -> Visiting all the nodes at most
    Space : O(N)

    This code passed all the test case of Leetcode

"""
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        # edge case
        if not image:
            return []
        
        from collections import deque
        
        q = deque()
        
        # checking whether the given color is same as the existing color
        if newColor == image[sr][sc]:
            newColor = newColor * -1
        color = image[sr][sc]
        image[sr][sc] = newColor
        
        # pushing the starting point in the queue 
        q.append((sr, sc))
        
        # keeping a direction array to travarse in connected -  4 manner
        direction = [(-1, 0), (1, 0), (0, 1), (0, -1)]
        
        # length of image
        row = len(image)
        
        # width of image
        col = len(image[0])
        
        
        while q: # This runs for O(N)
            curr = q.popleft()
            for i in direction:
                r = i[0] + curr[0]
                c = i[1] + curr[1] 
                
                # checking the boundaries
                if r < row and r > -1 and c < col and c > -1:
                    if image[r][c] == color:
                        image[r][c] = newColor
                        q.append((r,c))
        
        # if I had the same color, I took the negetive value. I am just inverting back again.
        if newColor < 0:
            for i in range(len(image)):
                for j in range(len(image[0])):
                    if image[i][j] == newColor:
                        image[i][j] = image[i][j] * -1
                    
                    
            
        return image
            
        
        