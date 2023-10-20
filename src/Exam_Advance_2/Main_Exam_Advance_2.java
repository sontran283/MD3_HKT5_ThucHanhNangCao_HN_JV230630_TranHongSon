package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main_Exam_Advance_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        boolean check = true;

        while (check) {
            System.out.println("**************** JAVA_HACKATHON_05_Exam_Advance_2_MENU *************** \n" +
                    "Chọn 1_ Nhập câu \n" +
                    "Chọn 2_ Đảo ngược câu \n" +
                    "Chọn 3_ Thoát ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("nhập một câu (ví dụ: “Peace and Quiet”): ");
                    str = scanner.nextLine();
                    break;
                case 2:
                    if (!str.isEmpty()) {
                        String reverseTest = hamDaoNguoc(str);
                        System.out.println("câu sau khi đảo ngược là: " + reverseTest);
                    } else {
                        System.err.println("nhập sai định dạng, vui lòng nhập lại");
                    }
                    break;
                case 3:
                    check = false;
                    System.out.println("thoát");
                    break;
                default:
                    System.err.println("___ Sai định dạng, mời nhập lại ___");
                    break;
            }
        }
    }

    public static String hamDaoNguoc(String str) {
        String[] words = str.split(" ");
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reverseTest = new StringBuilder();
        while (!stack.isEmpty()) {
            reverseTest.append(stack.pop()).append(" ");
        }

        return reverseTest.toString().trim();
    }
}
