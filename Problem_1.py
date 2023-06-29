"""
Problem : 1

Time Complexity : O(m*n)
Space Complexity : O(m*n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

For BFS - 
Appending the input row and column number to queue to initiate flooding
checking the neighbors are inbounds and their color matches the color of
source, then changing their color and appending them to the queue and repeating until all cells are visited and queue becomes empty


For DFS - 
Calling the dfs recursive function on the source row and column number given
checking the neighbors are inbounds and their color matches the color of
source, then changing the color and recusrsively calling dfs function on all the neighbors
terminating only when encountered neighbors out of bounds or encountered cell with color not matching 
with the color of the source cell



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


