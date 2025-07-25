# Time Complexity: O(m*n)
# Space Complexity: O(m) #recursive stack height

from collections import deque


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.m = len(image)
        self.n = len(image[0])
        self.dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        old_color = image[sr][sc]
        if old_color == color:
            return image

        def dfs(sr, sc):
            if sr < 0 or sc < 0 or sr == self.m or sc == self.n or image[sr][sc] != old_color:
                return

            image[sr][sc] = color
            for j in self.dirs:
                r = sr + j[0]
                c = sc + j[1]
                dfs(r, c)

        dfs(sr, sc)
        return image

        # queue=collections.deque()
        # queue.append([sr,sc])
        # image[sr][sc]=color

        # while queue:
        #     size=len(queue)
        #     for i in range(size):
        #         val=queue.popleft()
        #         for j in self.dirs:
        #             nr=val[0]+j[0]
        #             nc=val[1]+j[1]
        #             if nr>=0 and nc>=0 and nr<self.m and nc<self.n and image[nr][nc]==old_color:
        #                 image[nr][nc]=color
        #                 queue.append([nr,nc])

        # return image


