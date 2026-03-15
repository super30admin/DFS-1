#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 733: Flood Fill
    Link: https://leetcode.com/problems/flood-fill/

    Problem:
    Given an image represented as a 2D integer grid, a starting pixel (sr, sc),
    and a new color, perform a flood fill starting from (sr, sc).
    All pixels connected 4-directionally with the same original color get recolored.
    Return the modified image.

    Approach:
    BFS from (sr, sc). Record the original color before filling. To avoid infinite
    loops, early-exit if the new color equals the original color (no visited set needed).
    Mark each cell with the new color before enqueuing to prevent re-processing.

    1️⃣ Early exit: if originalColor == color, return image unchanged.
    2️⃣ Set image[sr][sc] = color and seed queue.
    3️⃣ For each dequeued cell, check 4 neighbors; if neighbor matches originalColor,
       recolor and enqueue.

    // Time Complexity : O(m * n)
        Every cell is visited at most once.
    // Space Complexity : O(m * n)
        Queue can hold all cells in the worst case.

"""

from collections import deque
from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]

        def bfs(image, sr, sc, color):
            originalColor = image[sr][sc]

            # Early exit: if color unchanged, returning immediately avoids
            # infinite loops without needing a visited set.
            if originalColor == color:
                return image

            image[sr][sc] = color
            queue = deque()
            queue.append([sr, sc])

            while queue:
                x, y = queue.popleft()
                for dx, dy in directions:
                    X = x + dx
                    Y = y + dy
                    if 0 <= X < len(image) and 0 <= Y < len(image[0]):
                        if image[X][Y] == originalColor:
                            image[X][Y] = color
                            queue.append([X, Y])

            return image

        return bfs(image, sr, sc, color)

    '''
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # BFS with explicit visited set instead of early-exit trick.
        def bfs(image, sr, sc, color):
            originalcolor = image[sr][sc]
            queue = []
            visited = set()
            queue.append((sr, sc))
            visited.add((sr, sc))

            directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]

            while queue:
                r, c = queue.pop(0)
                image[r][c] = color

                for dr, dc in directions:
                    x = r + dr
                    y = c + dc
                    if x >= 0 and x < len(image) and y >= 0 and y < len(image[0]) and (x, y) not in visited and image[x][y] == originalcolor:
                        queue.append((x, y))
                        visited.add((x, y))

            return image

        return bfs(image, sr, sc, color)
    '''
