'''
time complexity: O(n)
n is number of pixels in image
space complexity: O(1)
'''
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if(image==None or image[sr][sc]==newColor): return image
        
        dirs = [(1,0),(0,1),(0,-1),(-1,0)]
        lr = len(image)
        lc = len(image[0])
        rq = deque([])
        cq = deque([])
        startingColor = image[sr][sc]
        rq.append(sr)
        cq.append(sc)
        
        while(len(rq)!=0):
            currR = rq.popleft()
            currC = cq.popleft()
            image[currR][currC] = newColor
            for dr,dc in dirs:
                nr = currR + dr
                nc = currC + dc
                if(nr>=0 and nc>=0 and nr<lr and nc<lc and image[nr][nc]==startingColor):
                    rq.append(nr)
                    cq.append(nc)
        return image
                    