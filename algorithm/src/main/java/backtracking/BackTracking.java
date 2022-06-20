package backtracking;

public class BackTracking {
    public static void main(String[] args) {

    }

    private int[] A = { 198, 775, 387, 206, 92 };

    void binary(int n) {
        if (n < 1) {
            System.out.println(A);
        } else {
            A[n - 1] = 0;
            binary(n - 1);
            A[n - 1] = 1;
            binary(n - 1);
        }
    }
}
