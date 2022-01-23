# // Time Complexity : O(nm) where n and m are the size of the matrix.
# // Space Complexity : O(nm) where n and m are the size of the matrix.
# // Did this code successfully run on Leetcode : Yes.
# // Any problem you faced while coding this : Yes.

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        queue = deque()
        if image[sr][sc] == newColor:
            return image
        oldColor = image[sr][sc]
        queue.append([sr,sc])
        while(len(queue) != 0):
            x,y = queue.popleft()
            if x >= 0 and y >= 0 and x < len(image) and y < len(image[0]) and image[x][y] == oldColor:
                image[x][y] = newColor
                for i in range(len(dirs)):
                    x1 = x + dirs[i][0]
                    y1 = y + dirs[i][1]
                    queue.append([x1,y1])
        return image
