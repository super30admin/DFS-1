class Solution(object):
    from collections import deque
    #T.C is O(mn)
    #S.C is O(mn)
    #All test cases passed in leetcode
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if image is None or image[sr][sc] == newColor:
            return image
        queue = deque()
        row_length = len(image)
        column_length = len(image[0])
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        prev_color = image[sr][sc]
        image[sr][sc] = newColor
        queue.append([sr, sc])

        while queue:
            ele_processing = queue.popleft()
            for dir_move in dirs:
                nr = ele_processing[0] + dir_move[0]
                nc = ele_processing[1] + dir_move[1]
                if nr >= 0 and nr < row_length and nc >= 0 and nc < column_length and image[nr][nc] == prev_color:
                    image[nr][nc] = newColor
                    queue.append([nr, nc])
        return image


class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if image is None or image[sr][sc] == newColor:
            return image
        self.row_length = len(image)
        self.column_length = len(image[0])
        self.dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        self.prev_color = image[sr][sc]

        self.dfs(image, sr, sc, newColor)
        return image

    def dfs(self, image, sr, sc, newColor):
        # base
        # print(self.prev_color, sr,sc,newColor, image[sr][sc])
        if sr < 0 or sc < 0 or sr >= self.row_length or sc >= self.column_length or image[sr][sc] != self.prev_color:
            return

        # logic
        image[sr][sc] = newColor
        # print(image[sr][sc])
        for dir_move in self.dirs:
            nr = dir_move[0] + sr
            nc = dir_move[1] + sc
            self.dfs(image, nr, nc, newColor)