package service;

import model.Singer;

import java.util.Scanner;

public class SingerService {
    Singer[] singers=new Singer[0];
    //thêm ca sĩ
    public void addSinger(Scanner sc){
        System.out.println("nhập số ca sĩ cần thêm");
        int n= Integer.parseInt(sc.nextLine());
        Singer[] newSingers=new Singer[singers.length+n];
        for (int i = 0; i < singers.length; i++) {
            newSingers[i]=singers[i];
        }
        for (int i = 0; i <n; i++) {
            Singer newSinger=new Singer();
            newSinger.inputData(sc);
            newSingers[singers.length+i]=newSinger;
        }
        singers=newSingers;
        System.out.println("danh sach");
        displayAll();
    }
    //hiển thị danh sách ca sĩ
    public void displayAll(){
        if (singers.length==0){
            System.out.println("danh sách rỗng");
        }else{
            for (int i = 0; i < singers.length; i++) {
                System.out.println(singers[i].displayData());
            }
        }
    }
    //tìm vị trí theo id
    public int findIndex(Singer[] arr, int id) {
        int index = -1;
        for (int i = 0; i < singers.length; i++) {
            if (singers[i].getSingerId() == id) {
                index = i;
            }
        }

        return index;
    }
    //thay đổi thông tin ca sĩ theo id
    public void updateById(Scanner sc){
        System.out.println("nhập id ca sĩ cần thay đổi");
        int id= Integer.parseInt(sc.nextLine());
        int index=findIndex(singers,id);
        if(index==-1){
            System.out.println("nhập sai id ca sĩ");
        }else{
            Singer singer=new Singer();
            singer.inputData(sc);
            singers[index]=singer;
            System.out.println("đã thay đổi");

        }

    }
    public void deleteById(Scanner sc){
        System.out.println("nhập id ca sĩ cần xóa");
        int id= Integer.parseInt(sc.nextLine());
        int index=findIndex(singers,id);
        if(index==-1){
            System.out.println("nhập sai id ca sĩ");
        }else{
            Singer[] singers1=new Singer[singers.length-1];
            for (int i = 0; i < singers.length; i++) {
                if (i<index){
                    singers1[i]=singers[i];
                }
                if (i>index){
                    singers1[i-1]=singers[i];
                    System.out.println("xóa thành công");
                    displayAll();
                }
            }

        }

    }
    public Singer[] getListSingger(){
        return singers;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingerService singerService = new SingerService();

        // Bạn có thể gọi các phương thức hoặc thực hiện các hành động khác ở đây
        singerService.addSinger(scanner);
    }

}
