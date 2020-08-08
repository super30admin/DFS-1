'''
PROBLEM 1

TIME COMPLEXITY: O(m*n)
SPACE COMPLEXITY: O(m*n)

- return if newColor is same as the current node's initial color
- starting with the current node, change the color to newColor
- apply DFS on all neighbours that have same color as initial starting node


'''

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        

        #USING DFS
        if len(image)==0 or image[sr][sc]==newColor:
            return image
        color=image[sr][sc]
        self.dirs=[[0,-1], [1,0], [0,1], [-1,0]]
        self.dfs(image, sr, sc, newColor, color)
        return image
    
    def dfs(self, image: List[List[int]], r: int, c: int, newColor: int, color):
        if image[r][c]!=color:
            return
        
        image[r][c]=newColor
        for direction in self.dirs:
            row= r+direction[0]
            col= c+direction[1]
            if row>=0 and row<len(image) and col>=0 and col<len(image[0]):
                self.dfs(image, row, col, newColor, color)
        
        #USING BFS
        if len(image)==0 or image[sr][sc]==newColor:
            return image
        
        queue=[]
        color=image[sr][sc]
        image[sr][sc]=newColor
        queue.append([sr,sc])
        
        dirs=[[0,-1], [1,0], [0,1], [-1,0]]
        while(len(queue)!=0):
            curr= queue.pop(0)
            
            for direction in dirs:
                row= curr[0]+direction[0]
                col= curr[1]+direction[1]
                
                if row>=0 and row<len(image) and col>=0 and col<len(image[0]) and image[row][col]==color:
                    image[row][col]=newColor
                    queue.append([row,col])
        
        return image


'''
PROBLEM 1

TIME COMPLEXITY: O(m*n)
SPACE COMPLEXITY: O(m*n)

- add the nodes with value 0 to queue and if a node has value 1 , change it to -1
- check all 4 neighbours of all the nodes using size variable, if they are -1, then update the value to dist variable and add it to the queue
- return the matrix


'''

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        queue=[]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==0:
                    queue.append([i,j])
                else:
                    matrix[i][j]=-1
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        dist=1
        while len(queue)!=0:
            size=len(queue)
            for i in range(size):
                curr=queue.pop(0)

                for di in dirs:
                    row= curr[0]+di[0]
                    col= curr[1]+di[1]

                    if row>=0 and row<len(matrix) and col>=0 and col<len(matrix[0]) and matrix[row][col]==-1:
                        matrix[row][col]=dist
                        queue.append([row, col])
            dist+=1
        return matrix
            