import java.io.*;
import java.lang.*;
import java.util.*;


public class Konkordansen{



    public static void main(String[] args){

      try {


        BufferedReader buf = new BufferedReader(new FileReader("tempdata.txt"));
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
            ordlista.add(firstThree.hashCode()%20000,indexCounter);

            System.out.println(ordlista.size());
            writer.write(tempLine); // skriver till filen
            word = firstThree;
          }
          line = buf.readLine();

        }






        buf.close();

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
