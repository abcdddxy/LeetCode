import java.util.LinkedList;
import java.util.List;

public class offer23_SequenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        int count = sequence.length;
        if (count == 0)
            return false;
        return isRight(sequence, 0, count - 1);

    }

    public boolean isRight(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int i = end - 1;
        while (sequence[i] > sequence[end] && i > start) i--;
        for (int j = start; j < i; j++) {
            if (sequence[j] > sequence[end]) return false;
        }
        return isRight(sequence, start, i) && isRight(sequence, i + 1, end - 1);
    }
}
