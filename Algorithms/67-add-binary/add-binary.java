import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger decimalValueA = new BigInteger(a, 2);
        BigInteger decimalValueB = new BigInteger(b, 2);
        BigInteger sum = decimalValueA.add(decimalValueB);
        String binarySumBig = sum.toString(2);
        return binarySumBig;
    }
}