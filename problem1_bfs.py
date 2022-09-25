"""
Time Complexity : O(m*n) where m is the number of rows and n is the number of cols of the imput matrix.
                  This is because we have to iterate through all the members of the matrix
Space Complexity : O(m*n) where m is the number of rows and n is the number of cols of the input matrix.
                   In the worst case, queue can have all the matrix elements.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
We can use bfs or dfs here as it is a connected component's problem. So connected component's means for every color change we have to again make sure to change the color if the neibour's of lastly changed cell memebers are also same as the old color.

To apply the BFS, 
1. Append the source cell to the queue and perform the bfs until queue becomes empty.
2. BFs should be perfromed in 4 directions.
3. Cell memeber will be put in a queue if it has same color as the source cell's color and its color will be changed to the new color at the time when it is added to the queue.
"""
from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if len(image) == 0 or image[sr][sc] == color:
            return image
        
        rows = len(image)
        cols = len(image[0])
        directions = [[-1,0],[1,0],[0,1],[0,-1]] 
        queue = Queue()
        
        oldColor = image[sr][sc]
        queue.put([sr,sc])
        image[sr][sc] = color
        
        #bfs
        while(queue.empty() != True):
            curr = queue.get()
            for dire in directions:
                nr = curr[0] + dire[0]
                nc = curr[1] + dire[1]
                
                if nr >= 0 and nc >= 0 and nr < rows and nc < cols and image[nr][nc] == oldColor:
                    queue.put([nr,nc])
                    image[nr][nc] = color
                    
        return image
        