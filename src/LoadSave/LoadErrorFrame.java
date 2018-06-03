package LoadSave;

import javax.swing.*;

class LoadErrorFrame extends JOptionPane {

    static void printError(String message){
        JOptionPane.showMessageDialog(new JFrame(), message , "Error",  JOptionPane.ERROR_MESSAGE);
    }

}
