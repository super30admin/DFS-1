"""
To solve this using BFS - 
We keep on adding the traversed node to a queue and we check all 4 of its nighbors for the given color. Else process the next child.
If found, we change and remove that node from the queue
While storing the positions in the queue, we add x and y coordinate as two different elements inside the queue. and we pop 2 elements at a time to 
get the position to process.

TC = O(mn) - as we will visit all the nodes worst case
SC = O(mn) - as we may have to store the positions of all the nodes 

"""

#BFS
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None or image[sr][sc]==color :
            return image
        
        q = deque()
        m = len(image)
        n = len(image[0])
        
        oldColor = image[sr][sc]
        dirs = [[-1,0],[0,1],[1,0],[0,-1]]
        q.append(sr)
        q.append(sc)
        image[sr][sc]= color
        
        while q :
            cr = q.popleft()
            cc = q.popleft()
            for position in dirs:
                nr = cr+position[0]
                nc = cc+position[1]
                
                if nr>=0 and nc>=0 and nr<m and nc<n and image[nr][nc]== oldColor:
                    q.append(nr)
                    q.append(nc)
                    image[nr][nc]= color
                    
        return image
                    
"""
To solve using DFS - 
We perform DFS on all the 4 neighbors and recursively call dfs on the nodes to be processed.

TC = O(mn)
SC = O(mn)

"""          
#DFS
class Solution:
    dirs = [[1,0],[0,1],[0,-1],[-1,0]]
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # base case
        if not image or len(image)  == 0:
            return list()
        
        # if image color at given location is same as expected color, stop there
        # one such case is [[0,0,0],[0,0,0]] 0 0 0
        if image[sr][sc] == color: return image
        # logic - use DFS
        self.dfs(image, sr, sc, color, image[sr][sc])
        return image
        
    def dfs(self, image, sr, sc, color, origColor):
        # base case
        if sr < 0 or sc < 0 or sr >= len(image) or sc >= len(image[0]) or image[sr][sc] != origColor: return
        
        # logic
        image[sr][sc] = color
        for d in self.dirs:
            nr = sr + d[0]
            nc = sc + d[1]
            self.dfs(image, nr, nc, color, origColor)