# Problem1 (https://leetcode.com/problems/flood-fill/)



# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None:
            return image
        dirs = [[-1,0],[0,1],[1,0],[0,-1]] # U,R,D,L
        q = deque()
        m = len(image)
        n = len(image[0])
        original_color = image[sr][sc]
        if (original_color == color):
            return image
        image[sr][sc] = color
        q.append(sr)
        q.append(sc)

        while q:
            #len_q = len(q)
            cr = q.popleft()
            cc = q.popleft()
            for d in dirs:
                nr = cr + d[0]
                nc = cc + d[1]
            
                if (nr >= 0 and nr <m and nc >= 0 and nc < n and image[nr][nc] == original_color):
                    image[nr][nc] = color
                    q.append(nr)
                    q.append(nc)
        
        return image
    

# DFS

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None:
            return image
        self.dirs = [[-1,0],[0,1],[1,0],[0,-1]] # U,R,D,L
        m = len(image)
        n = len(image[0])
        self.original_color = image[sr][sc]
        if (self.original_color == color):
            return image

        self.dfs(image,sr,sc,color, self.original_color, self.dirs,m,n)
        return image

    def dfs(self,image,sr,sc,color, original_color, dirs,m,n):

        if (sr < 0 or sr == m or sc < 0 or sc == n or image[sr][sc] != self.original_color):
            return

        image[sr][sc] = color
        for d in self.dirs:
            nr = sr + d[0]
            nc = sc + d[1]
            self.dfs(image,nr,nc,color, self.original_color, self.dirs,m,n)
    
