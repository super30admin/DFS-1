# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#check if newcolor and prescolor is same or not, only if it not same add in queue
#else infinite loop
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        m = len(image)
        n = len(image[0])
        ic = image[sr][sc]
        queue = deque()
        
        image[sr][sc] = newColor
        
        queue.append([sr,sc])
        
        while len(queue) != 0:
            print(queue)
            node = queue.popleft()
            
            dirs = [[-1,0],[1,0],[0,1],[0,-1]]
            
            for j in dirs:
                x = node[0]+j[0]
                y = node[1]+j[1]
                if x >= 0 and x < m and y >= 0 and y < n and image[x][y] == ic and image[x][y] != newColor:
                    queue.append([x,y])
                    image[x][y] = newColor
                    
        return image
                    
        
        