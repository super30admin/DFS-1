class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        # TC O(mn)
        # SC O(mn)
        if image is None or len(image) == 0  or image[sr][sc] == newColor:
            return image
        color = image[sr][sc]
        m = len(image)
        n= len(image[0])
        que = deque([])
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        que.append([sr,sc])
        image[sr][sc] = newColor
        while len(que) > 0:
            cur = que.popleft()
            for d in dirs:
                r = cur[0] + d[0]
                c = cur[1] + d[1]
                # print("bf,", r, c )
                if ( r < m) and (r >= 0) and (c <n) and (c >= 0) and (image[r][c] == color):
                    que.append([r,c])
                    # print("af,", image[r][c] )
                    image[r][c] = newColor
                    # print("bf,", image[r][c] )
        return image
