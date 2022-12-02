// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

//Approach 1: BFS

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        if(mat.size() == 0) return mat;

        int m = mat.size();
        int n = mat[0].size();
        queue<pair<int,int>> q;
        int numberOnes = 0;
        vector<vector<int>> dirs ({{-1, 0}, {1, 0}, {0, -1}, {0, 1}});
        int level = 1; 

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    q.push({i,j});
                else{
                    //replacing it with -ve because distance can't be negative and we won't have to parse it again
                    mat[i][j] = -1;
                    //later breal if we have processed all the 1s
                    numberOnes++;
                }
            }

        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                auto coordnates = q.front();
                q.pop();
                for(auto dir : dirs){
                    int new_row = coordnates.first + dir[0];
                    int new_col = coordnates.second + dir[1];
                    if(new_row >= 0 && new_col >= 0 && new_row < m && new_col < n && mat[new_row][new_col] == -1){
                        mat[new_row][new_col] = level;
                        q.push({new_row, new_col});
                    }
                }
            }
            level++;

        }
        return mat;
    }
};

//Approach 2: BFR but break after all the 1s are processed


class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        if(mat.size() == 0) return mat;

        int m = mat.size();
        int n = mat[0].size();
        queue<pair<int,int>> q;
        int numberOnes = 0;
        vector<vector<int>> dirs ({{-1, 0}, {1, 0}, {0, -1}, {0, 1}});
        int level = 1; 

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    q.push({i,j});
                else{
                    //replacing it with -ve because distance can't be negative and we won't have to parse it again
                    mat[i][j] = -1;
                    //later breal if we have processed all the 1s
                    numberOnes++;
                }
            }

        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                auto coordnates = q.front();
                q.pop();
                for(auto dir : dirs){
                    int new_row = coordnates.first + dir[0];
                    int new_col = coordnates.second + dir[1];
                    if(new_row >= 0 && new_col >= 0 && new_row < m && new_col < n && mat[new_row][new_col] == -1){
                        mat[new_row][new_col] = level;
                        q.push({new_row, new_col});
                        numberOnes--;
                    }
                    if(numberOnes == 0) return mat;
                }
            }
            level++;

        }
        return mat;
    }
};

//Approach 3: Without level and size

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        if(mat.size() == 0) return mat;

        int m = mat.size();
        int n = mat[0].size();
        queue<pair<int,int>> q;
        int numberOnes = 0;
        vector<vector<int>> dirs ({{-1, 0}, {1, 0}, {0, -1}, {0, 1}});

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    q.push({i,j});
                else{
                    //replacing it with -ve because distance can't be negative and we won't have to parse it again
                    mat[i][j] = -1;
                    //later breal if we have processed all the 1s
                    numberOnes++;
                }
            }

        while(!q.empty()){
                auto coordnates = q.front();
                q.pop();
                int parent = mat[coordnates.first][coordnates.second];
                for(auto dir : dirs){
                    int new_row = coordnates.first + dir[0];
                    int new_col = coordnates.second + dir[1];
                    if(new_row >= 0 && new_col >= 0 && new_row < m && new_col < n && mat[new_row][new_col] == -1){
                        mat[new_row][new_col] = parent + 1;
                        q.push({new_row, new_col});
                        numberOnes--;
                    }
                    if(numberOnes == 0) return mat;
                }

        }
        return mat;
    }
};