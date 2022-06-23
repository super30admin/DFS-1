
// Time Complexity : O( m*n )
// Space Complexity : O( m*n )
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// BFS approach

class Solution {
    vector<pair<int,int>>dir = {{1,0}, {0,1}, {0,-1}, {-1,0}};
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        int rows = mat.size();
        int cols = mat[0].size();
        vector<vector<int>>dist( rows, vector<int>( cols, INT_MAX));
        

        
        list<pair<int,int>>l1; // dll 
        
        for( int i=0; i<rows; i++){
            for( int j=0; j<cols; j++){
                if( mat[i][j] == 0 ){
                    dist[i][j]=0;
                    l1.push_back( make_pair(i,j));
                }
            }
        }
        
        
        while( l1.size()){
            
            pair<int,int>p1 = l1.front();
            l1.pop_front();
            for( int i=0; i<dir.size(); i++){
                int newi = p1.first + dir[i].first;
                int newj = p1.second + dir[i].second;
                
                if( ( newi < 0 ) || ( newi >= rows ) || ( newj < 0) || ( newj >=cols ) ||
                    ( mat[newi][newj] == 0 ) ){
                    continue;
                }
                if( 1+ dist[p1.first][p1.second] < dist[newi][newj]){
                   l1.push_back( make_pair( newi, newj));
                   dist[newi][newj] = 1+ dist[p1.first][p1.second];
                }
            }
            
        }
        
        return dist;
        
        
        
    }
};
