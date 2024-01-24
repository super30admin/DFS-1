'''

Time Complexity : O(mn)
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach:
Using BFS here. I start by adding all the indexes of 0's to the queue and then go on visiting all the unvisited nodes


'''

class Solution:
    def updateMatrix(self, image: List[List[int]]) -> List[List[int]]:

        dir = [(0,1),(1,0),(0,-1),(-1,0)]
        m = len(image)
        n = len(image[0])
        q = collections.deque()

        for i in range(len(image)):
            for j in range(len(image[0])):

                if image[i][j] == 1:
                    image[i][j] = -1

                else:
                    q.append(i)
                    q.append(j)

        while q:
            cr = q.popleft()
            cc = q.popleft()
            for k in dir:
                ni = cr + k[0]
                nj = cc + k[1]
                if 0 <= ni < m and 0 <= nj < n and image[ni][nj] == -1:
                    q.append(ni)
                    q.append(nj)
                    image[ni][nj] = image[cr][cc] + 1

        return image





