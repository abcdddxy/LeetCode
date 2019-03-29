import java.util.ArrayList;

public class offer41_FindContSeq {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int ptr1 = 1, ptr2 = 2, tmpSum = 3;
        while (ptr2 < sum){
            if (tmpSum < sum) {
                ptr2++;
                tmpSum += ptr2;
            } else if (tmpSum > sum) {
                tmpSum -= ptr1;
                ptr1++;
            } else {
                ans.add(addElement(ptr1, ptr2));
                ptr2++;
                tmpSum += ptr2;
            }
        }
        return ans;
    }

    private ArrayList<Integer> addElement(int a, int b) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = a; i <= b; i++) tmp.add(i);
        return tmp;
    }
}
