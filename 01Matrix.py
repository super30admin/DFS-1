# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had trouble thinking about whether to 
# start on the 1s or the 0s.. class clarified to start on the 0s 



# Your code here along with comments explaining your approach


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        """
        Find zeroes and put into queue
        do bfs based on those zeroes 
        """
        if not matrix:
            return []
        queue = deque([])
        #find zeroes
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    #put into queue
                    queue.append([i,j])
                else:
                    matrix[i][j] = -1
        dirs = [[0,1],
                [-1,0],
               [0,-1],
               [1,0]]
        dist = 1
        
        while queue:
            size = len(queue)
            
            for i in range(size):
                curr = queue.popleft()
                
                for direction in dirs:
                    row = direction[0] + curr[0]
                    col = direction[1] + curr[1]
                    
                    if row >= 0 and row < len(matrix) and col >= 0 and col < len(matrix[0]) and matrix[row][col] == -1:
                        matrix[row][col] = dist
                        queue.append([row,col])
                        
            dist += 1
            
        return matrix