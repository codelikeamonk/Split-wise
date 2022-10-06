    /* 
    JASH JAIN 
    A029 

    Splitwise is an app for splitting expenses with your friends. 
    It lets you and your friends add various bills and keep track of who owes who, 
    and then it helps you to settle up with each other.

    */                
    import java.util.*;
    public class splitwise {

    static final int n = 3;
    static int getMin(int arr[])
    {
    int minIndex = 0;
    for (int i = 1; i < n ; i++){
    if(arr[i] < arr[minIndex]){
    minIndex = i;
    }
    }
    return minIndex;
    }
    static int getMax(int arr[])
    {
    int maxIndex = 0;
    for (int i = 1; i < n ; i++)
    {
    if (arr[i] > arr[maxIndex])
    {
    maxIndex = i;
    }
    }
    return maxIndex;
    }
    static int min(int a, int b)
    {
    return Math.min(a,b);
    }
    static void minCashFlowRecurring(int amount[])
    {
    int maxCredit = getMax(amount);
    int maxDebit = getMin(amount);


    if (amount[maxCredit] == 0 && amount[maxDebit] == 0)
    {
    System.out.println("All amounts are now clear");
    return;
    }


    int min = min(-amount[maxDebit], amount[maxCredit]);
    amount[maxCredit] = amount[maxCredit]- min;
    amount[maxDebit]  = amount[maxDebit] + min;


    System.out.println("Person " + maxDebit + " pays " + min + " to Person " + maxCredit);

    minCashFlowRecurring(amount);
    }
    static void minCashFlow(int graph[][])
    {

    int amount[]=new int[n];


    for (int i = 0; i < n; i++)
    {

    for (int j = 0; j < n; j++)
    {
    amount[i] = amount[i] + (graph[j][i] - graph[i][j]);
    }
    }

    //  System.out.println(amount[0] + " " + amount[1] + " " + amount[2]);
    minCashFlowRecurring(amount);
    }
    
    public static void main (String[] args)
    {
    // int graph[][] = { {0, 1000, 2000},{0, 0, 5000},{0, 0, 0},}; 
    //int graph[][] = { {0, 1000, 2000},{700,0,5000},{1000,2000,0},};
    int graph[][] = { {0, 1000,0},{0, 0,1000},{1000, 0, 0},};

    minCashFlow(graph);
    }


    }

