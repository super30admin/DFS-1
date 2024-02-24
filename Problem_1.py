#
# @lc app=leetcode id=733 lang=python3
#
# [733] Flood Fill
#

# @lc code=start
'''
Time Complexity - O(mn) for both BFS and DFS. Worst case start pixel 0,0
Space Complexity - O(min(m, n)) for BFS (At max number of processed pixels is the length of diagonal which is always min(m,n) ). O(mn) for DFS, we keep on adding to stack until we reach an element where we cannot move in any direction

Both BFS and DFS are working on Leetcode.
'''
from collections import deque
class Solution:
    def __init__(self):
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]]
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        #BFS
        if image[sr][sc] == color: #check if start pixel has same color as new color
            return image #then we do not need to proceed as per description
        originalColor = image[sr][sc] #keep the original color
        q = deque() #create queue
        q.append((sr, sc)) #append start pixel 
        
        image[sr][sc] = color #paint the start pixel with new color
        while q: #continue until we finish coloring all pixels
            pos = q.popleft() #pop the first pixel in the queue
            r = pos[0] #store its position
            c = pos[1] 
            for dir in self.dirs: #check in 4 direction up, down, left, right (we maintained direcion array above)
                nr = r + dir[0]
                nc = c + dir[1] 
                if nr >=0 and nr <len(image) and nc >=0 and nc<len(image[0]) and image[nr][nc] == originalColor: #if pixel is within bounds and has the original color then only paint with new color and add it to queue to paint neighboring pixels
                    image[nr][nc] = color
                    q.append((nr,nc)) #to paint neighboring pixels add them to queue
        #DFS
        #self.dfs(image, sr, sc, color, originalColor) #call DFS
        return image        

    def dfs(self,image, r, c, color, originalColor):
        #base
        if r <0 or r ==len(image) or c <0 or c==len(image[0]) or image[r][c] != originalColor: #if the pixel is out of image bounds or is not painted with original color, do not proceed and return
            return
        #logic
        image[r][c] = color #else paint the pixel with the new color
        for dir in self.dirs: 
            nr = r + dir[0]
            nc = c + dir[1]
            self.dfs(image, nr, nc, color, originalColor) #paintNextNeighbor with same process



# @lc code=end

