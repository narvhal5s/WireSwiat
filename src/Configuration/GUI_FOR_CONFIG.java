package Configuration;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class GUI_FOR_CONFIG {
    //Obiekty bibloteki swing obecne w oknie wprowadzania ustawień
    private JPanel panel1;
    private JTextField widthText;
    private JTextField heightText;
    private JTextField gencounterText;
    private JLabel description2;
    private JLabel description1;
    private JLabel description3;
    private JButton OKButton;
    private JLabel errwidth;
    private JLabel errheight;
    private JLabel errgencounter;
    private JComboBox loadtypbox;
    private JTextField loaddetailText;
    private JLabel description4;
    private JLabel errloaddetail;
    private JLabel description5;
    private JLabel description6;
    private JComboBox borderbox;
    private JLabel description7;
    private JLabel description8;
    private JLabel description9;
    private JComboBox gengifbox;
    private JComboBox genpngbox;
    private JComboBox savetobox;
    private JLabel errorchecker;

    //Wewnętrzna pakietowa metoda wczytywania ustawień, wywołuje nowe okno
    static void loadConfig(Configuration user_config, Object lock) {
        JFrame frame = new JFrame("GUI_FOR_CONFIG");
        frame.setContentPane(new GUI_FOR_CONFIG(user_config, lock).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    //Obsługa zdarzeń w oknie ustawień,
    //Kolejne przesłonione metody mają za zadnie weryfikować na żywo poprawność wprowadzanych argumentów
    private GUI_FOR_CONFIG(Configuration user_config, Object lock) {
        widthText.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (widthText.getText().matches("\\d+") != true) {
                    errwidth.setText("Wrong character, use number only");
                    user_config.setChecker(false);
                } else if (Integer.parseInt(widthText.getText()) < 0 || Integer.parseInt(widthText.getText()) > 1000) {
                    errwidth.setText("Wrong value, insert number from 1 to 1000");
                    user_config.setChecker(false);
                } else {
                    errwidth.setText("Valid argument");
                    user_config.setChecker(true);
                }
            }
        });
        heightText.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (heightText.getText().matches("\\d+") != true) {
                    errheight.setText("Wrong character, use number only");
                    user_config.setChecker(false);
                } else if (Integer.parseInt(heightText.getText()) < 0 || Integer.parseInt(heightText.getText()) > 1000) {
                    errheight.setText("Wrong value, insert number from 1 to 1000");
                    user_config.setChecker(false);
                } else {
                    errheight.setText("Valid argument");
                    user_config.setChecker(true);
                }
            }
        });
        gencounterText.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!gencounterText.getText().matches("\\d+")) {
                    errgencounter.setText("Wrong character, use number only");
                    user_config.setChecker(false);
                } else if (Integer.parseInt(gencounterText.getText()) < 0 || Integer.parseInt(gencounterText.getText()) > 1000) {
                    errgencounter.setText("Wrong value, insert number from 1 to 1000");
                    user_config.setChecker(false);
                } else {
                    errgencounter.setText("Valid argument");
                    user_config.setChecker(true);
                }
            }
        });
        //Tutaj następuje wpisanie podanych argumantów do podanego obiektu klasy Configuration
        //Jeśli któryś argumnt wprowadzono błędnie nie ma możliwości zapisu argumentów
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user_config.isChecker()) {

                    user_config.setWidth(Integer.parseInt(widthText.getText()));

                    user_config.setHeight(Integer.parseInt(heightText.getText()));

                    user_config.setGen_counter(Integer.parseInt(gencounterText.getText()));

                    user_config.setLoad_type(loadtypbox.getSelectedItem().toString());

                    user_config.setLoad_detail(loaddetailText.getText());

                    user_config.setBorder(borderbox.getSelectedItem().toString());

                    if (genpngbox.getSelectedItem().toString() == "Yes")
                        user_config.setGenerate_gif(true);
                    else
                        user_config.setGenerate_gif(false);

                    if (loadtypbox.getSelectedItem().toString() == "Yes")
                        user_config.setGenerate_png(true);
                    else
                        user_config.setGenerate_png(false);

                    user_config.setSave_to(savetobox.getSelectedItem().toString());
                    synchronized (lock) {
                        lock.notify();
                    }
                } else {
                    errorchecker.setText("Insert valid arguments first");
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(15, 3, new Insets(2, 2, 2, 2), -1, -1));
        panel1.setPreferredSize(new Dimension(400, 400));
        description1 = new JLabel();
        Font description1Font = this.$$$getFont$$$(null, -1, -1, description1.getFont());
        if (description1Font != null) description1.setFont(description1Font);
        description1.setText("Width:");
        panel1.add(description1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        description2 = new JLabel();
        Font description2Font = this.$$$getFont$$$(null, -1, -1, description2.getFont());
        if (description2Font != null) description2.setFont(description2Font);
        description2.setText("Height:");
        panel1.add(description2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        description3 = new JLabel();
        Font description3Font = this.$$$getFont$$$(null, -1, -1, description3.getFont());
        if (description3Font != null) description3.setFont(description3Font);
        description3.setText("Gen Counter:");
        panel1.add(description3, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        widthText = new JTextField();
        widthText.setText("5");
        panel1.add(widthText, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 15), new Dimension(150, -1), null, 0, false));
        gencounterText = new JTextField();
        gencounterText.setText("200");
        panel1.add(gencounterText, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 15), new Dimension(150, -1), null, 0, false));
        heightText = new JTextField();
        heightText.setText("5");
        panel1.add(heightText, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 15), new Dimension(150, -1), null, 0, false));
        OKButton = new JButton();
        OKButton.setText("OK");
        panel1.add(OKButton, new com.intellij.uiDesigner.core.GridConstraints(14, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errwidth = new JLabel();
        errwidth.setText("");
        panel1.add(errwidth, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(502, 0), null, 0, false));
        errheight = new JLabel();
        errheight.setText("");
        panel1.add(errheight, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(502, 0), null, 0, false));
        errgencounter = new JLabel();
        errgencounter.setText("");
        panel1.add(errgencounter, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(502, 0), null, 0, false));
        loadtypbox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Text file");
        loadtypbox.setModel(defaultComboBoxModel1);
        panel1.add(loadtypbox, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loaddetailText = new JTextField();
        loaddetailText.setText("D:\\java_project\\testy_okien\\src\\data.txt");
        panel1.add(loaddetailText, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 15), new Dimension(150, -1), null, 0, false));
        description4 = new JLabel();
        description4.setText("Load type:");
        panel1.add(description4, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errloaddetail = new JLabel();
        errloaddetail.setText("");
        panel1.add(errloaddetail, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        description5 = new JLabel();
        description5.setText("Load detail:");
        panel1.add(description5, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        borderbox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Not connected");
        borderbox.setModel(defaultComboBoxModel2);
        panel1.add(borderbox, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        description6 = new JLabel();
        description6.setText("Border:");
        panel1.add(description6, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        description7 = new JLabel();
        description7.setText("Generate_gif:");
        panel1.add(description7, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        description8 = new JLabel();
        description8.setText("Generate_png:");
        panel1.add(description8, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        description9 = new JLabel();
        description9.setText("Save_to:");
        panel1.add(description9, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gengifbox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("No");
        gengifbox.setModel(defaultComboBoxModel3);
        panel1.add(gengifbox, new com.intellij.uiDesigner.core.GridConstraints(10, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genpngbox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("No");
        defaultComboBoxModel4.addElement("Yes");
        genpngbox.setModel(defaultComboBoxModel4);
        panel1.add(genpngbox, new com.intellij.uiDesigner.core.GridConstraints(11, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        savetobox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("Text file");
        savetobox.setModel(defaultComboBoxModel5);
        panel1.add(savetobox, new com.intellij.uiDesigner.core.GridConstraints(12, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorchecker = new JLabel();
        errorchecker.setText("");
        panel1.add(errorchecker, new com.intellij.uiDesigner.core.GridConstraints(13, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}





