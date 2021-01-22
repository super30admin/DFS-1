# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Check the base condition if the color at given index = newColor then return image
# If not then assign the color at given index to a variable color
# Initialize a queue and update the color at given index to newcolor and append the indexes sr,sc to the queue
# Until queue is empty iterate over the queue and pop the indexes i and j
# Initialize a list of tuples with the 4 directions or neighbors
# Iterate over the neighbors and get the row and col index by adding i and j with each neighbor
# Check the boundaries of row and col and check if the color at new index row and col is equal to the color at given index then append it to queue
# Update the color at index row and col to newcolor until for each level until the queue is not empty
# Then return image


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int,
                  newColor: int) -> List[List[int]]:
        if image[sr][sc] == newColor:
            return image
        color = image[sr][sc]
        queue = deque([])
        image[sr][sc] = newColor
        queue.append((sr, sc))

        while queue:
            neighbors = [(0, 1), (1, 0), (-1, 0), (0, -1)]
            for i in range(len(queue)):
                i, j = queue.popleft()
                for neighbor in neighbors:
                    row = i + neighbor[0]
                    col = j + neighbor[1]
                    if row >= 0 and row < len(
                            image) and col >= 0 and col < len(
                                image[0]) and image[row][col] == color:
                        queue.append((row, col))
                        image[row][col] = newColor

        return image
