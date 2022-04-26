// Time Complexity                              :  O(N*M) where N is the number of rows and M is the number of columns in the matrix.
// Space Complexity                             :  O(H) where H is the height of the tree.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/flood-fill/


class Solution {
private: 
    vector<vector<int>> itr{{1,0},{-1,0},{0,1},{0,-1}};
    int n, m, nc, oc;
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        n = image.size(); m = image[0].size(), nc = newColor, oc = image[sr][sc];
        recursive(image, sr, sc);
        // iterative(image,sr,sc);
        return image;
    }
    
    void recursive(vector<vector<int>>& image, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m || image[i][j] == nc || image[i][j] != oc) return;
        
        if(image[i][j] == oc)
            image[i][j] = nc;
        
        for(auto it : itr) {
            recursive(image, i + it[0], j + it[1]);
        }
    }
    
    void iterative(vector<vector<int>>& image, int i, int j) {
        
        stack<pair<int,int>> st;
        st.push({i,j});
        
        while(!st.empty()) {
            auto [r , c] = st.top();st.pop();
            image[r][c] = nc;
            
            for(auto it : itr) {
                int i = r + it[0];
                int j = c + it[1];
                
                if(i < 0 or i >= n or j < 0 or j >= m or image[i][j] == nc || image[i][j] != oc) 
                    continue;
                
                if(image[i][j] == oc) {
                    st.push({i,j});
                }
            }           
        }
    }
    
};