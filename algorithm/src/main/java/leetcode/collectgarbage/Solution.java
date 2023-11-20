package leetcode.collectgarbage;

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int gt = 0;
        int pt = 0;
        int mt = 0;

        // 마지막으로 쓰레기가 존재하는집을 찾아서 이후는 방문할 필요가 없도록 해야 한다
        gt += collectGarbage('G', garbage, travel);
        pt += collectGarbage('P', garbage, travel);
        mt += collectGarbage('M', garbage, travel);

        return gt + pt + mt;
    }

    private int collectGarbage(char target, String[] garbage, int[] travel) {
        int last = getLast(target, garbage);

        int tt = 0;
        int ct = 0;
        for (int i = 0; i <= last; i++) {
            if (i > 0) {
                tt += travel[i - 1];
            }
            char[] garbages = garbage[i].toCharArray();
            for (char g : garbages) {
                if (g == target) {
                    ct++;
                }
            }
        }
        if (ct == 0) {
            return 0;
        }
        return ct + tt;
    }

    private static int getLast(char target, String[] garbage) {
        for (int i = garbage.length - 1; i >= 0; i--) {
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == target) {
                    return i;
                }
            }
        }
        return garbage.length - 1;
    }
}
