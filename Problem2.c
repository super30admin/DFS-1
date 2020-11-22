/* Problem Statement:
Verified on leetcode

https://leetcode.com/problems/01-matrix/
542. 01 Matrix

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]


 *
 * Time Complexity : O(r*c)
 * Space Complexity : O(r*c)
 */



#define MAX_QUEUE_SIZE 2
#define ROW_COL 3
#define DIR_LEN 4

// A structure to represent a queue
typedef struct queue
{
    int front, rear, size;
    unsigned capacity;
    int** array;
}queue_t;

/**** Queue functions start ***/

queue_t* createqueue()
{
    queue_t* q = (queue_t*)calloc(1, sizeof(queue_t));
    q->array = (int **)calloc(MAX_QUEUE_SIZE, sizeof(int *));
    q->capacity = MAX_QUEUE_SIZE;
    q->front = q->size = 0; 
    q->rear = MAX_QUEUE_SIZE - 1;
    return q;
}
 
// queue is full when size becomes equal to the capacity 
int isFull(queue_t* queue)
{  return (queue->size == queue->capacity);  }
 
// queue is empty when size is 0
int isEmpty(queue_t* queue)
{  return (queue->size == 0); }
 
// Function to add an item to the queue.  It changes rear and size
void enqueue(queue_t* queue, int item_row, int item_col, int item_depth)
{
    int *item = NULL;
    if (isFull(queue)) {
        printf("full new capacity: %d\n", (queue->size) * 2);
        queue->array = (int **)realloc(queue->array, sizeof(int*) * (queue->size) * 2);
        queue->capacity = (queue->size) * 2;
    }
    /* store row and col */
    item = (int *)malloc(sizeof(int) * ROW_COL);
    if (!item) {
        return;
    }
    item[0] = item_row;
    item[1] = item_col;
    item[2] = item_depth;
    queue->rear = (queue->rear + 1) % queue->capacity;
    queue->array[queue->rear] = item;
    queue->size = queue->size + 1;
    //printf("%ld enqueued to queue\n", item->data);
}
 
// Function to remove an item from queue.  It changes front and size
int* dequeue(queue_t* queue)
{
    if (isEmpty(queue))
        return NULL;
    int *item = queue->array[queue->front];
    queue->front = (queue->front + 1) % queue->capacity;
    queue->size = queue->size - 1;
    return item;
}

void free_queue(queue_t* queue) {
    printf("here\n");
    free(queue->array);
    free(queue);
}

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** updateMatrix(int** matrix, int matrixSize, int* matrixColSize, int* returnSize, int** returnColumnSizes){
    
    int **final_arr = NULL;
    int *temp_item = NULL;
    int *ret_col = NULL;
    int row = 0, col = 0, dir = 0;
    int curr_size = 0;
    int vl = 0, vr = 0;
    int idx = 0, idx2 = 0;
    *returnSize = 0;
    *returnColumnSizes = NULL;
    queue_t *queue = NULL;
    
    /* for direction movement */
    int rowDir[] = {0,0,1,-1};
    int colDir[] = {1,-1,0,0};
    
    /* verification checks */
    if (!matrixSize) {
        return final_arr;
    }
    /* memory allocation for final array */
    final_arr = (int **)calloc(matrixSize, sizeof(int *));
    if (!final_arr) {
        return NULL;
    }
    *returnSize = matrixSize;
    
    ret_col = (int *)calloc(matrixSize, sizeof(int));
    
    queue = createqueue();
    /* initialize final array and its subarrays . also add all 0 places into the queue */
    for (row = 0; row < matrixSize; row++) {
        final_arr[row] = (int *)calloc(*matrixColSize, sizeof(int));
        ret_col[row] = *matrixColSize;
        
        for (col = 0; col < *matrixColSize; col++) {
            if (matrix[row][col] != 0) {
                final_arr[row][col] = -1;                 
            } else {
                enqueue(queue, row, col, 0);
            }
        }     
    }
    /* BFS traversal */
    while (!isEmpty(queue)) {
        curr_size = queue->size;
        /* for each element at that level, determine its directional neighbors and add it in queue again if its not yet added */
            temp_item = dequeue(queue);

            //printf("neigh: %d %d (%d) : ", temp_item[0], temp_item[1], matrix[temp_item[0]][temp_item[1]]);
            for (dir = 0; dir < DIR_LEN; dir++) {
                vl = temp_item[0] + rowDir[dir];
                vr = temp_item[1] + colDir[dir];

                if ((vl >= 0 && vl < matrixSize) && (vr >= 0 && vr < *matrixColSize)) {
                    /* update the depth and then add it into the queue */
                    if (final_arr[vl][vr] == -1 || final_arr[vl][vr] > (temp_item[2] + 1)) {
                        //printf(" [%d]  add : %d %d : %d", final_arr[vl][vr], vl,vr, temp_item[2] + 1);
                        final_arr[vl][vr] = temp_item[2] + 1;
                        enqueue(queue,vl,vr,temp_item[2] + 1);
                    }
                }
            }
        free(temp_item);
    }
    /* free queue and update column sizes */
    free_queue(queue);
    *returnColumnSizes = ret_col;
    return final_arr;
 
}


/* Execute it on LeetCode platform*/

