package WarungMakan;
import java.util.Scanner;
public class BismillahUAS2 {
    static int hitungharga(int hargasatuan, int jumlah){
        int harga = hargasatuan*jumlah;
        return harga;   
    }
    static String[][] sort(String[]menu, int[]harga, int jumlah){
        String[][]hasilsorting = new String [15][2];
        //urutkan menggunakan bubble sort        
        for (int i = 0; i < jumlah; i++) {
            for (int j = 0; j < jumlah-1; j++) {
                if(menu[j].compareToIgnoreCase(menu[j+1])>0){
                    String t = menu[j];
                    menu[j] = menu[j+1];
                    menu[j+1] = t;
                    int h = harga[j];
                    harga[j] = harga[j+1];
                    harga[j+1] = h;
                }    
            }
        }
        for (int i = 0; i < jumlah; i++) {
            hasilsorting[i][0] = menu[i];
            hasilsorting[i][1] = String.valueOf(harga[i]);
        }
        return hasilsorting;
    }
    static String[][] search(String[] menu, int harga[], String cari, int jumlah){
        String[][] hasil=new String[15][2];
        int index = 0;                    
        for (int i = 0; i < jumlah; i++) {
            if (menu[i].indexOf(cari)>=0){
            hasil[index][0]= menu[i];
            hasil[index][1]= String.valueOf(harga[i]);
            index++;
            }                        
        }
        return hasil;
    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String beli[][] = new String [10][2];
            int jumlahbeli=0, grandtotal=0, bayar, kembalian;
            int porsi[] = new int[10];
            int subtotal[] = new int[10];
            int jumlah = 5;
            
            //inisialisasi array makanan
            String makanan[] = new String[15];
            int hargamakanan[] = new int[15];
            makanan[0]="Pecel       "; hargamakanan[0]=7000;
            makanan[1]="Bakso       "; hargamakanan[1]=10000;
            makanan[2]="Rawon       "; hargamakanan[2]=20000;
            makanan[3]="Soto        "; hargamakanan[3]=15000;
            makanan[4]="Sate        "; hargamakanan[4]=14000;
            
            
            int pilihuser=0;
            do{
                System.out.println("=========================================================");
                System.out.println("======  SELAMAT DATANG DI WARUNG MAKAN SEDERHANA  =======");
                System.out.println("\nPilihan USER");
                System.out.println("1. Kasir");
                System.out.println("2. Admin");
                System.out.println("3. Owner");
                System.out.println("4. Exit");
                System.out.print("\nPilih         : ");
                pilihuser = sc.nextInt();
                switch(pilihuser){
                    case 1:
                        int kasir=0;
                        do{
                            System.out.println("\n------------------------  KASIR  -----------------------\n");
                            System.out.println("Tetap di kasir?");
                            System.out.println("1. Ya");
                            System.out.println("2. Tidak");
                            System.out.print("\nPilih         : ");
                            kasir = sc.nextInt();
                        int user1=0;
                        if(kasir==1){
                        do{
                            System.out.println("\n------------------------  KASIR  -----------------------\n");
                            System.out.println("1. Daftar Makanan");
                            System.out.println("2. Cari Makanan");
                            System.out.println("3. Selesaikan Pesanan");
                            System.out.print("\nPilih         : ");
                            user1 = sc.nextInt();
                            switch(user1){
                                case 1:
                                    String[][] urut=sort(makanan,hargamakanan,jumlah);
                                    System.out.println("\n----------------  DAFTAR  MENU MAKANAN  ----------------\n");
                                    System.out.println("No.\tMenu Makanan\tHarga");
                                    int index=0;
                                    for (int i = 0; i < jumlah; i++) {
                                        System.out.println(((i+1)+". "+urut[i][0]+"\t\tRp "+urut[i][1]));
                                        index++;
                                    }
                                    System.out.println((index+1)+". Selesai");
                                    int pilih2=0;
                                    do{
                                        System.out.print("\nPilih         : "); 
                                        pilih2 = sc.nextInt();
                                        if(pilih2!=index+1){   
                                        beli[jumlahbeli][0]=urut[pilih2-1][0];
                                        beli[jumlahbeli][1]=String.valueOf(urut[pilih2-1][1]);
                                        System.out.print("Jumlah porsi  : ");
                                        porsi[jumlahbeli]=sc.nextInt();
                                        subtotal[jumlahbeli] = hitungharga (Integer.parseInt(beli[jumlahbeli][1]),porsi[jumlahbeli]);
                                        grandtotal=grandtotal+subtotal[jumlahbeli];
                                        jumlahbeli++;
                                        }                               
                                    }while(pilih2!=index+1); 
                                     
                                    break;
                                case 2:
                                    System.out.println("\n---------------  PENCARIAN  MENU MAKANAN  --------------\n");
                                    System.out.print("Cari          : "); 
                                    String cari = sc.next();
                                    System.out.println("\n              -----  Hasil Pencarian  -----            \n");
                                    System.out.println("No.\tMenu Makanan\t\tHarga");
                                    String hasilcari[][] = search(makanan,hargamakanan,cari, jumlah);
                                    int index1=0;
                                    for (int i = 0; i < hasilcari.length; i++) {
                                        if(hasilcari[i][0]!=null){
                                            System.out.println((i+1)+". "+hasilcari[i][0]+"\t\tRp "+Integer.parseInt(hasilcari[i][1]));
                                            index1++;
                                        }
                                    }
                                    System.out.println((index1+1)+". Selesai");
                                    int pilih3=0;
                                    do{
                                        System.out.print("\nPilih         : "); 
                                        pilih3 = sc.nextInt();
                                        if(pilih3!=index1+1){   
                                        beli[jumlahbeli][0]=hasilcari[pilih3-1][0];
                                        beli[jumlahbeli][1]=String.valueOf(hasilcari[pilih3-1][1]);
                                        System.out.print("Jumlah porsi  : ");
                                        porsi[jumlahbeli]=sc.nextInt();
                                        subtotal[jumlahbeli] = hitungharga (Integer.parseInt(beli[jumlahbeli][1]),porsi[jumlahbeli]);
                                        grandtotal=grandtotal+subtotal[jumlahbeli];
                                        jumlahbeli++;
                                        }                               
                                    }while(pilih3!=index1+1); 
                                    
                                    break;
                                case 3:
                                    System.out.println("Selesai");
                                    
                                    break;
                            }
                              
                        }while(user1!=3);
                        System.out.println("\n-------------------  DAFTAR PESANAN  -------------------\n");
                        System.out.println("No. Makanan"+"\t\t"+"Harga"+"\t     "+"Jumlah"+"\t"+"Total");
                        for (int i = 0; i < jumlahbeli; i++) {
                            System.out.println((i+1)+".  "+beli[i][0]+"\t"+beli[i][1]+"\t\t"+porsi[i]+"\tRp "+subtotal[i]);
                            }
                        System.out.println("\nTotal yang harus dibayar                      : Rp "+grandtotal);
                        System.out.print("Uang Tunai                                    : Rp ");
                        bayar = sc.nextInt();
                        kembalian = bayar - grandtotal;
                        System.out.println("Uang Kembalian                                : Rp "+kembalian);
                        System.out.println("\n=====================  Terimakasih  ====================\n");  
                        }                        
                        
                        }while(kasir!=2);
                        break;
                    case 2:
                        int user2=0;
                        do{
                            System.out.println("\n------------------------  ADMIN  --------------------\n");
                            System.out.println("1. Tambah Menu");
                            System.out.println("2. Hapus Menu");
                            System.out.println("3. Tampilkan Menu");
                            System.out.println("4. Keluar dari Admin");
                            System.out.print("\nPilih         : ");
                            user2=sc.nextInt();
                            switch(user2){
                                case 1:
                                    System.out.println("\n---------------------  TAMBAH MENU  --------------------\n");
                                    System.out.print("Nama            : ");                                    
                                    makanan[jumlah] = sc.next();
                                    System.out.print("Harga           : ");
                                    hargamakanan[jumlah] = sc.nextInt();
                                    System.out.println("Penambahan Sukses");
                                    jumlah++;
                                    break;
                                case 2:
                                    System.out.println("\n---------------------  HAPUS MENU  --------------------\n");
                                    System.out.print("Nama            : ");  
                                    String nama = sc.next();
                                    boolean ketemu = false;
                                    int idk = -1;
                                    for (int i = 0; i < jumlah; i++) {
                                        
                                        if(makanan[i].compareToIgnoreCase(nama)==0){
                                            ketemu = true;
                                            idk = i;
                                            break;
                                        }
                                    }
                                    if(ketemu==false){
                                        System.out.println("Menu Tidak Ada");
                                    }else{
                                        //mengubah isi array data master
                                        for (int i = idk; i < jumlah-1; i++) {
                                            makanan[i]=makanan[i+1];
                                            hargamakanan[i]=hargamakanan[i+1];
                                            
                                        }
                                        System.out.println("Penghapusan Sukses");
                                        jumlah--;
                                    }
                                    break;
                                case 3:
                                    String[][] urut=sort(makanan,hargamakanan,jumlah);
                                    System.out.println("\n----------------  DAFTAR  MENU MAKANAN  ----------------\n");
                                    System.out.println("No.\tMenu Makanan\tHarga");
                                    int index=0;
                                    for (int i = 0; i < jumlah; i++) {
                                        System.out.println(((i+1)+". "+urut[i][0]+"\t\tRp "+urut[i][1]));
                                        index++;
                                    }
                                    break;
                            }
                                 
                                        
                        }while(user2!=4);
                        break;
                    case 3:
                        int user3=0;
                        do{
                            System.out.println("\n------------------------  OWNER  --------------------\n");
                            System.out.println("1. Daftar Penjualan");                            
                            System.out.println("2. Keluar dari Owner");
                            System.out.print("\nPilih         : ");
                            user3=sc.nextInt();
                            switch(user3){
                                case 1:
                                    
                                    System.out.println("\n------------------  DAFTAR PENJUALAN  ------------------\n");
                                    System.out.println("No. Makanan"+"\t\t"+"Harga"+"\t     "+"Jumlah"+"\t"+"Total");
                                    for (int i = 0; i < jumlahbeli; i++) {
                                        System.out.println((i+1)+".  "+beli[i][0]+"\t"+beli[i][1]+"\t\t"+porsi[i]+"\tRp "+subtotal[i]);
                                    }
                                    System.out.println("\nTotal Penjualan                               : Rp "+grandtotal);
                                    break;
                                case 2:

                                    break;
                            }
                        }while(user3!=2);
                        break;
                }
            }while(pilihuser!=4);
        }
}
