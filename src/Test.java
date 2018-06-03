import Drawing.Drawing;
import board.*;
import Configuration.*;


public class Test {
    public static void main (String[] args ){
        Configuration user_config = new Configuration();
        Configuration.load_from_user(user_config);

        Board gramy = new Board(user_config.getHeight(),user_config.getWidth());
        gramy.loadBoard(user_config.getLoad_detail());
        new Drawing( gramy );

    }
}

