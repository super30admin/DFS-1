'''
Solution 1: BFS
Maintain a queue, look in 4 directions, if any neighbor has original color as source, 
then update it to new color and add it to queue. 
Time complexity: O(m*n) 
Space complexity: O(m*n) 
'''
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original_color = image[sr][sc]

        if original_color==color: # no change to be done. 
            return image
        
        rows = len(image)
        cols = len(image[0])

        bfs_queue = deque()
        bfs_queue.append([sr,sc])
        image[sr][sc] = color # update to new color

        directions = [[0,-1],[-1,0],[0,1],[1,0]] # left, top, right, bottom

        while len(bfs_queue)!=0:
            row,col = bfs_queue.popleft()
            for direction in directions:
                neigh_r,neigh_c = row+direction[0], col+direction[1]
                if 0<=neigh_r<rows and 0<=neigh_c<cols and image[neigh_r][neigh_c]==original_color:
                    bfs_queue.append([neigh_r,neigh_c])
                    image[neigh_r][neigh_c] = color
        
        return image


'''
Solution 1: DFS
Recursive stack, look in 4 directions, if any neighbor has original color as source, 
then update it to new color and call recursive function on it. 
Time complexity: O(m*n) 
Space complexity: O(m*n)
'''
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original_color = image[sr][sc]

        if original_color==color: # no change to be done. 
            return image
        
        rows = len(image)
        cols = len(image[0])

        directions = [[0,-1],[-1,0],[0,1],[1,0]] # left, top, right, bottom

        self.helper(image,sr,sc,color,original_color,directions)

        return image

    def helper(self,image,row,col,color,original_color,directions):
        # base : Boundar check + if cell does not have the color as source
        if row<0 or row>=len(image) or col<0 or col>=len(image[0]) or image[row][col]!=original_color:
            return

        # logic
        image[row][col] = color # update to new color
        for direction in directions:
            self.helper(image,row+direction[0],col+direction[1],color,original_color,directions)

