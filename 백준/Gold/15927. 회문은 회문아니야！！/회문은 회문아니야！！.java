import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (!palindrome(input)) {
            System.out.println(input.length());
        } else {
            if (isAllSame(input)) {
                System.out.println(-1);
            } else {
                System.out.println(input.length() - 1);
            }
        }
    }

    public static boolean isAllSame(String str) {
        char[] arr = str.toCharArray();
        char c = arr[0];
        int len = str.length();
        for (int i = 1; i < len; i++) {
            if (c != arr[i]) return false;
        }
        return true;
    }

    public static boolean palindrome(String str) {
        int len = str.length();
        int end = len - 1;
        char[] arr = str.toCharArray();

        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[end - i]) {
                return false;
            }
        }
        return true;
    }

}