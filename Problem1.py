'''

Time Complexity : O(mn)
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

In DFS, we can recursively change the color of all elements accroding to the cases and in BFS, we add the neighbouring elements to a queue
and change the colors accordingly

'''

#DFS approach

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        q = collections.deque()
        dir = [(0,1),(1,0),(-1,0),(0,-1)]
        m = len(image)
        n = len(image[0])

        def dfs(image,old,color,sr,sc):
            image[sr][sc] = color

            for i in dir:
                if 0 <= sr + i[0] < m and 0 <= sc + i[1] < n and image[sr + i[0]][sc + i[1]] == old:
                    dfs(image,old,color,sr + i[0],sc + i[1])

        if image[sr][sc] != color:
            old = image[sr][sc]
            dfs(image,old,color,sr,sc)

        return image

#BFS Approach
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        q = collections.deque()
        dir = [(0,1),(1,0),(-1,0),(0,-1)]
        m = len(image)
        n = len(image[0])

        if image[sr][sc] != color:
            old = image[sr][sc]
            image[sr][sc] = color
            q.append(sr)
            q.append(sc)

        while q:
            length = len(q)
            cr = q.popleft()
            cc = q.popleft()

            for i in range(length):
                for j in dir:
                    if 0 <= cr+j[0] < m and 0 <= cc+j[1] < n and image[cr+j[0]][cc+j[1]] == old:
                        image[cr+j[0]][cc+j[1]] = color
                        q.append(cr+j[0])
                        q.append(cc+j[1])


        return image