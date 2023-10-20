package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;
import Exam_Advance_1.ra.run.ProductManagement;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private static int idCountProduct = 1;
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
        this.productId = idCountProduct++;
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public static int getIdCountProduct() {
        return idCountProduct;
    }

    public static void setIdCountProduct(int idCountProduct) {
        Product.idCountProduct = idCountProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(List<Catalog> catalogs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("___ Nhập thông tin sản phẩm ___");

        System.out.println("nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();

        System.out.println("nhập tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();

        System.out.println("nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();

        System.out.println("nhập giá importPrice sản phẩm: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        System.out.println("danh sách Catalog");
        for (int i = 0; i < catalogs.size(); i++) {
            System.out.println((i + 1) + "_ " + catalogs.get(i).getCatalogName());
        }
        System.out.println("mời nhập STT để chọn danh mục: ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n >= 1 && n <= catalogs.size()) {
            this.catalog = catalogs.get(n - 1);
        } else {
            System.err.println("không có danh mục để chọn");
            Catalog newCatalog = new Catalog();
            System.out.println("thêm danh mục");
            newCatalog.inputData(catalogs);
            ProductManagement.catalogs.add(newCatalog);
            this.catalog = newCatalog;
            return;
        }

        System.out.println("""
                nhập trạng thái sản phẩm: 
                1_true   2_false
                """);
        this.productStatus = Integer.parseInt(scanner.nextLine()) == 1;

        this.exportPrice = this.importPrice * this.RATE;
    }

    @Override
    public void displayData() {
        System.out.println(
                "Product{" +
                        "productId=" + productId +
                        ", productName='" + productName + '\'' +
                        ", catalog=" + catalog.getCatalogName() +
                        ", exportPrice=" + exportPrice +
                        ", Boolean=" + productStatus +
                        "} " + super.toString()
        );
    }
}
