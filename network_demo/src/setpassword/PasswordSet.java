package setpassword;

import java.util.*;

/**
 * @author Hesenbai
 */

public class PasswordSet {
    private static final Map<Integer, List<String[]>> MAP = new HashMap<>();

    public static void main(String[] args) {
        // 获得一个密码
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = in.nextLine();
        System.out.println("请输入密码：");
        String psw = in.nextLine();

        System.out.println("原密码：" + psw);
        int temp = encryption(psw, username);
        System.out.println("加密后得到的hashCode：" + temp);
        psw = decryption(temp, username);
        System.out.println("解密后：" + psw);

        in.close();
    }

    private static String decryption(int hashCode, String username) {

        // 通过hashCode获得密钥桶
        List<String[]> arr = MAP.get(hashCode);

        /*
         *  遍历查找对应的username
         *  bucket -> { 用户名， 加密后密码， 偏移量 }
         */
        String[] check = null;
        for (var bucket : arr) {
            if (bucket[0].equals(username)) {
                check = bucket;
                break;
            }
        }

        // 通过check获取原密码
        if (check == null) {
            throw new RuntimeException("不可预知的错误！");
        }
        char[] temp = new char[check[1].length()];
        int index = 0;
        int shift = Integer.parseInt(check[2]);
        for (char ch : check[1].toCharArray()) {
            temp[index] = (char)(ch - shift);
            index++;
        }

        return String.valueOf(temp);
    }

    private static int encryption(String str, String username) {
        // 获得偏移量
        Random random = new Random();

        // [1, 26)
        int shift = random.nextInt(25) + 1;

        // 凯撒加密
        char[] temp = new char[str.length()];
        int index = 0;
        for (char ch : str.toCharArray()) {
            temp[index] = (char)(ch + shift);
            index++;
        }
        str = String.valueOf(temp);

        // 存储hashCode
        int code = str.hashCode();
        String[] value = new String[]{ username, str, String.valueOf(shift) };
        if (MAP.get(code) != null) {
            MAP.get(code).add(value);
        } else {
            List<String[]> list = new ArrayList<>();
            list.add(value);
            MAP.put(code, list);
        }

        // 返回hashCode
        return code;
    }
}
