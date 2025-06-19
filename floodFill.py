# TC: O(mn)
# SC: O(mn)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        dirs=[(0,1), (1,0), (0,-1), (-1,0)]
        q=deque([])
        q.append((sr,sc))
        start_color=image[sr][sc]
        image[sr][sc]=color
        if color==start_color:
            return image
        while q:
            curr=q.popleft()
            cr=curr[0]
            cc=curr[1]
            for d in dirs:
                nr=cr+d[0]
                nc=cc+d[1]

                if nr>=0 and nc>=0 and nr<len(image) and nc<len(image[0]) and image[nr][nc]==start_color:
                    image[nr][nc]=color
                    q.append((nr,nc))
        
        return image

