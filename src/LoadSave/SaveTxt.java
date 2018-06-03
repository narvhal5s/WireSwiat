package LoadSave;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveTxt implements Save {
    String filename ;

    public SaveTxt(String filename) {
        this.filename = filename;
    }

    @Override
    public void saveGeneration(int[][] toSave) {
        PrintWriter save = null;
        try {
            save = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0 ; i < toSave.length ; i ++){
            for (int j = 0 ; j < toSave[0].length ; j++){
                save.print(toSave[i][j]);
            }
            save.println();
        }
        save.close();
    }
}
