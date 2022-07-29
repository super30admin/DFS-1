'''

## Problem 733: Flood fill

## Author: Neha Doiphode
## Date:   07-27-2022

## Description:
    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and color.
    You should perform a flood fill on the image starting from the pixel image[sr][sc].
    To perform a flood fill, consider the starting pixel,
    plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
    Replace the color of all of the aforementioned pixels with color.

    Return the modified image after performing the flood fill.

## Examples:
    Example 1:
        Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
        Output: [[2,2,2],[2,2,0],[2,0,1]]
        Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
                     all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
                     Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

    Example 2:
        Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
        Output: [[0,0,0],[0,0,0]]
        Explanation: The starting pixel is already colored 0, so no changes are made to the image.

 ## Constraints:
    m == image.length
    n == image[i].length
    1 <= m, n <= 50
    0 <= image[i][j], color < 216
    0 <= sr < m
    0 <= sc < n

## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

'''

from typing import List, Optional
from queue import Queue

def get_input():
    print("Enter the number of rows in the image: ", end = "")
    rows = int(input())
    print("Enter the number of columns in the image: ", end = "")
    columns = int(input())
    image = []
    for row in range(rows):
        l = []
        print(f"Row {row + 1}: ")
        for column in range(columns):
            inp = int(input())
            l.append(inp)
        image.append(l)

    print("Enter the cell co-ordinates(row <space> column) for the starting pixel: ", end = "")
    starting_pixel = input()
    starting_pixel = starting_pixel.split()
    sr = int(starting_pixel[0])
    sc = int(starting_pixel[1])

    print("Enter the color(integer) to be used for the flood fill: ", end = "")
    color = int(input())
    print()
    return image, sr, sc, color

class Solution:
    directions = []
    m = 0
    n = 0
    def floodFill_BFS(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        '''
        Time complexity: O(m * n), where m is number of rows and n is number of columns, and we might have to process every pixel.

        Space complexity: O(m * n), where m is number of rows and n is number of columns, space required to store cells in the queue.
        '''
        if image[sr][sc] == color:
            return image

        q = Queue()
        m = len(image)
        n = len(image[0])
        q.put([sr, sc])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        old_color = image[sr][sc]

        while not q.empty():
            pixel = q.get()
            image[pixel[0]][pixel[1]] = color
            for direct in dirs:
                nr = pixel[0] + direct[0]
                nc = pixel[1] + direct[1]

                if nr >= 0 and nr < m and nc >= 0 and nc < n and old_color == image[nr][nc]:
                    image[nr][nc] = color
                    q.put([nr, nc])

        image[sr][sc] = color

        return image

    def dfs(self, image: List[List[int]], row: int, col: int, old_color: int, color: int) -> None:
        # base
        if row < 0 or col < 0 or row == self.m or col == self.n or image[row][col] != old_color:
            return

        image[row][col] = color

        for direct in self.directions:
            nr = row + direct[0]
            nc = col + direct[1]
            self.dfs(image, nr, nc, old_color, color)


    def floodFill_DFS(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        '''
        Time complexity: O(m * n), where m is number of rows and n is number of columns, and we might have to process every pixel.

        Space complexity: O(m * n), where m is number of rows and n is number of columns, size of recursion call stack.
        '''
        if image[sr][sc] == color:
            return image

        self.m = len(image)
        self.n = len(image[0])
        old_color = image[sr][sc]
        self.directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        self.dfs(image, sr, sc, old_color, color)
        return image


# Driver code
solution = Solution()
image, sr, sc, color = get_input()
print(f"Input image: {image}")
print(f"Input starting pixel(row, column): [{sr}, {sc}]")
print(f"Input flood fill color: {color}")
print(f"Approach 1: Using BFS: Output flood filled image: {solution.floodFill_BFS(image, sr, sc, color)}")
print(f"Approach 2: Using DFS: Output flood filled image: {solution.floodFill_DFS(image, sr, sc, color)}")
