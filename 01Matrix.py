# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Intialize a queue and iterate over the matrix and if we find 1 in the matrix update it to -1 and if we find 0 append it to queue
# Until queue is empty iterate over the queue and pop the indexes i and j
# Initialize a list of tuples with the 4 directions or neighbors
# Iterate over the neighbors and get the row and col index by adding i and j with each neighbor
# Check the boundaries of row and col and check if the matrix[i][j] == -1 then append it to queue
# Update the matrix at index row and col to original matrix at index i and j + distance until for each level until the queue is not empty
# Then return matrix


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return None
        queue = deque([])
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 1:
                    matrix[i][j] = -1
                if matrix[i][j] == 0:
                    queue.append((i, j))

        dist = 1
        neighbors = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        while queue:
            i, j = queue.popleft()
            for neighbor in neighbors:
                row = i + neighbor[0]
                col = j + neighbor[1]
                if row >= 0 and row < len(matrix) and col >= 0 and col < len(
                        matrix[0]) and matrix[row][col] == -1:
                    queue.append((row, col))
                    matrix[row][col] = matrix[i][j] + dist

        return matrix
