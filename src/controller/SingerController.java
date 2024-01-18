package controller;

import service.SingerService;

import java.util.Scanner;

public class SingerController {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        SingerService service=new SingerService();
        while (true){
            System.out.println("**********************SINGER-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữ\n" +
                    "liệu nhập vào) \n" +
                    "2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ \n" +
                    "3.Thay đổi thông tin ca sĩ theo mã id \n" +
                    "4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)\n" +
                    "5.Thoát\n");
            System.out.println("nhập lựa chọn");
            int choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    service.addSinger(sc);
                    break;
                case 2:
                    service.displayAll();
                    break;
                case 3:
                    service.updateById(sc);
                    break;
                case 4:
                    service.deleteById(sc);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("nhập sai giá trị");
            }
        }
    }
}
