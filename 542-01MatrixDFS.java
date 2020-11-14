/**LC-542 In this question BFS is the optimal solution since it gives O(MN)
 * Time Complexity : O(MN)^2
 * Space Complexity : O(MN)
 *
 Algorithm:
 We can start dfs from either 0 or 1.
 We are doing dfs from each and every 0.
 We first do dfs from 1st 0 and change all the 1s to 1,2, 3 acc. to their distance.
 Now we take next 0 and perform the dfs again. Now we would keep the minimum values of the previous 1, 2

This is not an optimal solution, go for the BFS
For interview, go for BFS solution 1st. 

 */