from collections import deque


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None or len(image) == 0 or image[sr][sc] == color:
            return image

        m = len(image)
        n = len(image[0])
        ogColor = image[sr][sc]
        image[sr][sc] = color
        row = deque()
        column = deque()

        row.append(sr)
        column.append(sc)
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        while row:
            cr = row.popleft()
            cc = column.popleft()

            for d in dirs:
                nr = cr + d[0]
                nc = cc + d[1]
                if (nr >= 0 and nc >= 0) and (nr < m and nc < n) and image[nr][nc] == ogColor:
                    image[nr][nc] = color
                    row.append(nr)
                    column.append(nc)
        return image

# BFS
# Time complexity : O(m * n)
# Space complexity : O(m * n)
# Did this code successfully run on Leetcode? Yes
# Any problem you faced while coding this? No
