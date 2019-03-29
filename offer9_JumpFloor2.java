public class offer9_JumpFloor2 {
    public int JumpFloorII(int target) {
        if (target == 1) return 1;
        return (int) Math.pow(2, target - 1);
    }
}
