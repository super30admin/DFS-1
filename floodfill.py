class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if image is None or image[sr][sc]==newColor:
            return image
        # from collections import deque
        # q=deque()
        # q.append((sr,sc))
        # dirs=((0,1),(1,0),(-1,0),(0,-1))
        initial=image[sr][sc]
        # while q:
        #     print(q)
        #     curr=q.popleft()
        #     i=curr[0]
        #     j=curr[1]
        #     image[i][j]=newColor
        #     for dir in dirs:
        #         x=i+dir[0]
        #         y=j+dir[1]
        #         if x>=0 and x<len(image) and y>=0 and y<len(image[0]) and image[x][y]==initial:
        #             q.append((x,y))
        # return image
              #bfs,dfs- time and space - n*m
        def dfs(image,r,c):
            if r>=0 and r<len(image) and c>=0 and c<len(image[0]) and image[r][c]==initial:
                image[r][c]=newColor
                dfs(image,r,c+1)
                dfs(image,r+1,c)
                dfs(image,r,c-1)
                dfs(image,r-1,c)
            else:
                return
        dfs(image,sr,sc)
        return image