class Solution:
    
    """
    Description: Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell
    
    Time Complexicity: O(m*n)
    Space Complexicity: O(m*n)
    where m and n are dimensions of the given matrix
    
    Approach: Use BFS
    - Take a queue with all zeros (independent), and convert all ones to -1
    - make every neighbor of the queue indices to 1 (if they equals -1)
    - use a sucessive distance value to update the same for neighbors of #2
    - add these indices in queue in every loop
    
    Important: run a for loop for the initial lenght of queue under the while loop
    Reason: ? (trying to investigate)
    """
    
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        from collections import deque
        if matrix == None or len(matrix) == 0: return 
        m = len(matrix); n = len(matrix[0])
        
        queue = deque()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append((i, j))
                else: matrix[i][j] = -1
                    
        dist = 1 # initial distance for the first level
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        while queue:
            for _ in range(len(queue)):
                row, col = queue.popleft()
                for d in dirs:
                    r = row + d[0]
                    c = col + d[1]
                    if r >= 0 and c >= 0 and r < m and c < n:
                        if matrix[r][c] == -1: 
                            matrix[r][c] = dist
                            queue.append((r, c))
            dist += 1
            
        return matrix
                
            
            
