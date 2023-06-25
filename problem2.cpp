#include<iostream>
#include<vector>
#include<queue>
#include<unordered_map>

using namespace std;

//bfs

class Solution {
    typedef struct gg{
        int x;
        int y;
        gg(int x,int y):x(x),y(y){}
    }gg;
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        vector<gg> dirs{
            gg(-1,0),
            gg(1,0),
            gg(0,1),
            gg(0,-1)
        };
        queue<gg> q;
        int m = mat.size();
        int n = mat.at(0).size();
        for(int i{};i<m;++i){
            for(int j{};j<n;++j){
                if(mat.at(i).at(j)==0) q.push(gg(i,j));
                if(mat.at(i).at(j) == 1) mat.at(i).at(j)=-1;
            }
        }
        int dist{1};
        while(!q.empty()){
            int sz = q.size();
            for(int i{};i<sz;++i){
                gg node = q.front();
                for(gg& dir: dirs){
                    int x = node.x +dir.x;
                    int y = node.y + dir.y;
                    if(x>=0 && x<m && y>=0 && y<n && mat.at(x).at(y) == -1){
                        mat.at(x).at(y) = dist;
                        q.push(gg(x,y));
                    }
                }
            q.pop();
            }
            ++dist;
        }
        return mat;
    }
};

// O(MN)^2 DFS

class Solution_2 {
    void dfs(vector<vector<int>>& mat,int nr, int nc,int m,int n,int val){
        if(nr>=0 && nr<n && nc>=0 && nc<m && mat.at(nr).at(nc)>val){
            mat.at(nr).at(nc) = val+1;
            dfs(mat,nr,nc+1,m,n,mat.at(nr).at(nc));
            dfs(mat,nr,nc-1,m,n,mat.at(nr).at(nc));
            dfs(mat,nr+1,nc,m,n,mat.at(nr).at(nc));
            dfs(mat,nr-1,nc,m,n,mat.at(nr).at(nc));
        }
    }
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat.at(0).size();
        for(int i{};i<n;++i){
            for(int j{};j<m;++j){
                if(mat.at(i).at(j) == 1) mat.at(i).at(j) = m*n;
            }
        }
        for(int i{};i<n;++i){
            for(int j{};j<m;++j){
                if(mat.at(i).at(j)==0){
                    dfs(mat,i,j+1,m,n,0);
                    dfs(mat,i,j-1,m,n,0);
                    dfs(mat,i+1,j,m,n,0);
                    dfs(mat,i-1,j,m,n,0);
                }
            }
        }
        return mat;
    }
};

// optimal DFS

