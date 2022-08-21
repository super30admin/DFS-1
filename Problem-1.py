# 733. Flood Fill

'''
Leetcode all test cases passed: Yes
Solution:
    def floodFill(self, image, sr, sc, newColor):
        m is no of rows in image
        n is no of columns in image
        Time Complexity: O(m * n) 
        Space Complexity: O(m * n)
'''
class Solution:
    def floodFill(self, image, sr, sc, newColor):
        direction_x = [0,0,-1,1]
        direction_y = [-1,1,0,0]
        oldColor = image[sr][sc]
        queue = collections.deque([[sr,sc]])
        while queue:
            x,y = queue.popleft()

            if x < 0 or x >= len(image) or y < 0 or y >= len(image[0]) or image[x][y] == newColor or image[x][y] != oldColor:
                continue
            image[x][y] = newColor
            for x_off,y_off in zip(direction_x,direction_y):

                queue.append([x + x_off,y + y_off])
        return image
