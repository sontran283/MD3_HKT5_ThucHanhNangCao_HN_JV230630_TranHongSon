package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_Exam_Advance_3 {
    public static void main(String[] args) {
        Queue<String> danhSachPhuHuynh = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("**************** JAVA_HACKATHON_05_Exam_Advance_3_MENU *************** \n" +
                    "Chọn 1_ Nhập tên phụ huynh nộp hồ sơ \n" +
                    "Chọn 2_ Phụ huynh tiếp theo \n" +
                    "Chọn 3_ Thoát");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("nhập tên phụ huynh: ");
                    String tenPhuHuynh = scanner.nextLine();
                    danhSachPhuHuynh.add(tenPhuHuynh);
                    System.out.println(danhSachPhuHuynh);
                    break;
                case 2:
                    if (!danhSachPhuHuynh.isEmpty()) {
                        String phuHuynhTiepTheo = danhSachPhuHuynh.poll();
                        System.out.println("phụ huynh đầu tiên trong danh sách là: " + phuHuynhTiepTheo);
                        System.out.println("___ xoá thành công ___");
                    } else {
                        System.err.println("danh sách phụ huynh trống");
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("___ Sai định dạng, mời nhập lại ___");
                    break;
            }
        } while (luaChon != 3);
    }
}