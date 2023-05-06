package programmers.carpet;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int totalCarpetCount = brown + yellow;
        List<Carpet> candidates = new ArrayList<>();
        for (int i = 3; i <= Math.sqrt(totalCarpetCount); i++) {
            if (totalCarpetCount % i == 0) {
                candidates.add(new Carpet(totalCarpetCount / i, i));
            }
        }

        Carpet carpet = candidates.stream()
                .filter(Carpet::isValidCondition)
                .filter(v -> v.yellowCount() == yellow)
                .findFirst()
                .orElseThrow();

        return carpet.toArray();
    }

    static class Carpet {
        private final int width;
        private final int height;

        public Carpet(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int yellowCount() {
            return (width - 2) * (height - 2);
        }

        public boolean isValidCondition() {
            return width >= 3 && height >= 3 && width >= height;
        }

        public int[] toArray() {
            return new int[]{width, height};
        }
    }
}
