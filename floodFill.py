# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class solution:
## in bfs we try to add all those cells in the queue which are the same as the original cell color. and while 
## we process them we chnage thier color to the new color to avoid duplicate traversal.
    def bfs(self, image, sr, sc, color):

        queue = collections.deque()
        temp_color = image[sr][sc]
        if temp_color == color:
            return image
        queue.append([sr,sc])

        while queue:
            qsize = len(queue)

            for i in range(qsize):
                curr_r, curr_c = queue.popleft()
                image[curr_r][curr_c] = color
                dir = [[1,0],[-1,0],[0,1],[0,-1]]
                for d in dir:
                    new_r = curr_r +d[0]
                    new_c = curr_c +d[1]
                    
                    if new_r >= 0 and new_r < len(image) and new_c>=0 and new_c<len(image[0]):
                        if image[new_r][new_c] == temp_color:
                            queue.append([new_r,new_c])
        return image
## in dfs we recrusively start from the inital cell and have the same condition that if the next cell is not that of original color we return 
## else we give that a new color and do dfs from there.
    def dfs(self, image, sr,sc, color):
        self.temp_color = image[sr][sc]
        if self.temp_color == color:
            return image
        self.helper(image, sr, sc, color)
        return image

    def helper(self, image, row, col, color):

        ## base
        if row <0 or col <0  or row>=len(image) or col>=len(image[0]) or image[row][col] != self.temp_color:
            return
        ##logic
        image[row][col] = color
        direction = [[-1,0], [1,0], [0,1], [0,-1]]

        for dir in direction:
            new_r = row+dir[0]
            new_c = col+dir[1]
            self.helper(image, new_r, new_c, color)
                        
