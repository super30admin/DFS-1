# Time Complexity : O(mn)
# Space Complexity :O(mn)
# Passed on Leetcode: yes

import queue

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        q = queue.Queue()
        q.put([sr,sc])
        num = image[sr][sc]
        row = len(image)
        col = len(image[0])
    
        while not q.empty():
            
            r,c = q.get()
            image[r][c] = color
            #down
            if (0 <= r+1 and r+1 <= row-1) and (c >= 0 and c <= col-1) and (image[r+1][c] == num) and (image[r+1][c] != color):
                q.put([r+1, c])
            #up
            if (0 <= r-1 and r-1 <= row-1) and (c >= 0 and c <= col-1) and (image[r-1][c] == num) and (image[r-1][c] != color):
                q.put([r-1, c])
            #left
            if (0 <= r and r <= row-1) and (c-1 >= 0 and c-1 <= col-1) and (image[r][c-1] == num) and (image[r][c-1] != color):
                q.put([r, c-1])
            #right
            if (0 <= r and r <= row-1) and (c+1 >= 0 and c+1 <= col-1) and (image[r][c+1] == num) and (image[r][c+1] != color):
                q.put([r, c+1])
        return image