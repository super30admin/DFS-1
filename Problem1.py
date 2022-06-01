#BFS

#Time Complexity : O(M*N)
#Space Complexity : O(M*N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        queue = [[sr,sc]]
        color = image[sr][sc]
        if color == newColor:
            return image
        dirr = [[1,0],[0,1],[-1,0],[0,-1]]
        row = len(image)
        col = len(image[0])
        image[sr][sc] = newColor
        while queue:
            node = queue.pop()
            for i in dirr:
                r = node[0] + i[0]
                c = node[1] + i[1]
                if r >=0 and c>=0 and r<row and c<col and image[r][c] == color:
                    image[r][c] = newColor
                    queue.append([r,c])
                    
        return image


#DFS

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image == None or image[sr][sc] == newColor:
            return image
        dirr = [[1,0],[0,1],[-1,0],[0,-1]]
        row = len(image)
        col = len(image[0])
        color = image[sr][sc]
        self.dfs(image,sr,sc,newColor,color,dirr,row,col)
        return image
        
    def dfs(self,image,sr,sc,newColor,color,dirr,row,col):
        #base
        if sr < 0 or sc < 0 or sr >= row or sc >= col or image[sr][sc] != color:
            return
        #logic
        image[sr][sc] = newColor
        for i in dirr:
            r = i[0] + sr
            c = i[1] + sc
            self.dfs(image,r,c,newColor,color,dirr,row,col)
                
                