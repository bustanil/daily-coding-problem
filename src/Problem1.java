public class Problem1 {

//    This problem was recently asked by Google.
//    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
//    Bonus: Can you do this in one pass?

    public static void main(String[] args) {
        int[] numbers = new int[]{10, 15, 3, 7};

        int k = 10;
        boolean found = false;
        for (int i = 0; i < numbers.length - 1; i++) {
            int n1 = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int n2 = numbers[j];
                if (n1 + n2 == k) {
                    found = true;
                    break;
                }
            }
        }
        System.out.println(found);
    }
}
