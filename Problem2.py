## Problem2 (https://leetcode.com/problems/01-matrix/)

# Method1: Using BFS starting with all 0s with offset
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) -- going through all nodes
# Space Complexity : O(M*N) -- worst cases would be when be all are 1s but one element is 0. The queue size
# would increase exponentially and at the leaves it will be max = M*N/4 considering each  node having 4 fresh nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Since we need to return distance of nearest 0 from 1 so we start one single BFS by adding all 0s in the queue. They are considered to be at
# distance 0 from 0. We go level by level to next level and wherever we find a 1 we update it with the distance. We need to make sure that
# we dont add the same node again in the queue, so we either keep an offset or we can also initially change all the 1s to -1. So 
# when we reach 1, we update the distance before putting them in the queue. If we kept an offset, we would need to iterate again and update
# distances by removing the offset

from collections import deque
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # BFS starting from all 0s
        m = len(mat)
        n = len(mat[0])
        # keep an offset. Used to keep track of visited as well as distance from nearest 0
        dist = 2 # keeping distance with an offset
        que = deque()
        for i in range(m):
            for j in range(n):
                if(mat[i][j] == 0):
                    # all 0s at same initial level
                    que.append((i,j))

        direc = [(0,1),(1,0),(0,-1),(-1,0)]

        # BFS
        while(que):
            # we go level by level to keep track of distance
            size = len(que)
            for i in range(size):
                r,c = que.popleft()

                # go to neigh
                for j in range(len(direc)):
                    nr = r + direc[j][0]
                    nc = c + direc[j][1]

                    # bounds and check if it is 1
                    if((0 <= nr < m) and (0 <= nc < n) and (mat[nr][nc] == 1)):
                        mat[nr][nc] = dist # distance kept in the cell with offset
                        # so that we dont visit this again
                        que.append((nr,nc))

            # after each level increment distance by 1
            dist += 1

        # now update the matrix as per required
        for i in range(m):
            for j in range(n):
                if(mat[i][j] != 0):
                    mat[i][j] -= 1

        return mat

sol = Solution()
print("Method1: Using BFS starting with all 0s with offset")
print(sol.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1],[1,1,1],[1,1,0]]))


# Method2: Using BFS starting with all 0s without offset
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) -- going through all nodes
# Space Complexity : O(M*N) -- worst cases would be when be all are 1s but one element is 0. The queue size
# would increase exponentially and at the leaves it will be max = M*N/4 considering each  node having 4 fresh nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The BFS is same as above. Just for keeping track of already visited nodes we are updating all the 1s with -1.
# to keep track of visited nodes with actual distance without offset update all the 1s with -1

from collections import deque
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # BFS starting from all 0s
        m = len(mat)
        n = len(mat[0])
        # to keep track of visited with actual distance without offset update all the 1s
        # with -1
        
        dist = 1 # keeping distance
        que = deque()
        for i in range(m):
            for j in range(n):
                if(mat[i][j] == 0):
                    # all 0s at same initial level
                    que.append((i,j))
                elif(mat[i][j] == 1):
                    mat[i][j] = -1

        direc = [(0,1),(1,0),(0,-1),(-1,0)]

        # BFS
        while(que):
            # we go level by level to keep track of distance
            size = len(que)
            for i in range(size):
                r,c = que.popleft()

                # go to neigh
                for j in range(len(direc)):
                    nr = r + direc[j][0]
                    nc = c + direc[j][1]

                    # bounds and check if it is -1
                    # -1 means it is 1 that has not been visited
                    if((0 <= nr < m) and (0 <= nc < n) and (mat[nr][nc] == -1)):
                        mat[nr][nc] = dist # distance kept in the cell without offset
                        # so that we dont visit this again
                        que.append((nr,nc))

            # after each level increment distance by 1
            dist += 1

        return mat

sol = Solution()
print("Method2: Using BFS starting with all 0s without offset")
print(sol.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1],[1,1,1],[1,1,0]]))


# Method3: Using BFS starting with all 0s without offset without distance variable
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) -- going through all nodes
# Space Complexity : O(M*N) -- worst cases would be when be all are 1s but one element is 0. The queue size
# would increase exponentially and at the leaves it will be max = M*N/4 considering each  node having 4 fresh nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The BFS is same as above. Here we are not maintaining the size and distance variable. As we put 0 distance variable in the queue, so 
# all the nodes that we pop subsequently will be at distance of 1 unit from the current node distance. So we dont need to keep size and 
# distance variables. We get distance from the parent cell value

