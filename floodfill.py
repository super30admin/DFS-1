# Time Complexity: O(n)
# Space Complexity: O(n)
from collections import deque
class Solution(object):
    # DFS solution check if current element is of current color and
    # change it to the new color and check for its valid child and call the same function recursivly on that child
    def dfsSolution(self, row, col, image, curr_color, new_color):
        direc = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        if image[row][col] == curr_color:
            image[row][col] = new_color

            for d in direc:
                r = row + d[0]
                c = col + d[1]

                if len(image) > r >= 0 and len(image[0]) > c >= 0 and image[r][c] == curr_color:
                    self.dfsSolution(r, c, image, curr_color, new_color)

        return image

    def dfsMain(self, image, sr, sc, newColor):

        curr_color = image[sr][sc]

        if curr_color == newColor:
            return image

        return self.dfsSolution(sr, sc, image, curr_color, newColor)

    #     Bfs Solution
    # Maintain a queue and given start element make it change to new color and add it to queue
    def Bfs(self, image, sr, sc, newColor):
        q = deque()

        curr_color = image[sr][sc]
        if curr_color == newColor:
            return image
        image[sr][sc] = newColor
        q.append([sr, sc])
        direc = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        #         Iterate over queue until it is empty
        #       Pop the lement and check its valid children and have the current color then we will change it to new color and add it to queue
        while q:
            row, col = q.popleft()

            for d in direc:
                r = row + d[0]
                c = col + d[1]

                if len(image) > r >= 0 and len(image[0]) > c >= 0 and image[r][c] == curr_color:
                    image[r][c] = newColor
                    q.append([r, c])

        return image

    def floodFill(self, image, sr, sc, newColor):
        return self.dfsMain(image, sr, sc, newColor)
        return self.Bfs(image, sr, sc, newColor)

        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
