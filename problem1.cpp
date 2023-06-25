#include<iostream>
#include<vector>
#include<queue>

using namespace std;

//using BFS

// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
if start color == color return image
else run BFS , check bounds of the array and if the color is start color.
if true change its value to color and add required directional into the BFS path
*/

class Solution {
    typedef struct gg{
        int x;
        int y;
        gg(int x,int y):x(x),y(y){}
    }gg;
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {

        vector<gg> dirs{
            gg(-1,0),
            gg(1,0),
            gg(0,-1),
            gg(0,1)
        };

        int m = image.size();
        int n = image.at(0).size();

        int start_color = image.at(sr).at(sc);
        if(start_color == color) return image;

        //using BFS

        queue<gg> q;
        q.push(gg(sr,sc));
        while(!q.empty()){
            gg node = q.front();
            int val = image.at(node.x).at(node.y);
            if(val == start_color){
                image.at(node.x).at(node.y) = color;
                for(gg &dir:dirs){
                    int x = node.x + dir.x;
                    int y = node.y + dir.y;
                    if(x>=0 && x<m && y>=0 && y<n && image.at(x).at(y)== start_color) q.push(gg(x,y));
                }
            }
            q.pop();
        }
        
        return image;

    }
};

// using DFS

// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
if start color == color return image
else run DFS, check bounds of the array and if the color is start color.
if true change its value to color and run DFS on that node.
*/


class Solution {

    void dfs(vector<vector<int>>& image,int x,int y,int m,int n,int start_color,int color){
        if(x>=0 && x<m && y>=0 && y<n && image.at(x).at(y) == start_color){
            image.at(x).at(y) = color;
            dfs(image,x,y+1,m,n,start_color,color);
            dfs(image,x,y-1,m,n,start_color,color);
            dfs(image,x+1,y,m,n,start_color,color);
            dfs(image,x-1,y,m,n,start_color,color);
        }
    }
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int m = image.size();
        int n = image.at(0).size();
        int start_color = image.at(sr).at(sc);
        if (start_color == color) return image;
        dfs(image,sr,sc,m,n,start_color,color);
        return image;
    }
};
