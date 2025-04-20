'''
Time complexity --> O(n*m)
Space Complexity --> O(n*m)

Approach:

1. Same as rotten oranges.
2. As your aim is to find the nearest zero
3. Load the queue with all the zero's
4. Then it's easy to find all the first degree 1's which are at distance 1
5. You maintain the size of the queue while traversing the queue, so that you find
all the level 1.
6. Once the size is empty, you will go and fill next degree items and update the distance accordingly
7. Either update the same array, then you dont need visited set
8. Update the different array, you need visited set
9. Some how I feel confident with visited set.
'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        visited = set()
        dist=0
        directions =[[-1,0],[0,1],[1,0],[0,-1]]
        r_mat = mat

        for i in range(len(mat)):
            for j in range(len(mat[0])):

                if mat[i][j]==0:
                    queue.append([i,j])
                    visited.add((i,j))


        while(queue):
            k = len(queue)
            dist+=1

            for i in range(k):
                curr_dim = queue.popleft()
                curr_row = curr_dim[0]
                curr_col = curr_dim[1]

                for row, col in directions:
                    updated_row = row+curr_row
                    updated_col = col+curr_col
                    if (updated_row in range(0, len(mat)) and updated_col in range(0,len(mat[0]))):
                        if mat[updated_row][updated_col]==1 and (updated_row,updated_col) not in visited:
                            queue.append([updated_row, updated_col])
                            visited.add((updated_row,updated_col))
                            r_mat[updated_row][updated_col] = dist

        return r_mat



