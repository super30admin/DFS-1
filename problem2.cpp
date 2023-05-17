// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// we see that there are connected components in the matrix, so we use bfs.
// as o's wont change during the process i.e., 0's are independent values. so we push them into queue and start bfs. 
// we changes non-zero values to -1 to avoid repeaated execution of any particular cell.
// we traverse in four directions and check if values is == -1, that means ,
//  that cell is not been processes yet. we process that cell and store level+1 in that cell. and finally return the matrix.

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        if(mat.empty() || mat.size()==0) return mat;
        int m = mat.size();
        int n = mat[0].size();
        queue<pair<int,int>>q;
        vector<pair<int,int>>dir = {{-1,0},{1,0},{0,-1},{0,1}}; // U D L R
        for(int i =0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.push({i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        int lvl = 0;
        while(!q.empty())
        {
            int size = q.size();
            while(size--)
            {
                auto p = q.front();q.pop();
                for(auto d: dir)
                {
                    int nr = p.first + d.first;
                    int nc = p.second + d.second;
                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == -1)
                    {
                        mat[nr][nc] = lvl + 1;
                        q.push({nr,nc});
                    }
                }
            }
            lvl++;
        }
        return mat;
    }
};