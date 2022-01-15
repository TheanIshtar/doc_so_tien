/*
    Doc so tien can thanh toan
    VD: Moi ban nhap so tien (vnd): 987678456
    So tien hang hoa la: 987678456 nghin dong
    So tien can thanh toan la: 987.679.000 VND
    Chin Tram Tam Muoi Bay Trieu Sau Tram Bay Muoi Chin VND!
*/

import java.util.*;

public class doc_so_tien {
    private static int i;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        do {
            System.out.println("Nhap so tien lon hon 999 VND!");
            System.out.print("Moi ban nhap so tien (vnd): ");
            s = in.nextLine();
            if (s.length() < 4)
                System.out.println("Vui long nhap so tien lon hon 999 VND!");
        } while (s.length() < 4);
        while (s.charAt(0) == '0') {
            s = s.substring(1);
        }
        // tach phan so ra khoi xau
        // String number = "";
        int cout = 0;
        // while (cout != 3) {
        // int len = s.length() - 1;
        // s = s.substring(0, len);
        // System.out.println(s);
        // if (s.length() < 3)
        // break;
        // cout++;
        // }
        System.out.println("So tien hang hoa la: " + s + " nghin dong");
        String tien_thua = "";
        // if (s.length() - 1 != '0' || s.length() - 2 != '0' || s.length() - 3 != '0')
        // {
        // s = s.substring(0, (s.length() - 1));
        // }
        if (s.length() < 5) {
            tien_thua = tien_thua + s.substring(s.length() - 3, s.length());
            s = s.substring(0, 1);
        } else {
            tien_thua = tien_thua + s.substring(s.length() - 3, s.length());
            s = s.substring(0, (s.length() - 3));
        }
        // lam tron so tien
        if (tien_thua.charAt(0) != '0' || tien_thua.charAt(1) != '0' || tien_thua.charAt(2) != '0') {
            // s = s.substring(0, s.length() - 1);
            if (s.length() == 1) {
                // char k = tien_thua.charAt(0);
                s = String.valueOf(s.charAt(0) - 48 + 1);
            } else {
                s = s.substring(0, (s.length() - 1)) + String.valueOf(s.charAt(s.length() - 1) - 48 + 1);
            }
        }

        System.out.print("So tien can thanh toan la: ");
        dot_money(s);
        System.out.print(".000 VND");
        System.out.println("");
        read_money(s);
    }
    
    public static void doc_so(char num) {
        // char num;
        switch (num) {
            case '1':
                System.out.print("Mot ");
                break;
            case '2':
                System.out.print("Hai ");
                break;
            case '3':
                System.out.print("Ba ");
                break;
            case '4':
                System.out.print("Bon ");
                break;
            case '5':
                System.out.print("Nam ");
                break;
            case '6':
                System.out.print("Sau ");
                break;
            case '7':
                System.out.print("Bay ");
                break;
            case '8':
                System.out.print("Tam ");
                break;
            case '9':
                System.out.print("Chin ");
                break;
            case '0':
                System.out.print("Khong ");
                break;
        }
    }

    public static void doc_hang_chuc(String s) {
        if (s.charAt(0) == '1') {
            System.out.print("Muoi ");
            if (s.charAt(1) != '0') {
                doc_so(s.charAt(1));
                // doc_so(s.charAt(1));
            }
        } else {
            if (s.charAt(0) == '0') {
                System.out.print("Linh ");
                doc_so(s.charAt(1));
            } else {
                doc_so(s.charAt(0));
                System.out.print("Muoi ");
                if (s.charAt(1) == '5')
                    System.out.print("Lam ");
                else{
                    if (s.charAt(1)!='0'){
                    doc_so(s.charAt(1));    
                    }
                }           
            }
        }
    }

    public static void read_money(String s) {
        String number_temp;
        if (s.length() == 1) {
            doc_so(s.charAt(0));
            System.out.print("nghin dong!");
        } else if (s.length() == 2) {
            doc_hang_chuc(s);
            System.out.print("nghin dong!");
        } else if (s.length() == 3) {
            doc_so(s.charAt(0));
            System.out.print("Tram ");
            if (s.charAt(1) == '0') {
                System.out.print("Linh ");
                doc_so(s.charAt(s.length() - 1));
            } else {
                number_temp = s.substring(1);
                doc_hang_chuc(number_temp);
            }
            System.out.print("nghin dong!");
            // doc_hang_tram(s);
        } else if (s.length() == 4) {
            doc_so(s.charAt(0));
            System.out.print("Trieu ");
            doc_so(s.charAt(1));
            System.out.print("Tram ");
            number_temp = s.substring(2);
            doc_hang_chuc(number_temp);
            System.out.print("nghin dong!");
        } else if (s.length() == 5) {
            doc_hang_chuc(s);
            s = s.substring(2);
            // doc_so(s.charAt(0));
            System.out.print("Trieu ");
            doc_so(s.charAt(0));
            System.out.print("Tram ");
            number_temp = s.substring(1);
            doc_hang_chuc(number_temp);
            System.out.print("nghin dong!");
        } else if (s.length() == 6) {
            doc_so(s.charAt(0));
            System.out.print("Tram ");
            if (s.charAt(1) == '0') {
                System.out.print("Linh ");
                doc_so(s.charAt(2));
            } else {
                number_temp = s.substring(1);
                doc_hang_chuc(number_temp);
            }
            System.out.print("Trieu ");

            number_temp = s.substring(1);
            s = number_temp.substring(2);
            doc_so(s.charAt(0));
            System.out.print("Tram ");
            if (s.charAt(1) == '0') {
                System.out.print("Linh ");
                doc_so(s.charAt(s.length() - 1));
            } else {
                number_temp = s.substring(1);
                doc_hang_chuc(number_temp);
            }
            System.out.print("nghin dong!");
        } else if (s.length() == 7) {
            if (s.charAt(1) > '0' || s.charAt(2) > '0')
                System.out.print("Tren ");
            doc_so(s.charAt(0));

            System.out.print("Ty ");
            System.out.print("VND!");
        } else {
            System.out.print("So tien lon hon 99 Ty VND nen khong doc duoc!");
        }
        // System.out.print("VND!");
    }

    public static void dot_money(String s) {
        // Scanner in = new Scanner(System.in);
        // System.out.print("Moi ban nhap so N: ");
        // int n = in.nextInt();
        // // so N ban dau
        int cout = 0;
        // * dinh dang so thap phan
        // * vd: 12.000.000
        // */
        String number = s;
        for (int i = 0; i < number.length(); i++) {
            if ((number.length() - i) % 3 == 0 && i != 0) {
                System.out.print(".");
            }
            System.out.print(number.charAt(i));
        }
    }

}
