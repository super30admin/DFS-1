class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        """
        TC : O(N * M)
        SC : O(1)
        apply BFS and change the colore of all the neighbour nodes having same old color
        """
        n = len(image)
        if n==0: return image
        m = len(image[0])
        if m == 0: return image

        old_color = image[sr][sc]
        if newColor == old_color: return image
        q = [(sr,sc)]
        image[sr][sc] = newColor
        while q:
            x,y = q.pop()
            d = [[0,1],[0,-1],[1,0],[-1,0]]
            for dx,dy in d:
                if x+dx>=0 and y+dy >=0 and x+dx<n and y+dy<m and image[x+dx][y+dy] == old_color:
                    image[x+dx][y+dy] = newColor
                    q.append((x+dx,y+dy))
        return image
        