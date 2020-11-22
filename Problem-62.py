
#leet code - Flood fill(733) - https://leetcode.com/problems/flood-fill/
# Time complexity -O(M*N)
#Space complexity-O(1) -(we ignore the recursion stack)
#approach -DFS approach using recursive stack. We are looking at all the four directions of image[r][c], if it is different color than the new color then we are changing it to new color.



class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        color=image[sr][sc]
        if color!=newColor:
            self.helper(image,sr,sc,color,newColor)
        return image
    
    
    
    def helper(self,image,r,c,color,newColor):
        
        #base case
        if (r<0  or r>=len(image) or c<0 or c>=len(image[0]) or image[r][c]!=color):
            return 
        image[r][c]=newColor
       
        dir=[(1,0),(0,1),(-1,0),(0,-1)]
        for (i,j) in dir:
            new_r=i+r
            new_c=j+c
            self.helper(image,new_r,new_c,color,newColor)
        
        
# BFS approach - Here we maintain the visited array. First we store (r,c) values into queue and then we change the image[r][c] to newcolor and change the visited[r][c] as True. Atlast we process it's neighbours

from collections import deque
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        if image[sr][sc]==newColor:
            return image
        color=image[sr][sc]
        queue=deque()
        visited=[[False for c in range(len(image[0]))] for r in range(len(image))]
        queue.append((sr,sc))
        visited[sr][sc]=True
        dir=[(1,0),(0,1),(-1,0),(0,-1)]
        while queue:
            curr=queue.popleft()
            image[curr[0]][curr[1]]=newColor
            for (x,y) in dir:
                new_r=curr[0]+x
                new_c=curr[1]+y
                if (0<=new_r<=len(image)-1 and 0<=new_c <=len(image[0])-1 and image[new_r][new_c]==color and visited[new_r][new_c]!=True):
                    queue.append((new_r,new_c))
                    visited[new_r][new_c]=True
        return image
                    
        
            