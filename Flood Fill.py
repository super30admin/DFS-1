# Time Complexity:- O(m*n)
# Space Complexity:- O(m*n)
# Approach:- BFS on the start pixel and check the neighbouring pixels and add it to the queue. After adding it to the queue change the pixelvalue to the newColour.
from typing import  List
import collections


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        existingcolour=image[sr][sc]
        # missed this condition. The existing colour can be equal to the new colour
        if existingcolour==newColor:
            return image
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        q=collections.deque([])
        q.append([sr,sc])
        while(q):
            element=q.popleft()
            image[element[0]][element[1]]=newColor
            for i,j in dirs:
                k=i+element[0]
                l=j+element[1]
                if 0<=k<len(image) and 0<=l<len(image[0]) and image[k][l]==existingcolour:
                    image[k][l]=newColor
                    q.append([k,l])
        return image
