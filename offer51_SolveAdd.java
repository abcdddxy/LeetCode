public class offer51_SolveAdd {
    public int Add(int num1, int num2) {
        int sum, carry;
        sum = num1 ^ num2;
        carry = (num1 & num2) << 1;
        if (carry == 0) return sum;
        else return Add(sum, carry);
    }
}
