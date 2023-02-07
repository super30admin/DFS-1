# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution:

    # BFS Solution
    # take 1 queue
    # append the source node to it
    # store the original color of the source node
    # change the source node's color with new color
    # iterate over the queue
    # pop the source node from that queue
    # iterate over the all the neighbours of the source node
    # if any neighbour has same color as original color of the source node, then change it's color with new color
    # append that node to queue
    # now process these appended node, same as source node
    # return image
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or image[sr][sc] == color:
            return image
        m = len(image)
        n = len(image[0])
        direction = [[0,1],[0,-1],[1,0],[-1,0]]
        queue = deque()
        queue.append(sr)
        queue.append(sc)
        originalColor = image[sr][sc]
        image[sr][sc] = color
        while queue:
            cr = queue.popleft()
            cc = queue.popleft()
            for dire in  direction:
                nr = cr + dire[0]
                nc = cc + dire[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == originalColor:
                    queue.append(nr)
                    queue.append(nc)
                    image[nr][nc] = color
            
        return image


    # DFS Solution
    direction = [[0,1],[0,-1],[1,0],[-1,0]]
    originalColor = 1
    def floodFill2(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or image[sr][sc] == color:
            return image
        m = len(image)
        n = len(image[0])
        self.originalColor = image[sr][sc]
        self.dfs(image,sr,sc,m,n,color)
        return image
    
    def dfs(self,image,sr,sc,m,n,color):
        if sr < 0 or sc < 0 or sr == m or sc == n or image[sr][sc] != self.originalColor:
            return 
        
        image[sr][sc] = color
        for dire in  self.direction:
                nr = sr + dire[0]
                nc = sc + dire[1]
                self.dfs(image,nr,nc,m,n,color)

        