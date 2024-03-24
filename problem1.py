#Time Complexity : O(m*n)
#Space Complexity : O(m*n)
#Any problem you faced while coding this : -

#The approach is a standard level-order traversal using a queue. Here, we are maintaining a directions list in order to check for neighboring colors for every filled cell.


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) == 0:
            return None

        q = collections.deque()
        m = len(image)
        n = len(image[0])
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]

        if image[sr][sc] == color:
            return image

        q.append([sr,sc])
        orig = image[sr][sc]
        image[sr][sc] = color

        while len(q) != 0:
            curr = q.popleft()
            cr = curr[0]
            cc = curr[1]
            for d in dirs:
                nr = d[0] + cr
                nc = d[1] + cc
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == orig: 
                    q.append([nr,nc])
                    image[nr][nc] = color
                        
                # print(image)

        return image