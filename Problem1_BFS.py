# Time complexity : O(m*n)
# Space complexity : O(m*n)
# Leetcode : Solved and submitted

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        # put directions in 4 directions as tuple
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        
        # if the image is empty or the color is same as the color to be changes, then 
        # return the image list as it is
        if not image or image[sr][sc] == color:
            return image
        
        # find the rows and cols of the matrix
        rows = len(image)
        cols = len(image[0])
        
        # put the index of the starting pixel into the queue and we traverse until it is empty
        q = deque([(sr,sc)])
        
        # storing the old color to check for other pixels
        old_color = image[sr][sc]
        while q:
            # pop the position from queue
            ro, co = q.popleft()
            for di in dirs:
                # find the new pixel position
                r = ro + di[0]
                c = co + di[1]
                
                # check for boundaries and if pixel has same color, then change to new color
                # and also append it's neighbors to the queue
                if r >=0 and r < rows and c >= 0 and c < cols and image[r][c] == old_color:
                    image[r][c] = color
                    q.append((r,c))
                    #print(q)
        # lastly, change the starting pixel to new color
        image[sr][sc] = color
        
        return image
        
        
