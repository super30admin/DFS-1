'''
Solution 1: BFS
we invert the question to find nearest 1 to all 0's. we use the same mat to update
the distance. When distance = 1, we put a temporary placeholder. 
Time complexity: O(m*n)
Space complexity: O(m*n)
'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)
        cols = len(mat[0])

        bfs_queue = deque()
        
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    bfs_queue.append([i,j]) # add all 0's in the queue
        
        directions = [[0,-1],[-1,0],[0,1],[1,0]] # left, top, right, bottom
 
        distance = 1
        while len(bfs_queue)!=0:
            size = len(bfs_queue)
            for k in range(size): # perform at this level
                row, col = bfs_queue.popleft()
                for direction in directions:
                    neigh_r, neigh_c = row + direction[0], col + direction[1]
                    if 0<=neigh_r<rows and 0<=neigh_c<cols:
                        if mat[neigh_r][neigh_c] == 1: # reached this '1' after this 'distancce' travelled
                            if distance == 1:
                                mat[neigh_r][neigh_c] = -1 # just a placeHolder to avoid visitng ones
                            else:
                                mat[neigh_r][neigh_c] = distance

                            bfs_queue.append([neigh_r, neigh_c]) 
                
            distance +=1 # going to next level, increase distance by 1
        
        # run over the matrix, for replacing the placeholder '-1' with distance=1

        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == -1:
                    mat[i][j] = 1
        
        return mat

        