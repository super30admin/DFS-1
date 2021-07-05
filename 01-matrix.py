# OPTIMIZED BFS
# Time Complexity: O(mn)
# Space Complexity: O(mn)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # Null condition check
        if mat == None or len(mat) == 0:
            return matrix
        # Declare a queue and len of rows and columns
        q = deque()
        m = len(mat)
        n = len(mat[0])
        
        # Traverse the matrix 
        # Append the row and column index to the queue if the element in the matrix is 0
        # Else, just change the elements to -1
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append(i)
                    q.append(j)
                else:
                    mat[i][j] = -1
        
        # Maintain a dist variable to make note of visited elements
        # Can be done without dist, just by using the mat[nr][nc] = mat[r][c] + 1
        dist = 1
        dirs = [[1,0], [-1,0], [0,1], [0,-1]]
        while q:
            size = len(q)
            # Go through each level
            for i in range(0,size,2):
                # Pop the r and c index from queue
                r = q.popleft()
                c = q.popleft()
                # Use dirs array to traverse the neighbors
                for dir in dirs:
                    nr = r + dir[0]
                    nc = c + dir[1]
                    # Check boundary conditions
                    # If the element is -1, change to dist and append to the queue
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = dist
                        q.append(nr)
                        q.append(nc)
            # Keep incrementing dist for each level
            dist += 1
        return mat
                        