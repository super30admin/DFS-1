# Problem 1
## Time Complexity :
O(m*n)

## Space Complexity :
O(m*n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 1: BFS.
        import queue
        class Solution:
            def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
                if(image==None or len(image)==0 or image[sr][sc]==newColor):
                    return image
                m,n=len(image),len(image[0])
                color=image[sr][sc]
                q=queue.Queue()
                image[sr][sc]=newColor
                q.put([sr,sc])
                dirs=[[0,1],[1,0],[-1,0],[0,-1]]
                while not q.empty():
                    curr=[]
                    curr=q.get()
                    for dir in dirs:
                        i=curr[0]+dir[0]
                        j=curr[1]+dir[1]
                        if(i>=0 and i<m and j>=0 and j<n and image[i][j]==color):
                            image[i][j]=newColor
                            q.put([i,j])
                return image

# Problem 1
## Time Complexity :
O(m*n)

## Space Complexity :
O(m*n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 2: DFS.
        class Solution:
            def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
                def dfs(image: List[List[int]], r, c, newColor):
                    if(r<0 or r>=len(image) or c<0 or c>=len(image[0]) or image[r][c]!=color):
                        return image
                    image[r][c]=newColor
                    for dir in dirs:
                        i=dir[0]+r
                        j=dir[1]+c
                        dfs(image,i,j,newColor)
                color=0
                dirs=[[0,1],[1,0],[-1,0],[0,-1]]    
                if(image==None or len(image)==0 or image[sr][sc]==newColor):
                    return image
                m,n=len(image),len(image[0])
                color=image[sr][sc]
                dfs(image,sr,sc,newColor)
                return image

# Problem 2
## Time Complexity :
O(m*n)

## Space Complexity :
O(m*n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:

        from collections import deque

        class Solution:
            def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
                h, w = len(matrix), len(matrix[0])
                q = deque()
                for i in range(h):
                    for j in range(w):
                        if matrix[i][j] == 0:
                            q += [(i, j)]
                        else:
                            matrix[i][j] = -1
                while q:
                    i, j = q.pop()
                    for ai, aj in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                        if 0 <= ai < h and 0 <= aj < w and matrix[ai][aj] < 0:
                            matrix[ai][aj] = matrix[i][j] + 1
                            q.appendleft((ai, aj))

                return matrix
