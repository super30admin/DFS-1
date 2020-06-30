# Time Complexity : Add - O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Initially all the 0's are pushed on to the queue as they are independent
2. The 1's replaced with -1, to make sure they are not revsiited when BFS is performed
3. The minimum distance of any element with value 1 = level of predecessor + 1
'''

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        
        rows = len(matrix)
        cols = len(matrix[0])
        

        queue = deque()
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 0:
                    queue.append((i,j))
                else:
                    matrix[i][j] *= -1
                    
                    # matrix[i][j] = 
        
        dirs = [(0,-1),(0,1),(1,0),(-1,0)]
        
        level = -1
        while queue:
            
            level += 1
            size = len(queue)
            while size > 0:
            
                cur_x, cur_y = queue.popleft()

                for dir_x, dir_y in dirs:
                    new_x = cur_x + dir_x
                    new_y = cur_y + dir_y
                    
                    if new_x >=0 and new_x < rows and new_y >= 0 and new_y < cols and matrix[new_x][new_y] < 0: 
                        # print (new_x, new_y)
                        matrix[new_x][new_y] = level + 1
                        queue.append((new_x, new_y))
                
                size -= 1
                        
        return (matrix)