from collections import deque
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # BFS starting from all 0s
        m = len(mat)
        n = len(mat[0])
        # to keep track of visited with actual distance without offset update all the 1s
        # with -1

        que = deque()
        for i in range(m):
            for j in range(n):
                if(mat[i][j] == 0):
                    # all 0s at same initial level
                    que.append((i,j))
                elif(mat[i][j] == 1):
                    mat[i][j] = -1

        direc = [(0,1),(1,0),(0,-1),(-1,0)]

        # BFS
        while(que):
            r,c = que.popleft()

            # go to neigh
            for j in range(len(direc)):
                nr = r + direc[j][0]
                nc = c + direc[j][1]

                # bounds and check if it is -1
                # -1 means it is 1 that has not been visited
                if((0 <= nr < m) and (0 <= nc < n) and (mat[nr][nc] == -1)):
                    mat[nr][nc] = mat[r][c] + 1 # new distance would be 1 more than distance of the parent node
                    # so that we dont visit this again
                    que.append((nr,nc))

        return mat

sol = Solution()
print("Method3: Using BFS starting with all 0s without offset without distance variable")
print(sol.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1],[1,1,1],[1,1,0]]))


# Method4: Using multiple BFS from 1s
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O((M*N) ^ 2) -- doing BFS from each and every 1. Each BFS is of O(M*N). So worst case would be all 1s but one element 0
# So for all BFS TC: O((M*N) ^ 2)
# Space Complexity : O((M*N)) -- So worst case would be all 1s but one element 0. For each BFS The queue size
# would increase exponentially and at the leaves it will be max = M*N/4 considering each  node having 4 fresh nodes
# Also we are keeping a visited set/array for each BFS. So that Space for each BFS = O(M*N)
# So for all BFS SC: O(M*N + M*N) = O((M*N)) since we are reusing the queue and visited set
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we do BFS from each and every 1. We go level by level. Wherever we find 0 at the earliest, we store the distance for the 1 from where
# we started the BFS break from that BFS. We need to maintain visited set/array for each BFS, so that we dont visit the same node again in the same BFS


from collections import deque
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # Mutiple BFS starting from each 1
        m = len(mat)
        n = len(mat[0])
        # to keep track of visited with actual distance without offset update all the 1s
        # with -1

        direc = [(0,1),(1,0),(0,-1),(-1,0)]
        for i in range(m):
            for j in range(n):
                if(mat[i][j] == 1):
                    # start BFS
                    visited = set()
                    visited.add((i,j))
                    que = deque()
                    que.append((i,j))
                    dist = 1
                    isZeroFound = False

                    while(que):
                        size = len(que)
                        for k in range(size):
                            r,c = que.popleft()
                            for p in range(len(direc)):
                                nr = r + direc[p][0]
                                nc = c + direc[p][1]

                                # check bound and check for zero
                                if((0 <= nr < m) and (0 <= nc < n) and ((nr,nc) not in visited)):
                                    if(mat[nr][nc] == 0):
                                        # found the nearest 0. store the distance and 
                                        # move to BFS for another 1
                                        mat[i][j] = dist
                                        isZeroFound = True
                                        break
                                    else:
                                        # found > 0. add to visited and queue
                                        visited.add((nr,nc))
                                        que.append((nr,nc))
                            
                            if(isZeroFound):
                                break

                        if(isZeroFound):
                            break
                            

                        # increment distance after each level
                        dist += 1


        return mat

sol = Solution()
print("Method4: Using multiple BFS from 1s")
print(sol.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1],[1,1,1],[1,1,0]]))

# Method5: Using multiple DFS from 0s
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M ^2 * N ^ 2) in worst case and O(M*N) -- Average or Amortized time complexity. In worst case it would go to O(M ^2 * N ^ 2)
# Space Complexity : O(M*N) - For every DFS - max recursive call stack would be O(M*N) when there is one 0 and rest all are 1s
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# For every 0, we start a DFS to all the 1s and note the disatnce. We start with an offset of 1 because 1 can be the distance or the node value.
# To differentiate between them we keep an offset. Within the same DFS, we choose to visit a node only when my visiting time is less than
# the existing time. So the existing time works as a memoized result. As the number of DFS increase, the neighbors we visit also decreases.
# But the time complexity of O(M ^2 * N ^ 2) in worst case and O(M*N) in Average or Amortized way

