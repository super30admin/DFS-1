"""
Problem : 1

Time Complexity : O()
Space Complexity : O()

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No



"""

# Flood Fill

# Approach - 1
# BFS

class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        original=image[sr][sc]
        if image[sr][sc]==color:
            return image
        q=collections.deque()
        q.append((sr,sc))
        image[sr][sc]=color
        directions=[[0,1],[0,-1],[1,0],[-1,0]]
        m=len(image)
        n=len(image[0])
        while q:

            start=q.popleft()
            for dirs in directions:
                r=dirs[0]+start[0]
                c=dirs[1]+start[1]
                if r<m and r>=0 and c<n and c>=0 and image[r][c]==original:
                    image[r][c]=color
                    q.append((r,c))
        return image


# Approach - 2
# DFS

class Solution(object):
    def __init__(self):
        self.directions=[[0,1],[0,-1],[-1,0],[1,0]]
        self.rimage=None

    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """

        
        if image[sr][sc]==color or not image:
            return image
        # image[sr][sc]=color
        original=image[sr][sc]
        m=len(image)
        n=len(image[0])

        self.dfs(image,sr,sc,original,color,m,n)
        return image

    def dfs(self,image,r,c,orig,color,m,n):
        if r<0 or r>=m or c<0 or c>=n or image[r][c]!=orig:
            return
        if image[r][c]==orig:
            image[r][c]=color
        for dirs in self.directions:
            nr=r+dirs[0]
            nc=c+dirs[1]
            self.dfs(image,nr,nc,orig,color,m,n)

        

        
        # original=image[sr][sc]
        # if image[sr][sc]==color:
        #     return image
        # q=collections.deque()
        # q.append((sr,sc))
        # image[sr][sc]=color
        # directions=[[0,1],[0,-1],[1,0],[-1,0]]
        # m=len(image)
        # n=len(image[0])
        # while q:

        #     start=q.popleft()
        #     for dirs in directions:
        #         r=dirs[0]+start[0]
        #         c=dirs[1]+start[1]
        #         if r<m and r>=0 and c<n and c>=0 and image[r][c]==original:
        #             image[r][c]=color
        #             q.append((r,c))
        # return image


