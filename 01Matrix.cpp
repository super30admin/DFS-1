/*
Intuition: Instead of thinking of exploring all 1's, explore all 0's

Go level by level. To distinguish a nearest zero value with 1, negate the number.
BFS Solution
Time Complexity: O(M*N) where M = number of rows, N = number of cols
Space Complexity: O(M*N) where M = number of rows, N = number of cols
*/

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        int rows = mat.size();
        int cols = mat[0].size();
        vector <pair< int, int>> dirs;
        dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
        queue <pair<int, int>> queue;
        
        for (int i =0 ;i < rows; i++){
            
            for ( int j = 0; j < cols ; j ++){
            
                if ( mat[i][j] == 0){
                    queue.push({i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            
            }
        
        }
        int dist = 1;
        while ( queue.size()!= 0){
        
            int size = queue.size();
            
            for ( int i =0; i < size; i++){
                pair<int, int> currentIJ = queue.front();
                int currentI = currentIJ.first;
                int currentJ = currentIJ.second;
                queue.pop();
                for ( auto dir: dirs){
                    int newI = dir.first + currentI;
                    int newJ = dir.second + currentJ;
                    
                    if( newI >= 0 and newI < rows and newJ >=0 and newJ < cols and mat[newI][newJ] == -1){
                        mat[newI][newJ] = dist;
                        queue.push({newI, newJ});
                    }
                }
               
                
            } dist ++;
        
        }
        return mat;
        
    }
};