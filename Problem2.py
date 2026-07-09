## Problem2 (https://leetcode.com/problems/01-matrix/)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # BFS Solution
        """
        Time Complexity: O(R * C), where R is the number of rows and C is the number of columns.
        We iterate over the matrix once to initialize the queue, and then each cell 
        is pushed and popped from the queue at most once during the BFS.
        Space Complexity: O(R * C) in the worst-case scenario. 
        If the matrix is filled entirely with 0s, the queue will store all R * C elements.
        The matrix is updated in-place, so no secondary distance matrix is needed.
        """
        rows = len(mat)
        cols = len(mat[0])
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        
        # Queue for multi-source Breadth-First Search
        q = collections.deque()

        # Step 1: Initialize the queue and mark unvisited cells
        for r in range(rows):
            for c in range(cols):
                if mat[r][c]:
                    # Mark cells containing 1 as -1 to indicate they are "unvisited"
                    mat[r][c] = -1
                else:
                    # Add all cells containing 0 to the queue as starting points
                    q.append([r, c])

        # Step 2: Perform BFS to calculate distances level by level
        level = 1
        
        while q:
            size = len(q)
            # Process all nodes at the current distance level before moving further out
            for _ in range(size):
                r, c = q.popleft()
                
                # Explore all 4 adjacent neighbors (up, down, left, right)
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc

                    # Check if the new coordinates are within the matrix bounds
                    if nr >= 0 and nc >= 0 and nr < rows and nc < cols:
                        # If the neighbor hasn't been visited yet (marked as -1)
                        if mat[nr][nc] == -1:
                            # Update its distance to the current level
                            mat[nr][nc] = level
                            # Add the newly visited cell to the queue to explore its neighbors later
                            q.append([nr, nc])
            
            # Increment the distance level after fully processing the current radius
            level += 1

        return mat