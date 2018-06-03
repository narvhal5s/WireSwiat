package Configuration;

public class Configuration {
//Poszczególe parametry jakie może podać użytkowanik oraz ich wartość domyślne
    private int width = 100;
    private int height = 100;
    private int gen_counter = 200;
    private String load_type = "Pregenerate structur";
    private String load_detail = "Logic gate";
    private String border = "Connected";
    private boolean generate_gif = false;
    private boolean generate_png = false;
    private String save_to = "Image" ;
    private boolean checker = true ;
    //Obiekt pomocniczy do zatrzymania i wznowienia wykonywania wątku głównego
    private static final class Lock { }

    //Funkcja wczytująca dane od użytkowanika
    public static void load_from_user(Configuration user_config) {
        final Lock lock = new Lock();

        GUI_FOR_CONFIG.loadConfig(user_config, lock);

        synchronized(lock) {
            try {
                    lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//toString napisane do szybkiego podglądu prawidłowości działania
    @Override
    public String toString() {
        return "Configuration{" +
                "width=" + width +
                ", height=" + height +
                ", gen_counter=" + gen_counter +
                ", load_type='" + load_type + '\'' +
                ", load_detail='" + load_detail + '\'' +
                ", border='" + border + '\'' +
                ", generate_gif=" + generate_gif +
                ", generate_png=" + generate_png +
                ", save_to='" + save_to + '\'' +
                ", checker=" + checker +
                '}';
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getGen_counter() {
        return gen_counter;
    }

    public void setGen_counter(int gen_counter) {
        this.gen_counter = gen_counter;
    }

    public String getLoad_type() { return load_type; }

    public void setLoad_type(String load_type) { this.load_type = load_type; }

    public String getLoad_detail() { return load_detail; }

    public void setLoad_detail(String load_detail) { this.load_detail = load_detail; }

    public String getBorder() { return border; }

    public void setBorder(String border) { this.border = border; }

    public boolean isGenerate_gif() { return generate_gif; }

    public void setGenerate_gif(boolean generate_gif) { this.generate_gif = generate_gif; }

    public boolean isGenerate_png() { return generate_png; }

    public void setGenerate_png(boolean generate_png) { this.generate_png = generate_png; }

    public String getSave_to() { return save_to; }

    public void setSave_to(String save_to) { this.save_to = save_to; }

    public boolean isChecker() { return checker; }

    public void setChecker(boolean checker) { this.checker = checker; }

}
