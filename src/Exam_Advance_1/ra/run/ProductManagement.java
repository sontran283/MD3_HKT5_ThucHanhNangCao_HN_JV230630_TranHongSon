package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Float.compare;

public class ProductManagement {
    public static List<Catalog> catalogs = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("**************** JAVA_HACKATHON_05_Exam_Advance_1_MENU *************** \n" +
                    "Chọn 1_ Nhập số danh mục sản phẩm và nhập thông tin các danh mục \n" +
                    "Chọn 2_ Nhập số sản phẩm và nhập thông tin các sản phẩm \n" +
                    "Chọn 3_ Sắp xếp sản phẩm theo giá sản phẩm tăng dần \n" +
                    "Chọn 4_ Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n" +
                    "Chọn 5_ Thoát");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                handleMenu(choice);
            } catch (Exception e) {
                System.err.println("Sai định dạng, mời nhập lại");
            }
        }
    }

    private static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                addCatalog();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                subProduct();
                break;
            case 4:
                searchCatalog();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.err.println("___ Sai định dạng, mời nhập lại ___");
                break;
        }
    }

    private static void addCatalog() {
        System.out.println("nhập số danh mục sản phẩm cần thêm: ");
        try {
            int countCatalog = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < countCatalog; i++) {
                Catalog catalog = new Catalog();
                catalog.inputData(catalogs);
                catalogs.add(catalog);
            }
            System.out.println("kho danh mục sản phâm: ");
            for (int i = 0; i < catalogs.size(); i++) {
                catalogs.get(i).displayData();
            }
        } catch (Exception e) {
            System.err.println("nhập sai định dạng, mời nhập lại");
        }
    }

    private static void addProduct() {
        System.out.println("nhập số sản phẩm cần thêm: ");
        try {
            int countProduct = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < countProduct; i++) {
                Product product = new Product();
                product.inputData(catalogs);
                products.add(product);
            }
            System.out.println("kho sản phẩm: ");
            for (int i = 0; i < products.size(); i++) {
                products.get(i).displayData();
            }
        } catch (Exception e) {
            System.err.println("nhập sai định dạng, mời nhập lại");
        }
    }

    private static void subProduct() {
        products.sort((product1, product2) -> compare(product1.getExportPrice(), product2.getExportPrice()));
        System.out.println("sắp xếp thành công");
        for (int i = 0; i < products.size(); i++) {
            products.get(i).displayData();
        }
    }

    private static void searchCatalog() {
        System.out.println("nhập tên danh mục cần tìm: ");
        String catalogName = scanner.nextLine();
        boolean check = false;
        for (Catalog catalog : catalogs) {
            if (catalog.getCatalogName().equals(catalogName)) {
                catalog.displayData();
                check = true;
            }
        }
        if (!check) {
            System.err.println("không tìm thấy danh mục có tên: " + catalogName);
        }
    }
}
