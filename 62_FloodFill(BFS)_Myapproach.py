# Accepted on Leetcode
# time - O(M*N), space - O(M*N)
class Solution:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        if image[sr][sc] == newColor: return image
        # edge case
        if len(image) == 0 or image is None: return image
        queue = [] # Initialize queue
        color = image[sr][sc] # old color
        queue.append([sr,sc]) # append given base row and column to start with to the queue
         # change the color immediately when added to the queue to avoid revisiting the node.
        image[sr][sc] = newColor
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]] # initialize a dirs array for moving.
        while queue: # until queue is not empty
            curr = queue.pop(0) # pop first element
            for dir in dirs:
                i = dir[0] + curr[0]
                j = dir[1] + curr[1]
                # check if the row and column index is within the matrix indices and cell color is same as old color
                # then append to queue and change color immediately.
                if (i >= 0 and i < len(image) and
                   j >= 0 and j < len(image[0]) and
                    image[i][j] == color ):
                    queue.append([i,j])
                    image[i][j] = newColor
        return image