# https://leetcode.com/problems/flood-fill/

# Time Complexity- O(m * n) Space Complexity- O(m * n)
from collections import deque
class Solution:
    def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:
        self.directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        self.m = len(image)
        self.n = len(image[0])
        # define the variable having the starting pixel value so that we can use this variable to check the neighbors because starting pixel needs to change with given color
        oldcolor = image[sr][sc]
        # check if the starting pixel is same as the color to filled with
        if oldcolor == color:
            # if yes return the image
            return image
        # define BFS queue
        q = deque()
        # append the starting pixel because it's the starting point of the bfs
        q.append([sr, sc])
        # change the starting pixel to the given color
        image[sr][sc] = color

        while q:
            # pop the left element
            curr = q.popleft()
            # iterate over the directions to find the neighbor pixels of the current
            for dir in self.directions:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]
                # check the edge cases and condition when the neighbor pixel same as starting pixel
                if r >= 0 and c >= 0 and r < self.m and c < self.n and      image[r][c] == oldcolor:
                    # update with the given color
                    image[r][c] = color
                    # append into the deque
                    q.append([r,c])

        return image


solution = Solution()
print(solution.floodFill([[1,1,1],[1,1,0],[1,0,1]],1,1,2))
