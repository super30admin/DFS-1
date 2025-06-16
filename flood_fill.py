from collections import deque

## BFS Solution - Uses Queue(FIFO) + iterative(uses a lo0p)
class BFSSolution:
    def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:
        """
        TC: O(m*n)
        AS: O(m*n)
        """
        # calculate number of rows and columns of the image
        rows = len(image)
        columns = len(image[0])

        # we have the coordinates of the original color
        originalColor = image[sr][sc]

        # check if the originalColor is already the desired color
        if originalColor == color:
            return image
        
        queue = deque()
        queue.append((sr, sc))
        # as soon as we add to the queue, we will update to the desired color to avoid duplicacy
        if image[sr][sc] == originalColor:
            image[sr][sc] = color

        while queue:
            # take out what is added in the queue
            r, c = queue.popleft()

            ## update the neigbours
            # neighbors
                    # UP, DOWN, LEFT, RIGHT from a pixel of the image
            dirs = [(-1,0), (1,0), (0,-1), (0,1)]
            for dr, dc in dirs:
                nr = r + dr
                nc = c + dc

                # check bounds & if the color is originalcolor:
                if 0 <= nr < rows and 0 <= nc < columns and image[nr][nc] == originalColor:
                    queue.append((nr, nc))
                    # as soon as we add to the queue, we will update to the desired color to avoid duplicacy
                    if image[nr][nc] == originalColor:
                        image[nr][nc] = color

        return image


## DFS Solution - can be recursive (uses a STACK (LIFO))
class DFSSolution:
    def floodFill(self, image: list[list[int]], sr: int, sc: int, color: int) -> list[list[int]]:
        """
        TC: O(m*n)
        AS: O(m*n)
        """
        originalColor = image[sr][sc]

        if originalColor == color:
            return image
                
        self.dfs(image, sr, sc, color, originalColor)
        return image
        

    def dfs(self, image, sr, sc, color, originalColor):

        rows = len(image)
        columns = len(image[0])
        dirs =[(0,-1), (0,1), (-1,0), (1,0)]

        ## base condition
        # out of bounds; not the original color >> return
        if sr < 0  or sr >= rows or sc < 0 or sc >= columns or image[sr][sc] != originalColor:
            return
         
        ## logic
        image[sr][sc] = color
        for dr, dc in dirs:
            nr = sr + dr
            nc = sc + dc
            self.dfs(image, nr, nc, color, originalColor)
