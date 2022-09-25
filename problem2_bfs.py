"""
Time Complexity : m*n where m is the number of rows and n is the number of cols. In worst case m*n i.e all elements can be in queue.
Space Complexity : m*n where m is the number of rows and n is the number of cols, in worst case, in queue m*n elements can be in a queue.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
1 is dependednt on 0 and hence bfs will be applied on every 0.
Otherwise bfs needs to be applied separetely on each 1 and it will have T.C of (m*n)^2 where m is the number of rows and n is the number of columns. This is because we will perfrom bfs on each 1. Space Complexity will be m*n as we will use the same queue for every bfs.

bfs.
1. First we will convert every 1 to -1
2. Put all 0s to the queue
3. Perform bfs on every 0
4. Maintain size of the queue and level order
5. If -1 is found then change its value to level + 1 and append to queue.
"""
from queue import Queue
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if len(mat) == 0:
            return mat
        rows = len(mat)
        cols = len(mat[0])
        queue = Queue()
        level = 0
        directions = [[-1,0],[1,0],[0,1],[0,-1]]
        
        #convert 1 to -1 and put 0s to the queue
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                if mat[i][j] == 0:
                    queue.put([i,j])
                
        while(queue.empty() != True):
            size = queue.qsize()
            level += 1
            for i in range(size):
                curr = queue.get()
                for dire in directions:
                    nr = dire[0] + curr[0]
                    nc = dire[1] + curr[1]
                    
                    if nr >= 0 and nc >=0 and nr < rows and nc < cols and mat[nr][nc] == -1:
                        queue.put([nr,nc])
                        mat[nr][nc] = level 
        
        return mat
            
            
        
                    
        