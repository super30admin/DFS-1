#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 542: 01 Matrix
    Link: https://leetcode.com/problems/01-matrix/

    Problem:
    Given an m x n binary matrix mat, return the distance of the nearest 0 for
    each cell. The distance between two adjacent cells is 1.

    Approach:
    Multi-source BFS from all 0-cells simultaneously. Seed the queue with every
    0-cell (distance = 0) and use a visited set to avoid reprocessing. For each
    dequeued cell, propagate distance to unvisited neighbors as mat[neighbor] = mat[current] + 1.

    1️⃣ Scan grid: enqueue all 0-cells and mark them visited.
    2️⃣ BFS: for each cell dequeued, check 4 neighbors.
    3️⃣ If neighbor is unvisited, set its distance = current distance + 1, enqueue, mark visited.
    4️⃣ Return the modified mat.

    // Time Complexity : O(m * n)
        Every cell is visited at most once.
    // Space Complexity : O(m * n)
        Queue and visited set each hold at most m * n entries.

"""

from typing import List


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        r = len(mat)
        c = len(mat[0])

        directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]

        queue = []
        visited = set()

        for i in range(r):
            for j in range(c):
                if mat[i][j] == 0:
                    queue.append((i, j))
                    visited.add((i, j))

        while queue:
            x, y = queue.pop(0)

            for dr, dc in directions:
                rx = x + dr
                ry = y + dc

                if 0 <= rx < r and 0 <= ry < c and (rx, ry) not in visited:
                    queue.append((rx, ry))
                    visited.add((rx, ry))
                    mat[rx][ry] = mat[x][y] + 1

        return mat
