//Time Complexity O(m*n)
// Space Complexity O(m*n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
using namespace std;


class Solution {
public:
    queue<vector<int> > q;
    int lvl=1;
    int dirs[4][2]={{0,1},{0,-1},{-1,0},{1,0}};
    vector<vector<int> > updateMatrix(vector<vector<int> >& mat) {
        int rows=mat.size();
        int cols=mat[0].size();
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(mat[i][j]==0)
                {
                    q.push({i,j});
                }
                else
                {
                    mat[i][j]=-1;
                }
            }
        }
        
        
        while(!q.empty())
        {
            int sizeQueue=q.size();
            for(int i=0;i<sizeQueue;i++)
            {
                vector<int> top = q.front();
                q.pop();
                
                int row=top[0];
                int col=top[1];
                
                for(auto &dir : dirs)
                {
                    int nr=row+dir[0];
                    int nc=col+dir[1];
                    
                    if(nr>=0 && nr < rows && nc >=0 && nc < cols && mat[nr][nc]==-1)
                    {
                        mat[nr][nc]=lvl;
                        q.push({nr,nc});
                    }
                }
            }
            lvl++;
        }
        
        return mat;
    }
};