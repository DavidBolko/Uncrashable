import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

    private static int getFileLines(){
        int lines = 0;
        try{
            File myObj = new File("src/players.txt");
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()){
                lines++;
                reader.nextLine();
            }
            reader.close();
        }catch (FileNotFoundException e){

        }
        return lines;
    }
    public static String[][] getPlayers(){
        int lines = getFileLines();
        String[][] players = new String[lines][3];
        try{
            File myObj = new File("src/players.txt");
            Scanner reader = new Scanner(myObj);
            for (int i = 0; i < lines; i++) {
                players[i] = reader.nextLine().split(":");
            }
            reader.close();
        }catch (FileNotFoundException e){

        }
        return players;
    }
}
