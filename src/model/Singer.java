package model;

import java.util.Scanner;

public class Singer {
    private static int nextSingerId = 1;

    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    // Constructors
    public Singer() {
        this.singerId = nextSingerId++;
    }

    public Singer(String singerName, int age, String nationality, boolean gender, String genre) {
        this();
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    // Getter and Setter methods
    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Tuổi phải lớn hơn 0");
        }
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (nationality != null && !nationality.isEmpty()) {
            this.nationality = nationality;
        } else {
            System.out.println("Quốc tịch không được để trống");
        }
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.isEmpty()) {
            this.genre = genre;
        } else {
            System.out.println("Thể loại không được để trống");
        }
    }

    // Phương thức nhập thông tin từ bàn phím
    public void inputData(Scanner sc) {
        System.out.println("Nhập thông tin của ca sĩ:");
        System.out.print("Tên ca sĩ: ");
        setSingerName(sc.nextLine());

        System.out.print("Tuổi: ");
        setAge(Integer.parseInt(sc.nextLine()));

        System.out.print("Quốc tịch: ");
        setNationality(sc.nextLine());

        System.out.print("Giới tính (Nam/Nữ): ");
        setGender(sc.nextLine().equalsIgnoreCase("Nam"));

        System.out.print("Thể loại: ");
        setGenre(sc.nextLine());
    }

    // Phương thức hiển thị thông tin của ca sĩ
    public boolean displayData() {
        System.out.println("Thông tin của ca sĩ:");
        System.out.println("Mã ca sĩ: " + getSingerId());
        System.out.println("Tên ca sĩ: " + getSingerName());
        System.out.println("Tuổi: " + getAge());
        System.out.println("Quốc tịch: " + getNationality());
        System.out.println("Giới tính: " + (isGender() ? "Nam" : "Nữ"));
        System.out.println("Thể loại: " + getGenre());

        return false;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", gender=" + gender +
                ", genre='" + genre + '\'' +
                '}';
    }
}

