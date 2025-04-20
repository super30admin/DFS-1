'''
Time complexity --> O(n*m)
Space Complexity --> O(n*m)

1. Same as rotten orange challenge
2. The difference is you dont need to maintain the level traversal.
3. And also take care of edge case.
'''

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:


        ## Same as rotten orange.

        directions = [[0,1],[0,-1],[-1,0],[1,0]]

        queue = deque()

        old_color = image[sr][sc]

        image[sr][sc]=color

        queue.append([sr,sc])



        if old_color == color:
            return image

        while queue:
            cr,cc= queue.popleft()

            for dr,dc in directions:

                if( (cr+dr in range(len(image))) and (cc+dc in range(len(image[0]))) ):
                    rr=cr+dr
                    rc=cc+dc

                    if image[rr][rc]==old_color:
                        image[rr][rc]= color
                        queue.append([rr,rc])


        return image
