class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        #bfs
        #O(m*n) for both
        color=image[sr][sc]
        if not image or color==newColor:
            return image
        self.R, self.C = len(image), len(image[0])
        self.dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        q=deque()
        image[sr][sc]=newColor
        q.append((sr,sc))
        while q:
            cur=q.popleft()
            for dir in self.dirs:
                r=cur[0]+dir[0]
                c=cur[1]+dir[1]
                if r>=0 and r<self.R and c>=0 and c<self.C and image[r][c]==color:
                    image[r][c]=newColor
                    q.append((r,c))
        return image    
        
#         #dfs
#         #O(m*n) for both
        
        
#         #original color
#         color = image[sr][sc]
#         #this acts as stopping condition if all colors are same as newColor in image
#         if not image or color == newColor: return image
#         self.R, self.C = len(image), len(image[0])
#         self.dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        
#         def dfs(r,c):
#             #check bounds and if color conditions for invalid entry
#             if r<0 or r>=self.R or c<0 or c>=self.C or image[r][c]!=color or image[r][c]==newColor:
#                 return
#             #all valid- change color
#             image[r][c]=newColor
#             #traverse to neighbours and call dfs again
#             for dir in self.dirs:
#                 r1=r+dir[0]
#                 c1=c+dir[1]
#                 dfs(r1,c1)      

#         dfs(sr, sc)
#         return image 

            