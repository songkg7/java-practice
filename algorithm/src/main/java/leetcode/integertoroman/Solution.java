package leetcode.integertoroman;

public class Solution {

    public String intToRoman(int num) {
        return RomanSymbol.toRoman(num);
    }

    public enum RomanSymbol {
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);

        private final int value;

        RomanSymbol(int value) {
            this.value = value;
        }

        public static String toRoman(int num) {
            StringBuilder sb = new StringBuilder();
            for (RomanSymbol symbol : RomanSymbol.values()) {
                int t = num / symbol.value;
                sb.append(symbol.name().repeat(t));
                num %= symbol.value;
            }
            return sb.toString();
        }

    }

}
