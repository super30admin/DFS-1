# Created by Aashish Adhikari at 6:07 PM 1/26/2021

'''
Time Complexity:
O(m . n)

Space Complexity:
O(h) where h is the height of the recursive stack. In the worst case, h = m . n Hence, O( m . n)
'''


class Solution(object):




    def dfs(self, image, sr, sc, newColor, dirs, old_color):


        if sr >= 0 and sr < len(image) and sc >= 0 and sc < len(image[0]) and image[sr][sc] == old_color and image[sr][sc] != newColor:

            # Notice the check image[sr][sc] != newColor which is not intuitive at first.

            image[sr][sc] = newColor


            # recurse over all the children
            for dir in dirs:
                row = sr + dir[0]
                col = sc + dir[1]

                self.dfs(image, row, col, newColor, dirs, old_color)


    def floodFill(self, image, sr, sc, newColor):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """


        if len(image) == 0:
            return image


        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        starting_pixel = image[sr][sc]
        self.dfs(image, sr, sc, newColor, dirs, starting_pixel)

        return image


        '''
        This check image[sr][sc] != newColor is required to address the cases where the old color and the new color are the same. We do not want to go into infinite loops in such cases.
        
       
        Test case which illustrates this point --> 
        [[0,0,0],[0,1,1]] sr = 1, sc = 1, newColor = 1. Here color equals newColor so it breaks our code. That is why this check is required.
        
        '''