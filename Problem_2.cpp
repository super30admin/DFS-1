/**
 * Time complexity:
 * O(m*n)  because we are going through the entire matrix when we are checking the
 * values initially. Then during the BFS we are again goin through the entire
 * matrix again to check. So, the TC is O(2(m*n)) which is equivalent to O(m*n)
 */

/**
 * Space complexity:
 * O(m*n) because we are maintaining q queue for it
 */

/**
 * Approach:
 * We are using the BFS because DFS wasn't giving us an optimized solution. So,
 * first we are traversing through the entire matrix and store the indixes of the
 * 0s in the queue and changing the values of 1 to -1 so that there is no confusion
 * or the original matrix is not lost. Then we perform the BFS with the queue and 
 * check all the directions of the current cell with the help of the dirs array while
 * also taking care of the bound check and if the neighbouring cell has value of -1 
 * or not. If it is in bounds and the value is -1 then we change the value of 
 * the current index by adding 1 to it. This goes on until the queue becomes empty 
 * which means that there were no values left with value -1 as we push the new indices
 * formed with the help of the direction array into the queue if the value at the cell
 * with new indices was found to be -1.
 */

// The code ran perfectly on leetcode

class Solution {    
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        vector<vector<int>> dirs = {{0,1}, {0, -1}, {-1, 0}, {1,0}};
        queue<vector<int>> q;
        int rSize = mat.size();
        int cSize = mat[0].size();
        for(int i =0; i<rSize; i++){
            for(int j =0; j<cSize; j++){
                if(mat[i][j] == 0){
                    q.push({i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        while(q.empty() == false){
                vector<int> curr = q.front();
                q.pop();
                for(auto x : dirs){
                    int nr = curr[0] + x[0];
                    int nc = curr[1] + x[1];
                    if(nr >= 0 && nc >= 0 && nr <rSize && nc < cSize && mat[nr][nc] == -1){
                        q.push({nr, nc});
                        mat[nr][nc] = mat[curr[0]][curr[1]] +1;
                }
            }
        }
        
        return mat;
    }
};