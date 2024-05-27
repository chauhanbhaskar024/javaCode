import java.util.*;

class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int m = 102;
        int n = 1002;
        int[][] setA = new int[m][2];
        int[][] setB = new int[n][2];

        for (int i = 0; i < m; i++) {
            setA[i][0] = rand.nextInt(100);
            setA[i][1] = rand.nextInt(100);
        }

        for (int i = 0; i < n; i++) {
            setB[i][0] = rand.nextInt(100) + 50;
            setB[i][1] = rand.nextInt(100) + 50;
        }

        int epsilon = 14;
        ArrayList<int[]> pairs = pairLessThanEpsilon(setA, setB, epsilon);
        System.out.println("Pairs with Euclidean distance less than epsilon:");
        int i = 0;
        for (int[] pair : pairs) {

            int b[] = new int[2];
            int c[] = new int[2];
            b = Arrays.copyOfRange(pair, 0, 2);
            c = Arrays.copyOfRange(pair, 2, pair.length);
            System.out.println("Pair " + i + " : " + Arrays.toString(b) + " " + Arrays.toString(c));
            i++;
        }
    }

    public static ArrayList<int[]> pairLessThanEpsilon(int[][] setA, int[][] setB, int epsilon) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < setA.length; i++) {
            int x1 = setA[i][0];
            int y1 = setA[i][1];
            for (int j = 0; j < setB.length; j++) {
                int x2 = setB[j][0];
                int y2 = setB[j][1];
                int dx = x2 - x1;
                int dy = y2 - y1;
                int squaredDistance = dx * dx + dy * dy;
                if (squaredDistance < epsilon * epsilon) {
                    res.add(new int[]{x1, y1, x2, y2});
                }
            }
        }
        return res;
    }
}
//