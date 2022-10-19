class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        cl=image[sr][sc]
        r=len(image)
        c=len(image[0])
        q=[[sr,sc]]
        dirs=[[0,-1],[1,0],[0,1],[-1,0]]
        if cl==color:
            return image
        image[sr][sc]=color
        while q:
            size=len(q)
            for x in range(size):
                curr=q.pop(0)
                for d in dirs:
                    nr=curr[0]+d[0]
                    nc=curr[1]+d[1]
                    if nr>=0 and nr<r and nc>=0 and nc<c and image[nr][nc]==cl:
                        q.append([nr,nc])
                        image[nr][nc]=color
                        
        return image
    