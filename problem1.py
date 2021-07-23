from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        #BFS
        if len(image)==0 or image[sr][sc]==newColor:
            return image
        
        startcolor=image[sr][sc]
        queue=deque()
        image[sr][sc]=newColor
        queue.append([sr,sc])
        m=len(image)
        n=len(image[0])
        dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        while(len(queue)>0):
            val=queue.popleft()
            for r1,c1 in dirs:
                xr=val[0]+r1
                xc=val[1]+c1
                if (0<=xr<m and 0<=xc<n and image[xr][xc]==startcolor):
                    image[xr][xc]=newColor
                    queue.append([xr,xc])
        return image
        # Time O(m*n)
        # Space O(m*n)
        
        #DFS
        # startcolor=image[sr][sc]
        # def dfs(row,col,startcolor):
        #     if 0<=row<len(image) and 0<=col<len(image[0]) and startcolor==image[row][col]:
        #         image[row][col]=newColor
        #         dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        #         for x,y in dirs:
        #             dfs(x+row,y+col,startcolor)
        # if startcolor==newColor:
        #     return image
        # dfs(sr,sc,startcolor)
        # return image
        # Time O(m*n)
        # Space O(m*n)
