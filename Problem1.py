T.C: O(m*n)
S.C: min(m,n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image:
            return
        old = image[sr][sc]
        if old==color:
            return image
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        q = []
        m = len(image)
        n = len(image[0])
        q.append([sr,sc])
        image[sr][sc] = color
        while q:
            i,j =q.pop(0)
            for x,y in dirs:
                x += i
                y += j
                if x>=0 and y >=0 and x<m and y < n and image[x][y] == old:
                    q.append([x,y])
                    image[x][y] = color
        return image
