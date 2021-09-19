# TC and SC - 0(m*n)


class Solution(object):
    # m,n
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        m,n = len(image),len(image[0])
        color = image[sr][sc]
        if color == newColor : return image
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        def dfs(sr,sc):
            if (sr<0 or sc< 0 or sr ==m or sc ==n or image[sr][sc]!=color): return
            image[sr][sc]= newColor
            for dir in dirs:
                r = sr+dir[0]
                c = sc+dir[1]
                dfs(r,c)
        dfs(sr,sc)
        return image
