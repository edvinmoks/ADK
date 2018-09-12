import java.io.*;
import java.lang.*;
import java.util.*;


public class Konkordansen{



    public static void main(String[] args){

      try {


        BufferedReader buf = new BufferedReader(new FileReader("tempdata.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("tempdata.txt"));
        String line = buf.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("hashtable.txt")));
        StringBuilder builder = new StringBuilder();


        String[] firstLine = line.split(" ");
        String word = firstLine[0];
        int indexCounter = 1;

        String tempLine = word+" "+Integer.toString(indexCounter)+"\n";
        System.out.println(tempLine);
        writer.write(word+" "+Integer.toString(indexCounter));

        ArrayList<Integer> ordlista = new ArrayList<Integer>(21000);


        while(line != null){
          indexCounter++;
          String[] tempWord = line.split(" ");
          String firstThree = tempWord[0].substring(0,Math.min(tempWord[0].length(),3));
          if(!firstThree.equals(word)){ //kollar om ord är annorlunda från den andra, isåfall lägg in i hashtabell
            //x=hashfunktion(firstthree).
            tempLine = firstThree+" "+Integer.toString(indexCounter)+"\n"; //format för ABC - INDEX, newline
            //.seek(x)
            writer.write(tempLine); // skriver till filen
            word = firstThree;
          }
          line = buf.readLine();

        }

        indexCounter= 0;
        long st = System.currentTimeMillis();
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        String fw = reader.readLine();
        String[] fw1 = fw.split(" ");
        String fw2 = fw1[0];
        hm.put(fw2,indexCounter);
        while((line = reader.readLine()) != null ){
          indexCounter++;
          String[] tempWord = line.split(" ");
          String firstThree = tempWord[0].substring(0,Math.min(tempWord[0].length(),3));
          if(!firstThree.equals(fw2)){

            hm.put(firstThree,indexCounter);
            fw2= firstThree;}



        }
        long et = System.currentTimeMillis();
        System.out.println(et-st);





        //Skapar en array av alla index i filen L;
        ArrayList<String> tokenizer = new ArrayList<String>();
        BufferedReader reader2 = new BufferedReader(new FileReader("tempdata.txt"));
        String line2;
        int counter2 = 0;
        String[] tempWord2;
        while((line2 = reader2.readLine()) != null ){
          tempWord2 = line2.split(" ");
          tokenizer.add(tempWord2[1]);

        }
        System.out.println("tokenizer: "+tokenizer.get(0));
        reader2.close();




        //Läsa position, skapa mening

        RandomAccessFile raf = new RandomAccessFile("/info/adk18/labb1/korpus", "r");
        int tf = Integer.parseInt(tokenizer.get(0));
        raf.seek(tf-15);
        byte[] tp = {raf.readByte()};
        String bs = new String(tp,"ISO-8859-1");
        for(int i=0; i <=30; i++){
          byte[] tpa = {raf.readByte()};
          bs += new String(tpa,"ISO-8859-1");

        };
        System.out.println(bs);








        buf.close();
        reader.close();
        writer.flush();
        writer.close();
          }


        catch (IOException e){}



    }
}

/*
public class HashTable{

  public static void HashFile(){


    BufferedReader buf = new BufferedReader(new FileReader("tempdata.txt"));
    String line = buf.readLine();
    BufferedWriter writer = new BufferedWriter(new FileWriter("hashtable.txt"));
    String[] firstLine = line.split(" ");

    int indexCounter = 1;
    writer.write(firstLine[0]+" "+Integer.toString(indexCounter));
    while(buf.readline != null){


    }



      }
*/
