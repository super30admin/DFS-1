# // Time Complexity :O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# you pop the current color at desired location given and add the locationindex to the queue. Loop until the queue is empty to find the four neighbouring nodes
# of current position and if they are within the bounds and if the color at the nehigbours are old color- then add them to queue and change clors to new color
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        m=len(image)
        n=len(image[0])
        if image[sr][sc]==color:
            return image
        old_color=image[sr][sc]
        q=[]
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        q.append([sr,sc])
        image[sr][sc]=color
        while(len(q)>0):
            curr=q.pop(0)
            for dir in dirs:
                nr=curr[0]+dir[0]
                nc=curr[1]+dir[1]
                if(nr>=0 and nc>=0 and nr<m and nc<n and image[nr][nc]==old_color):
                    q.append([nr,nc])
                    image[nr][nc]=color

        return image