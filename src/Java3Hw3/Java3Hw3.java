package Java3Hw3;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Java3Hw3 {
    public static void main(String[] args) throws Exception {
        //Чтение и вывод файла в консоль
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./src/Java3Hw3/Hw3Array.txt"));
        byte[] bytes = new byte[1];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) bis.read();
        }
        bis.close();
        for (byte b : bytes) {
            System.out.println(b + " ");
        }
        //Склейка нескольких файлов в один
        ArrayList<FileInputStream> arrayList = new ArrayList<>();
        arrayList.add(new FileInputStream("./src/Java3Hw3/Hw3Array.txt"));
        arrayList.add(new FileInputStream("./src/Java3Hw3/Hw3Array.txt"));
        arrayList.add(new FileInputStream("./src/Java3Hw3/Hw3Array.txt"));
        arrayList.add(new FileInputStream("./src/Java3Hw3/Hw3Array.txt"));
        arrayList.add(new FileInputStream("./src/Java3Hw3/Hw3Array.txt"));
        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(arrayList));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("./src/Java3Hw3/Hw3Array2.txt"));
        int x;
        while ((x = sequenceInputStream.read()) != -1) {
            bufferedOutputStream.write(x);
        }
        sequenceInputStream.close();
        bufferedOutputStream.close();
        System.out.println("Файлы склееены в новый файл Hw3Array2");
        //Консольное приложение для чтения файлов
        FileInputStream fileInputStream = new FileInputStream("./src/Java3Hw3/manypages.txt");
        RandomAccessFile raf = new RandomAccessFile("./src/Java3Hw3/manypages.txt", "r");
        int listSize = 1800;
        System.out.println("Всего страниц в книге - " + fileInputStream.available() + ". На какую перейти?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int ourList = Integer.parseInt(bufferedReader.readLine());
        raf.seek(ourList * listSize);
        for (int i = 0; i < listSize; i++) {
            System.out.println(raf.read());
        }
        raf.close();

    }
}
