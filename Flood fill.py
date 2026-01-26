class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        old_color=image[sr][sc]
        dirs=[[-1,0],[0,1],[1,0],[0,-1]]

        if image[sr][sc]==color:
            return image
        else:
            image[sr][sc]=color
        queue=[]
        queue.append(sr)
        queue.append(sc)

        while queue:
            cr=queue.pop(0)
            cc=queue.pop(0)
            for dir in dirs:
                nr=cr+dir[0]
                nc=cc+dir[1]
                if nr>=0 and nc>=0 and nr<len(image) and nc<len(image[0]) and image[nr][nc]==old_color:
                    queue.append(nr)
                    queue.append(nc)
                    image[nr][nc]=color
        return image