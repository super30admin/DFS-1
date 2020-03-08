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
