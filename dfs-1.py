#Problem 1: Flood fill
#time compplexity: O(V+E), edges and vertices
#Space Complexity O(n) (call stack)


#RECUSRIVE SOLUTION
'''
idea: We just go through all the nodes (r,c) that I can go too from a starting point. Before calling
the other recursive function, we make sure that the next color is in fact like the starting color.
DFS traversal seems appropriate since we don't need to keep track of the generations (but could be done in BFS).
We don't forget the case where starting color is the same as newColor, so nothing is changed
'''
#Do we actually need 4 while loops for the iterative solution or there's a bette way?
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image:
            return image
        n=len(image)
        m=len(image[0])
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        starting_color=image[sr][sc]
        if starting_color==newColor:
            return image
        def helper(i,j):
            nonlocal n,m,dirs,newColor,starting_color
            if image[i][j]==starting_color:
                image[i][j]=newColor
            print(starting_color)
            for d in dirs:
                new_i,new_j=i+d[0],j+d[1]
                if 0<=new_i<n and 0<=new_j<m and image[new_i][new_j]==starting_color:
                    helper(new_i,new_j)
        helper(sr,sc)
        return image

#Problem 2: 01 matrix
#time complexity: O(n) n number of elements in matrix
#Space complexity: O(n), queue

'''
idea: BFS from EACH point that is not 0. the distance is the generation we're at.
We put a new element in queue if it's present value is bigger than the generation we're
at (basically to avoid re-using a cell that we've updated already). We start by transforming
the ones to float("inf"). Meaning they weren't updated. We could use a different value
to give the "not visited" tag, but to avoid colisions, float('inf') is a safe choice. Since
we go generation by generation, we know that if it's been visited, it means it has the
correct value (can't be higher)
'''

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        #edge case:
        if not matrix:
            return matrix
        n=len(matrix)
        m=len(matrix[0])
        q=collections.deque()
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        for r in range(n):
            for c in range(m):
                if matrix[r][c]==0:
                    q.append((r,c))
                else:
                    matrix[r][c]=float("inf")
        distance=0
        while q:
            size=len(q)
            count=0
            distance+=1
            while q and count<size:
                count+=1
                r,c=q.popleft()
                for d in dirs:
                    new_r,new_c=r+d[0],c+d[1]
                    if 0<=new_r<n and 0<=new_c<m:
                        if matrix[new_r][new_c]>distance:
                            matrix[new_r][new_c]=distance
                            q.append((new_r,new_c))
        return matrix
