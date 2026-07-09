## Problem1 (https://leetcode.com/problems/flood-fill/)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        # ==========================================
        # BFS Solution
        # Time Complexity: O(N) where N is the total number of pixels in the image (Rows * Cols). 
        #                  Each pixel is pushed and popped from the queue at most once.
        # Space Complexity: O(N) in the worst case (e.g., a fully connected grid of the same color) 
        #                   where the queue might store a large fraction of the pixels.
        # 
        # Logic:
        # 1. Check if the start pixel is already the target color to prevent infinite loops.
        # 2. Use a queue (collections.deque) to keep track of the pixels to visit, starting with (sr, sc).
        # 3. Change the color of the current pixel before entering the main loop.
        # 4. Dequeue a pixel and check its 4 directional neighbors. 
        # 5. If a neighbor is within bounds and matches the original color, change its color immediately 
        #    and enqueue it to process its neighbors later.
        # ==========================================
        
        # rows = len(image)
        # cols = len(image[0])
        # if image[sr][sc] == color:
        #     return image
        #
        # directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        # q = collections.deque()
        # oldColor = image[sr][sc]
        # q.append(sr)
        # q.append(sc)
        # image[sr][sc] = color
        # while q:
        #     r = q.popleft()
        #     c = q.popleft()
        #     for dr, dc in directions:
        #         nr, nc = r + dr, c + dc
        #         if nr >= 0 and nc >= 0 and nr < rows and nc < cols and image[nr][nc] == oldColor:
        #             image[nr][nc] = color
        #             q.append(nr)
        #             q.append(nc)
        #
        # return image


        # ==========================================
        # DFS Solution
        # Time Complexity: O(N) where N is the total number of pixels in the image (Rows * Cols). 
        #                  We visit and potentially update each pixel at most once.
        # Space Complexity: O(N) in the worst-case scenario. If the entire image needs to be flood filled,
        #                   the recursion call stack will grow to the size of the total number of pixels.
        # 
        # Logic:
        # 1. Check if the start pixel is already the target color. If it is, return immediately 
        #    to avoid an infinite recursion cycle.
        # 2. Define a recursive `dfs` function that updates the current pixel's color to the new target color.
        # 3. Iterate through the 4 directional neighbors. 
        # 4. If a neighbor is within the grid bounds and matches the `oldColor`, recursively call `dfs` on it.
        # ==========================================
        
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        rows = len(image)
        cols = len(image[0])
        oldColor = image[sr][sc]
        
        # Step 1: Base case to avoid infinite loops if the color is already correct
        if image[sr][sc] == color:
            return image
            
        def dfs(sr, sc):
            nonlocal image, color, rows, cols, oldColor, directions
            
            # Step 2: Change the current pixel's color
            image[sr][sc] = color
            
            # Step 3: Explore 4-directional neighbors
            for r, c in directions:
                nr, nc = sr + r, c + sc
                
                # Step 4: Check bounds and if the neighbor is the old color we need to overwrite
                if nr >= 0 and nr < rows and nc >= 0 and nc < cols:
                    if image[nr][nc] == oldColor:
                        dfs(nr, nc)
                        
        dfs(sr, sc)
        return image