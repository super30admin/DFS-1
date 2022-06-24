# BFS
""""// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or image[sr][sc]==color:
            return image
        q=deque()
        m=len(image)
        n=len(image[0])
        d=[[0,1],[1,0],[0,-1],[-1,0]]
        start=image[sr][sc]
        image[sr][sc]=color
        q.append((sr,sc))

        while q:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                for k in d:
                    nr=curr[0]+k[0]
                    nc=curr[1]+k[1]
                    if nr>=0 and nc>=0 and nr<m and nc<n and image[nr][nc]==start:
                        image[nr][nc]=color
                        q.append((nr,nc))
        return image


# DFS
""""// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.d = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        self.start = image[sr][sc]
        self.m = len(image)
        self.n = len(image[0])
        image[sr][sc] = color
        self.helper(image, sr, sc, color)
        return image

    def helper(self, image, sr, sc, color):
        # base
        if sr == self.m or sc == self.n or sr < 0 or sc < 0:
            return

        # logic

        for i in self.d:
            nr = sr + i[0]
            nc = sc + i[1]
            if nr >= 0 and nc >= 0 and nr < self.m and nc < self.n and image[nr][nc] != color and image[nr][
                nc] == self.start:
                image[nr][nc] = color
                self.helper(image, nr, nc, color)






