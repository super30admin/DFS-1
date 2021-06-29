#Time complexity for put and get: O(n)
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : YES, Time limit exceeded

class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        # this gives TLE with both DFS and BFS for the following test case
#[[0,0,0],[0,1,1]]
# 1
# 1
# 1
        #bfs
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        # save old color to check later if mat cell of same color or not
        oldcolor = image[sr][sc]
        q = deque()
        q.append((sr,sc))
        image[sr][sc] = newColor
        #bfs and mark all neighbours using dirs array with the new color
        # mark only those cells with the new color which have old color
        while q:
            node = q.popleft()
            for d in dirs:
                nr = node[0]+d[0]
                nc = node[1]+d[1]
                if nr>=0 and nc>=0 and nr<len(image) and nc < len(image[0]) and image[nr][nc]==oldcolor:
                    image[nr][nc] = newColor
                    q.append((nr,nc))
        return image
        #dfs
        # self.dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        # self.oldcolor = image[sr][sc]
        # def dfs(image,r,c,newColor):
        #     #base
        #     if r<0 or c<0 or r>=len(image) or c >= len(image[0]) or image[r][c]!=self.oldcolor:
        #         return
        #     #logic
        #     image[r][c] = newColor
        #     for d in self.dirs:
        #         nr = d[0]+r
        #         nc = d[1]+c
        #         dfs(image,nr,nc,newColor)
        # dfs(image,sr,sc,newColor)
        # return image