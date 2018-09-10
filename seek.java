import java.io.*;

public class seek {
   public static void main(String[] args) {

      try {


         // create a new RandomAccessFile with filename test
         RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");

         // write something in the file
         raf.writeUTF("Hello World");
        // set the file pointer at 0 position
         raf.seek(0);

         // print the string
         //System.out.println("" + raf.readUTF());

	raf.seek(50);

	raf.writeUTF("Hello World");

	raf.seek(25);

	raf.writeUTF("Hello World");

	raf.seek(50);

	System.out.println("" + raf.readUTF());



}
catch (IOException ex) {
         ex.printStackTrace();
      }
   }
}
