import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                String[] line = reader.nextLine().split(":");
                players[i] = line;
                System.out.println(line[0]);
            }
            reader.close();
        }catch (FileNotFoundException e){

        }
        return players;
    }

    public static void savePlayer(String playerInformation){
        File file = new File("src/players.txt");
        try (FileWriter fr = new FileWriter(file, true);) {
            fr.write(playerInformation + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
