"""
Problem:
https://leetcode.com/problems/flood-fill/

Approach: BFS Solution

1. change the cell corresponding to sr,sc and add it to the queue
2. while queue is not empty , take out the elemnts from queue, change the color of all the neighbours to newColor and add those neighbours to the que

"""

# Time Complexity : O(m*n) where m is the no of rows and n is no of columns
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    newColor = None
    oldColor = None
     
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image==None or len(image)==0 or image[sr][sc]==newColor:
            return image
        
        self.oldColor = image[sr][sc]
        self.newColor = newColor
        que = deque()
        
        #change color and add to the queue
        image[sr][sc] =  self.newColor
        que.append((sr,sc))
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        
        while(que):
            cur = que.popleft()
            for direction in directions:
                r = cur[0]+direction[0]
                c=  cur[1]+direction[1]
                if(r >=0 and r<=(len(image)-1) and c>=0 and c<=(len(image[0])-1) and image[r][c]==self.oldColor):
                    image[r][c]= self.newColor
                    que.append((r,c))
        
        return image


"""
Approach: DFS Solution
"""

# Time Complexity : O(m*n) where m is the no of rows and n is no of columns
# Space Complexity : O(m*n) where m is the no of rows and n is no of columns
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

class Solution:
    newColor = None
    oldColor = None
    
    def dfs(self,image,sr,sc):
        #base case
        if(sr<0 or sr>(len(image)-1) or sc<0 or sc> (len(image[0])-1) or image[sr][sc]!=self.oldColor):
            return
        
        
        #logic
        image[sr][sc]=self.newColor
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        for direction in directions:
            r = sr+direction[0]
            c=  sc+direction[1]
            self.dfs(image,r,c)
        
    
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image==None or len(image)==0 or image[sr][sc]==newColor:
            return image
        
        self.oldColor = image[sr][sc]
        self.newColor = newColor
        
        self.dfs(image,sr,sc)
        return image