#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 22 12:17:11 2019

@author: tanvirkaur
"""

class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        we will put all the 0's in the queue and pop one by one and if the neighbors are visited i.e  they are already in queue their values remain same else if the neighbors are not visited their value is the previous pop value+1 
        time complexity = O(n)
        Space complexity = O(n)
        Leet Code acceptance = yes
        """
        visited = set()
        q = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.append((i,j))
                    visited.add((i,j))
        while q:
            r,c = q.pop(0)
            for nr,nc in self.neighbours(r,c,matrix):
                if (nr,nc) not in visited:
                    matrix[nr][nc] = matrix[r][c] + 1
                    visited.add((nr,nc))
                    q.append((nr,nc))
        return matrix
                
    def neighbours(self,r,c,matrix):
        for nr,nc in ((r-1,c),(r+1,c),(r,c+1),(r,c-1)):
            if 0<=nr < len(matrix) and 0<=nc<len(matrix[0]):
                yield nr,nc