public class lee134_GasStation_medium {
    // 暴力搜索
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (checkCycle(gas, cost, i)) return i;
        }
        return -1;
    }

    private boolean checkCycle(int[] gas, int[] cost, int order) {
        int res = 0, count = 0;
        if (gas[order] < cost[order]) return false;
        while (true) {
            System.out.println("res = [" + res + "], count = [" + count + "], order = [" + order + "]");
            res = res + gas[order] - cost[order];
            count++;
            if (res < 0) return false;
            if (count == gas.length) return true;
            if (order == gas.length - 1) order = 0;
            else order++;
        }
    }

    // 贪心算法
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int count = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            count += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        return (count < 0) ? -1 : start;
    }
}
