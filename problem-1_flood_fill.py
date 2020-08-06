# APPROACH 1: BFS
# Time Complexity : O(mn), m: number of rows of the image, n: number of columns of the image
# Space Complexity : O(1), visited and changing to newColor in-place
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. To avoid going to the already visited node again and again, mark it as -1 * newColor as all colors are positive(given).
# 2. Proceed in BFS manner. Add starting node to queue, then pop and process it's neighbors and add only those nodes to the queue whose color was same as the old color of start 
#    node.
# 3. After queue is empty, then go through whole image again to set the negative cells to positive newColor.

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if image is None:
            return None
        
        queue, oldColor, dirs = deque(), image[sr][sc], [[0, -1], [0, 1], [-1, 0], [1, 0]]
        image[sr][sc] = -1 * newColor
        queue.append((sr,sc))
        
        while len(queue) > 0:
            pos = queue.popleft()
            for nei in dirs:
                if pos[0] + nei[0] >= 0 and pos[0] + nei[0] < len(image) and pos[1] + nei[1] >= 0 and pos[1] + nei[1] < len(image[0]) and image[pos[0] + nei[0]][pos[1] + nei[1]] == oldColor:
                    image[pos[0] + nei[0]][pos[1] + nei[1]] = -1 * newColor  
                    queue.append((pos[0] + nei[0], pos[1] + nei[1]))
                    
        for row in range(0, len(image)):
            for col in range(0, len(image[0])):
                if image[row][col] == -1 * newColor:
                    image[row][col] = newColor
                    
        return image



# APPROACH  2: DFS
# Time Complexity : O(mn), m: number of rows of the image, n: number of columns of the image
# Space Complexity : O(mn), O(1): visited and changing to newColor in-place but recursive stack size
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. To avoid going to the already visited node again and again, mark it as -1 * newColor as all colors are positive(given).
# 2.  Proceed in DFS manner. Call DFS on starting node. For each node, process it's neighbors and recursively call DFS only on those nodes whose color was same as the old color
#     of start node.
# 3. After recusive calles of DFS ends, then go through whole image again to set the negative cells to positive newColor.


class Solution:
    def __init__(self):
        self.dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]]
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if image is None:
            return None
        
        oldColor = image[sr][sc]
        self.dfs(image, sr, sc, oldColor, newColor)
        
        for row in range(0, len(image)):
            for col in range(0, len(image[0])):
                if image[row][col] == -1 * newColor:
                    image[row][col] = newColor
                    
        return image
    
    def dfs(self, image, row, col, oldColor, newColor):
        if row < 0 or row >= len(image) or col < 0 or col >= len(image[0]):
            return
        
        if image[row][col] == oldColor:
            image[row][col] = -1 * newColor
            for nei in self.dirs:
                self.dfs(image, row + nei[0], col + nei[1], oldColor, newColor)
