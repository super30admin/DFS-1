class Solution:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        if image[sr][sc] == newColor: return image
        # edge case
        if len(image) == 0 or image is None: return image
        queue = [] # Initialize queue
        color = image[sr][sc] # old color
        queue.append([sr,sc]) # append given base row and column to start with to the queue
        # initialize a boolean visted matrix to keep track of visited cells in the matrix.
        visited = [[False for i in range(len(image[0]))] for j in range(len(image))]
        visited[sr][sc] = True # change the given cell to True in visited matrix as it is visited
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]] # initialize a dirs array for moving.
        while queue: # until queue is not empty
            curr = queue.pop(0) # pop first element
            image[curr[0]][curr[1]] = newColor # assign newcolor to the popped element
            for dir in dirs:
                i = dir[0] + curr[0]
                j = dir[1] + curr[1]
                if (i >= 0 and i < len(image) and
                   j >= 0 and j < len(image[0]) and
                    image[i][j] == color and visited[i][j] == False):
                    queue.append([i,j])
                    visited[i][j] = True
        return image