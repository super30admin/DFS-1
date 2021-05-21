from typing import List
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

        if image is None or len(image[0]) == 0: return image
        levelorder = deque()
        row = len(image)
        column = len(image[0])
        color=image[sr][sc]
        image[sr][sc] = newColor
        levelorder.append([sr,sc])

        direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while levelorder.__len__() > 0:
            size = levelorder.__len__()
            for idx in range(size):
                node = levelorder.popleft()
                for index in direction:
                    r = node[0] + index[0]
                    c = node[1] + index[1]
                    if r >= 0 and r < row - 1 and c >= 0 and c < column - 1 and image[r][c] == color:
                        image[r][c] = newColor
                        levelorder.append([r, c])


        return image
# time O(m*n)
# SpaceO(m*n)


if __name__ == '__main__':
    print(Solution().floodFill())