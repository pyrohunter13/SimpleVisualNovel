import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game
{
    public static Scanner input = null;
    public static String background = null;
    public static String character = null;
    public static String word = null;
    public static String dialog = "";
    public static String charaName = "";
    public static String c1 = "";
    public static String c2 = "";
    public static String nextWord = "";
    public static String jumpText = "";

    private static JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JLabel background1;
    private JLabel background2;
    private JLabel scene;
    private JLabel chara;
    private JLabel dialogText;
    private JLabel name;
    private JButton startGameButton;
    private JButton exitGameButton;
    private JButton nextButton;
    private JButton option1;
    private JButton option2;

    public static boolean isTrue(String filename){
        try
        {
            input = new Scanner(new File(filename));
            JOptionPane.showMessageDialog(frame,"Success to add " + filename);
            return true;
        }
        catch (FileNotFoundException fe)
        {
            JOptionPane.showMessageDialog(frame,"No File");
            System.out.println("File Not Found!");
            return false;
        }
    }

    Game()
    {
        frame = new JFrame("The Visual Novel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //label for background game menu
        background1 = new JLabel(new ImageIcon("images//game//images//game_menu.png"));
        background1.setBounds(0, 0, 1280, 720);

        background2 = new JLabel(new ImageIcon("images//game//images//main_menu.png"));
        background2.setBounds(0, 0, 1280, 720);

        //label for background game
        scene = new JLabel();
        scene.setBounds(0,0,1280,720);

        //label for character
        chara = new JLabel();
        chara.setBounds(500, 0, 334, 700);

        //label for text
        dialogText = new JLabel();
        dialogText.setOpaque(true);
        dialogText.setBackground(Color.LIGHT_GRAY);
        dialogText.setFont(dialogText.getFont().deriveFont(18f));
        dialogText.setBounds(0, 585 , 1280, 100);

        //label for name
        name = new JLabel();
        name.setOpaque(true);
        name.setBackground(Color.white);
        name.setFont(dialogText.getFont().deriveFont(16f));
        name.setBounds(0, 560, 100, 25 );

        //panel main
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1280, 720);

        //panel for buttons, label, etc
        panel2 = new JPanel();
        panel2.setSize(1280, 720);
        panel2.setLayout(null);


        startGameButton = new JButton("Start Game");
        startGameButton.setLayout(null);
        startGameButton.setBounds(60, 300, 150, 50);


        exitGameButton = new JButton("Exit Game");
        exitGameButton.setLayout(null);
        exitGameButton.setBounds(60, 360, 150, 50);


        nextButton = new JButton("Next");
        nextButton.setLayout(null);
        nextButton.setBounds(0, 0, 150, 50);


        option1 = new JButton(dialog);
        option1.setLayout(null);
        option1.setBounds(250, 250, 700, 50);


        option2 = new JButton(dialog);
        option2.setLayout(null);
        option2.setBounds(250, 350, 700, 50);


        option1.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                while(!word.equals("1"))
                {
                    word = input.next();
                }

                word = input.next();
                nextWord = word;

                while(!word.equals("label"))
                {
                    word = input.next();
                }

                word = input.next();

                while(!word.equals(nextWord))
                {
                    word = input.next();
                }

                nextButton.setVisible(true);
                option1.setVisible(false);
                option2.setVisible(false);
            }
        });


        option2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                while(!word.equals("2"))
                {
                    word = input.next();
                }

                word = input.next();
                nextWord = word;

                while(!word.equals("label"))
                {
                    word = input.next();
                }

                word = input.next();

                while(!word.equals(nextWord))
                {
                    word = input.next();
                }

                nextButton.setVisible(true);
                option1.setVisible(false);
                option2.setVisible(false);
            }
        });

        startGameButton.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                frame.remove(panel);

                ImageIcon iconBg = new ImageIcon("images//game//images//black.jpg");
                scene.setIcon(iconBg);

                panel2.add(nextButton);
                panel2.add(scene);
                frame.add(panel2);
                frame.setVisible(true);
                frame.repaint();
            }
        });

        exitGameButton.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                System.exit(0);
            }
        });


        nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                word = input.next();

                while (!word.equals(".")) {
                    word = input.next();

                    //show background
                    if (word.equals("scene")) {
                        character = "";

                        word = input.next();
                        background = word;
                    }

                    //show character
                    else if (word.equals("show")) {
                        word = input.next();
                        word = input.next();

                        if (word.equals("blue")) {
                            word = input.next();

                            character = "sylvieblue" + word;
                        }
                        else if (word.equals("green")) {
                            word = input.next();

                            character = "sylviegreen" + word;
                        }
                        else if (word.equals("kosong")) {
                            character = word;
                        }
                    }

                    //show text
                    //text narrator
                    else if (word.equals("n")) {
                        word = input.next();
                        dialog = "";
                        charaName = "";
                        while (!word.equals(".")) {
                            dialog = dialog + word + " ";
                            word = input.next();
                        }
                    }

                    //text sylvie
                    else if (word.equals("s")) {
                        word = input.next();
                        dialog = "";
                        charaName = "Sylvie :";
                        while (!word.equals(".")) {
                            dialog = dialog + word + " ";
                            word = input.next();
                        }
                    }

                    //text me
                    else if (word.equals("m")) {
                        word = input.next();
                        dialog = "";
                        charaName = "Me :";
                        while (!word.equals(".")) {
                            dialog = dialog + word + " ";
                            word = input.next();
                        }
                    }

                    //choices
                    else if (word.equals("menu:")) {
                        c1 = "";
                        c2 = "";
                        nextWord = "";

                        word = input.next();

                        while (!word.equals(".")) {
                            word = input.next();
                            c1 = c1 + word + " ";
                        }

                        word = input.next();

                        while (!word.equals(".")) {
                            word = input.next();
                            c2 = c2 + word + " ";
                        }

                        //add c1 & c2 to button
                        option1.setText(c1);
                        option2.setText(c2);

                        //add button to panel
                        panel2.add(option1);
                        panel2.add(option2);

                        nextButton.setVisible(false);
                        option1.setVisible(true);
                        option2.setVisible(true);
                    }

                    //jump part
                    else if (word.equals("jump")) {
                        word = input.next();
                        jumpText = word;
                        word = input.next();

                        while (!word.equals(jumpText)) {
                            word = input.next();
                        }
                    }

                    //end game
                    else if (word.equals("return")) {
                        System.exit(0);
                    }
                }


                //adding file background + character
                ImageIcon iconBg = new ImageIcon("images//game//images//" + background + ".jpg");
                ImageIcon iconChara = new ImageIcon("images//game//images//" + character + ".png");

                //adding background + character + dialog + name to label
                scene.setIcon(iconBg);
                chara.setIcon(iconChara);
                dialogText.setText(dialog);
                name.setText(charaName);

                //adding ^ to panel then frame
                panel2.add(name);
                panel2.add(dialogText);
                panel2.add(chara);
                panel2.add(scene);
                frame.add(panel2);
                frame.repaint();
            }
        });

        panel.add(startGameButton);
        panel.add(exitGameButton);
        panel.add(background2);
        panel.add(background1);
        frame.add(panel);
        frame.setVisible(true);
    }
}