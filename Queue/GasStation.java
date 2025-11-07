package Queue;

class Solution2 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0, totalCost=0;
        int start=0,currentGas=0;
        for(int i=0;i<gas.length;i++)
        {
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas<totalCost)
            return -1;
        else{
            for(int i=0;i<gas.length;i++)
            {
               currentGas+=(gas[i]-cost[i]);
               if(currentGas<0){
                    start=i+1;
                    currentGas=0;
               }
            }
        }
        return start;
    }
}

public class GasStation {
    public static void main(String args[])
    {
        int gasStation[]=new int[]{1,2,3,4,5};
        int cost[]=new int[]{3,4,5,1,2};
        int answer= Solution2.canCompleteCircuit(gasStation,cost);
        System.out.println(answer);
    }
}
