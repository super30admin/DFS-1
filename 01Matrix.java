{\rtf1\ansi\ansicpg1252\cocoartf2513
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww10800\viewh8920\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 // Time Complexity :  O(N) no of elements\
// Space Complexity : O(N)\
// Did this code successfully run on Leetcode :Yes\
// Any problem you faced while coding this :No\
\
class Solution \{\
    \
    public int[][] updateMatrix(int[][] matrix) \{\
        int R = matrix.length;\
        if(R == 0) return matrix;\
        int C = matrix[0].length;\
        int[][] dirs = new int[][]\{\{-1,0\},\{0,-1\},\{1,0\},\{0,1\}\};\
        boolean[][] visited = new boolean[R][C];\
        \
        Queue<int[]> q = new LinkedList<>();\
        for(int i = 0; i < R; i++)\{\
            for(int j = 0; j < C; j++)\{\
                if(matrix[i][j] == 0)\{\
                    q.offer(new int[]\{i,j\});\
                    visited[i][j] = true;\
                \}\
            \}\
        \}\
        int level = 1;\
        \
        while(!q.isEmpty())\{\
            \
            int size = q.size();\
            for(int i = 0; i < size; i++)\{\
                int[] co = q.poll();\
                for(int[] dir : dirs)\{\
                    int r = co[0] + dir[0];\
                    int c = co[1] + dir[1];\
                    if(r >= 0 && c >= 0 && r < R && c < C && !visited[r][c])\{\
                        if(matrix[r][c] == 1)\{\
                            matrix[r][c] = level;\
                            visited[r][c] = true;\
                            q.offer(new int[]\{r,c\});\
                        \}\
                    \}\
                \}\
\
            \}\
            level++;\
        \}     \
        return matrix;\
    \}\
\}}