class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # DFS from all 0s to each and every 1
        def dfs(mat, r, c, time, direc):
            # base
            # bounds
            if((r < 0) or (c < 0) or (r >= len(mat)) or (c >= len(mat[0])) or (mat[r][c] == 0)):
                # skipping when out of bounds and neighbor is 0
                return

            # only visit the node if we get a better time or it is 1, else return
            # this works as a natural DP. we are using memoized results to compare
            if(mat[r][c] != 1 and time >= mat[r][c]):
                return

            # logic
            mat[r][c] = time

            # recurse
            for p in range(len(direc)):
                nr = r + direc[p][0]
                nc = c + direc[p][1]
                dfs(mat, nr, nc, time + 1, direc)


        m = len(mat)
        n = len(mat[0])

        time = 1#offset of 1
        # how to differentiate time = 1 and node value = 1
        direc = [(0,1), (1,0), (0,-1), (-1,0)]
        for i in range(m):
            for j in range(n):
                if(mat[i][j] == 0):
                    # start DFS from the neighbors of 0
                    for k in range(len(direc)):
                        nr = i + direc[k][0]
                        nc = j + direc[k][1]
                        dfs(mat, nr, nc, time + 1, direc)

        # remove offset and update the matrix
        for i in range(m):
            for j in range(n):
                if(mat[i][j] != 0):
                    mat[i][j] -= time

        return mat


sol = Solution()
print("Method5: Using multiple DFS from 0s")
print(sol.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1],[1,1,1],[1,1,0]]))


# Method5: Using multiple DFS from 1s
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N)
# Space Complexity : O(M*N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we do DFS starting from 1s. For every we check if it is 0 then we return 1 else we check with neighbors what is their min distance from 0
# We are always at one step above. Since we are iterating row by row and checking for all 1s and their neighbors, so we dont need to 
# recurse top and left as those results if exists would already have been calculated. But there are two problems how do we solve repeated subproblems
# and how do we stop infinite loop. Since we always visit right and down from a 1, we are able to stop infinite loop. When we recurse, we store
# the calculated subproblems in the memoized matrix. When we find the same subproblem again we do not calculate again

class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # DFS starting from 1s
        # there are 2 problems
        # how do we solve repeated subproblems -- keeping additional result or using same matrix as memo
        # how do we stop infinite loop -- checking neighbors before visiting them, ie one step before
        # so we dont need to visit the up and left recursion again as we are coming from that side itself
        # if r,c are out of bounds then this function returns very large value
        def dfs(mat, r, c):
            # base
            # check neighbors if any of them are 0
            # right
            if((c < len(mat[0]) - 1) and (mat[r][c + 1] == 0)):
                return 1
            # down
            if((r < len(mat) - 1) and (mat[r + 1][c] == 0)):
                return 1
            # left
            if((c > 0) and (mat[r][c - 1] == 0)):
                return 1
            # up
            if((r > 0) and (mat[r - 1][c] == 0)):
                return 1

            left = float('inf')
            right = float('inf')
            down = float('inf')
            up = float('inf')

            # no need to recurse top and left
            # since we are iterating row by row so our top and left parts have already been covered

            # left
            if((c > 0) and (result[r][c - 1] != 0)):
                # left neighbor was already calculated
                left = result[r][c - 1]
            
            # top
            if((r > 0) and (result[r - 1][c] != 0)):
                # top neighbor was already calculated
                up = result[r - 1][c]

            # recurse the right and down
            # right
            if(c < len(mat[0]) - 1):
                if(result[r][c + 1] == 0):
                    # right neighbor is yet to be calculated
                    # find the right neighbor and store it
                    result[r][c + 1] = dfs(mat, r, c+1)

                # Now right neigh exists
                right = result[r][c + 1]

            # down
            if(r < len(mat) - 1):
                if(result[r + 1][c] == 0):
                    # down neighbor is yet to be calculated
                    # find the down neighbor and store it
                    result[r + 1][c] = dfs(mat, r+1, c)

                down = result[r + 1][c]

            return 1 + min(right, down, left, up)


        result = []
        for i in range(len(mat)):
            row = []
            for j in range(len(mat[0])):
                row.append(0)

            result.append(row)

        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if(mat[i][j] == 1):
                    result[i][j] = dfs(mat, i, j)

        return result
    
sol = Solution()
print("Method6: Using multiple DFS from 1s")
print(sol.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
print(sol.updateMatrix([[0,0,0],[0,1,0],[1,1,1],[1,1,1],[1,1,0]]))