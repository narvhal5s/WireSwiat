package LoadSave;

import javax.xml.stream.events.Characters;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadingText implements Load {
    int width, height;

    public LoadingText(int height, int width) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int[][] loadGeneration(String loadfrom) {

        //Utworzenia skanera na podany plik

        Scanner txtload = null;
        try {
            txtload = new Scanner(new FileReader(loadfrom));
        } catch (FileNotFoundException e) {
            System.out.print("Wrong file name or path\n");
            LoadErrorFrame.printError("Wrong file name or path\n");
        }

        //Lista do przechowania kolejnych wierszy pliku, do celów diagnostycznych
        List<String> data = new ArrayList<>();

        while (txtload.hasNextLine()) {
            data.add(txtload.nextLine());
        }

        //Sprawdzenie wyskości
        try {
            if (data.size() != height) {
                throw new MyLoadException();
            }
        }catch (MyLoadException e){
            LoadErrorFrame.printError("Given height doesn't match height in file: " + loadfrom);
            System.exit(1);
        }

        try {
            //Sprawdzenie czy wiersze są jednakowej długości
            for (int i = 1; i < data.size(); i++) {
                if (data.get(0).length() != data.get(i).length()) {
                    throw new MyLoadException( );
                }
            }
        } catch (MyLoadException e) {
            LoadErrorFrame.printError("Rows lenghts doesn's match in file: " + loadfrom);
            System.exit(1);
        }

            //Utworzenie tablicy zwracanej jako wynik, sprawdzanie poprawności

            int[][] loadarray = new int[data.size()][data.get(0).length()];
            int column = 0;
            for (int i = 0; i < data.size(); i++) {
                for (int j = 0; j < data.get(i).length(); j++) {
                    if (Character.isDigit(data.get(i).charAt(j))) {
                        loadarray[i][column] = Character.getNumericValue(data.get(i).charAt(j));
                        column++;
                    }
                }

                try {
                    if (column != width) {
                        throw new MyLoadException();
                    }
                }catch( MyLoadException e ){
                    LoadErrorFrame.printError("Unexpected character in row" + i + " in file: " + loadfrom);
                    System.exit(1);
                }

                column = 0;
            }

            return loadarray;

    }
}
