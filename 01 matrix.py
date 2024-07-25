#// Time Complexity : O(n) 
# // Space Complexity : O(n)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : putting the zero in the queue insted of 1 initially was a bit tricy.
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        n = len(mat)
        m = len(mat[0])
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j] = -1
        dr = [-1,0,1,0]
        dc = [0,+1,0,-1]
        dist = 0
        while queue:
            size = len(queue)
            for i in range(size):
                cr,cc = queue.popleft()
                for j in range(4):
                    nr = cr + dr[j]
                    nc = cc + dc[j]
                    if nr >= 0 and nc >=0 and nr < n and nc < m and mat[nr][nc] == -1:
                        queue.append([nr,nc])
                        mat[nr][nc] = dist + 1 
            dist += 1
        
        return mat

# Approach:
# 1. Create a queue and push all the 0s into it.
# 2. Create a 4-directional array to move in all 4 directions.
# 3. Create a variable dist and initialize it to 0.
# 4. While queue is not empty, do the following:
# 1. Get the size of the queue.
# 2. For each element in the queue, do the following:
# 1. Pop the element from the queue.
# 2. For each direction in the 4-directional array, do the following:
# 1. Calculate the new row and column coordinates.
# 2. If the new row and column coordinates are within the bounds of the matrix and the value at
# the new coordinates is -1, do the following:
# 1. Push the new coordinates into the queue.
# 2. Set the value at the new coordinates to dist + 1.
# 3. Increment dist by 1.
# 5. Return the matrix.

# Here basically we are pushing all the 0 in the queue and if we find 1 in the direction then we push it they are at level 1 or distance 1 
# then the second iteration will be at level 2
