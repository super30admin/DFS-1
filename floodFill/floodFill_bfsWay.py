'''
// Time Complexity : 0(m*n)
// Space Complexity : 0(min(m,n)) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''

from collections import deque

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        # rows and cols
        m = len(image)
        n = len(image[0])
        
        # initialize dirMatrix
        dirMatrix = [
            [0,1],  # right
            [0,-1], # left
            [-1,0], # top
            [1,0]   # bottom
        ]
        
        # Initialize queue
        queue = deque([])
        
        # Append (sr,sc) to the queue
        queue.append((sr,sc))
        
        # Initialize starting-color
        stColor = image[sr][sc]
        
        # initial and newColor are same
        if stColor == newColor:
            return image
        
        # Iterate the queue
        while len(queue) != 0:
            
            # get the size of the queue
            size = len(queue)
            
            # iterate till we reach size
            for i in range(0,size):
                
                # pop the element from the queue
                ele = queue.popleft()
                
                if image[ele[0]][ele[1]] == stColor:
                    image[ele[0]][ele[1]] = newColor
                
                # Iterate the dirMatrix
                for pair in dirMatrix:
                    
                    # create temp row and column
                    temp_i = ele[0] + pair[0]
                    temp_j = ele[1] + pair[1]
                    
                    # check if dir is valid
                    if ((temp_i >= 0 and temp_i < m ) and (temp_j >= 0 and temp_j < n )) and (image[temp_i][temp_j] == stColor):
                        image[temp_i][temp_j] = newColor
                        queue.append((temp_i,temp_j))
                    
        
        #print('Updated matrix is:\t',image)
        
        return image