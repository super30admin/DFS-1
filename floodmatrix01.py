from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image or image[sr][sc]==newColor:
            return image
        deq=deque()
        deq.append((sr,sc))
        temp=image[sr][sc]
        #visited=set()
        #visited.add((sr,sc))
        image[sr][sc]=newColor
        dir1=[[0,1],[0,-1],[1,0],[-1,0]]
        row=len(image)
        col=len(image[0])
        while deq:
                updaterow,updatecol=deq.popleft()
                #visited.add((updaterow,updatecol))
                for neigh in dir1:
                    newr=updaterow+neigh[0]
                    newc=updatecol+neigh[1]
                    if newr>=0 and newr<row and newc>=0 and newc<col and image[newr][newc]==temp:
                        deq.append((newr,newc))
                        #visited.add((newr,newc))
                        image[newr][newc]=newColor
        return image
                            