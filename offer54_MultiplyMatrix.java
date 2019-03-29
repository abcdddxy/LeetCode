import java.util.Arrays;

public class offer54_MultiplyMatrix {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len], C = new int[len], D = new int[len];
        Arrays.fill(C, 1);
        Arrays.fill(D, 1);
        for (int i = 1; i < len; i++) C[i] = C[i - 1] * A[i - 1];
        for (int i = len - 2; i >= 0; i--) D[i] = D[i + 1] * A[i + 1];
        for (int i = 0; i < len; i++) B[i] =C[i]*D[i];
        return B;
    }
}
