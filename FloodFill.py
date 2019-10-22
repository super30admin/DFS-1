#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 22 11:47:19 2019

@author: tanvirkaur
"""

#time complexity = O(n)
#space complexity = O(n)
#leet code acceptance = yes
# BFS approach used to visit all the neighbours and fill their values with the new color
class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """
        oldcolor = image[sr][sc]
        if oldcolor == newColor:
            return image
        image[sr][sc] = newColor
        q = [(sr,sc)]
        while q:
            r, c = q.pop(0)
            for nr,nc in self.neighbours(r,c,image):
                if image[nr][nc] == oldcolor:
                    image[nr][nc] = newColor
                    q.append((nr,nc))
        return image
            
            
            
    def neighbours(self,r,c,image):
        for nr,nc in ((r-1,c),(r+1,c),(r,c+1),(r,c-1)):
            if 0<=nr < len(image) and 0<=nc<len(image[0]):
                yield nr,nc