---------------------------------- Update Matrix with distance to 0 ---------------------------------------------
# Time Complexity : O(MXN) M is the number of rows and N is the number of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the array and if the element is 1 then we can update the matrix with bfs function and distance.
#If the element is 0 then the distance is always 0. In BFS function we can append the (i,j) into queue, by iterating through queue,
# we wil return the distance if the element is 0 or any of its neighbors are 0



class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return []
       
        def bfs(i,j):
            queue = collections.deque([(i,j,0)])
            while queue:
                row, col, d = queue.popleft()
                
                if matrix[row][col] == 0:
                    return d
                
                for k,l in [(row+1, col), (row-1, col), (row, col+1), (row, col-1)]:
                    if 0<=k<m and 0<=l<n:
                        queue.append((k,l, d+1))
                
        m = len(matrix)
        n = len(matrix[0])
        dist = [[-1 for i in range(m)] for j in range(n)]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    matrix[i][j] = bfs(i,j)
        return matrix