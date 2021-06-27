from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or len(image) == 0 or len(image[0]) == 0 or image[sr][sc]== newColor: return image
        color = image[sr][sc] #original color
        m = len(image)
        n = len(image[0])
        q = deque()
        q.append([sr,sc]) # pushing coordinates of the given element in queue
        image[sr][sc] = newColor #setting the element to new color
        dirs = [[1,0], [-1, 0], [0,1], [0,-1]]
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                r = curr[0]
                c = curr[1]
                for d in dirs: #iterating over the 4 neighbors of the element popped from queue
                    nr = r + d[0]
                    nc = c + d[1]
                    if nr >=0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == color:
                        q.append([nr,nc])
                        image[nr][nc] = newColor
        return image

#Time complexity is O(m*n)
#Space complexity is O(m*n)
#Approach used:BFS over all the levels and marking the first neighbor as newColor