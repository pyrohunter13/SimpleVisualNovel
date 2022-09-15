import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EngineMenu extends JFrame
{
    public static String filename;
    public static int helpPage = 1;
    private static JPanel panel;
    private static JTextField textField;
    private static JLabel background;
    private static JLabel info;
    private static JButton startEngineButton;
    private static JButton exitEngineButton;
    private static JButton helpButton;
    private static ImageIcon iconBg;
    private static JButton helpNext;
    private static JButton helpPrev;
    private static JButton backToMainMenu;
    private static JLabel [] help;
    private static ImageIcon [] iconHelp;

    EngineMenu()
    {
        setTitle("Engine Menu");
        setLocation(50,50);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1280, 720);

        textField = new JTextField();
        textField.setToolTipText("Only Accepts .txt!");
        textField.setBounds(1025, 430 , 200, 30);

        background = new JLabel();
        iconBg = new ImageIcon("images//engine_menu.jpg");
        background.setIcon(iconBg);
        background.setBounds(0,0,1280,720);

        help = new JLabel[7];
        iconHelp = new ImageIcon[7];

        info = new JLabel("Input your script below, ex : script.txt ");
        info.setOpaque(true);
        info.setBackground(Color.CYAN);
        info.setFont(info.getFont().deriveFont(12f));
        info.setBounds(1020, 395, 215, 30);

        startEngineButton = new JButton("Start Engine");
        startEngineButton.setLayout(null);
        startEngineButton.setBounds(1025, 475, 200, 50);

        helpButton = new JButton("Help");
        helpButton.setLayout(null);
        helpButton.setBounds(1025, 530, 200, 50);

        exitEngineButton = new JButton("Exit Engine");
        exitEngineButton.setLayout(null);
        exitEngineButton.setBounds(1025, 585, 200, 50);

        helpNext = new JButton("Next");
        helpNext.setLayout(null);
        helpNext.setBounds(1080, 84, 200, 50);

        helpPrev = new JButton("Previous");
        helpPrev.setLayout(null);
        helpPrev.setBounds(0, 84, 200, 50);

        backToMainMenu = new JButton("Main Menu");
        backToMainMenu.setLayout(null);
        backToMainMenu.setBounds(550, 36, 200, 50);

        helpNext.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                helpPage++;
                helpPrev.setVisible(true);
                if(helpPage == 7)
                {
                    helpNext.setVisible(false);
                }
                else
                {
                    helpNext.setVisible(true);
                }
                panelActive(helpPage);
            }
        });

        helpPrev.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                helpPage--;

                if (helpPage == 1)
                {
                    helpPrev.setVisible(false);
                }
                else if (helpPage < 7)
                {
                    helpNext.setVisible(true);
                }
                else
                {
                    helpPrev.setVisible(true);
                }
                panelActive(helpPage);
            }

        });


        backToMainMenu.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                mainPanel();
            }
        });


        startEngineButton.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                filename = textField.getText();

                if(Game.isTrue(filename)){
                    new Game();
                }
            }
        });


        helpButton.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                panelHelp();
            }
        });

        exitEngineButton.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                System.exit(0);
            }
        });

        panel.add(info);
        panel.add(textField);
        panel.add(helpButton);
        panel.add(startEngineButton);
        panel.add(exitEngineButton);
        panel.add(background);
        add(panel);
        setVisible(true);
    }


    public static void panelActive(int i){
        if(i == 1)
        {
            help[i].setVisible(false);
            help[i-1].setVisible(true);
        }
        else if(i == 7)
        {
            help[i-2].setVisible(false);
            help[i-1].setVisible(true);
        }
        else if(i < 7)
        {
            help[i-1].setVisible(true);
            help[i].setVisible(false);
            help[i-2].setVisible(false);
        }

    }

    public static void mainPanel(){
        helpNext.setVisible(false);
        helpPrev.setVisible(false);
        backToMainMenu.setVisible(false);
        for(int i = 0; i < 7; i++)
        {
            help[i].setVisible(false);
        }

        iconBg = new ImageIcon("images//engine_menu.jpg");
        background.setIcon(iconBg);

        info.setVisible(true);
        startEngineButton.setVisible(true);
        exitEngineButton.setVisible(true);
        textField.setVisible(true);
        helpButton.setVisible(true);
        background.setVisible(true);
    }

    public static void panelHelp(){
        helpPage = 1;
        info.setVisible(false);
        startEngineButton.setVisible(false);
        exitEngineButton.setVisible(false);
        textField.setVisible(false);
        helpButton.setVisible(false);
        background.setVisible(false);

        helpNext.setVisible(true);
        backToMainMenu.setVisible(true);
        backToMainMenu.setVisible(true);
        helpPrev.setVisible(false);

        panel.add(backToMainMenu);
        panel.add(helpNext);
        panel.add(helpPrev);
        for(int i = 0; i < 7; i++)
        {
            int real = i +1;
            help[i] = new JLabel("Ini panel " + real);
            iconHelp[i] = new ImageIcon("images//help_menu" + real + ".jpg");
            help[i].setIcon(iconHelp[i]);
            help[i].setBounds(0, 0 , 1280, 720);
            help[i].setVisible(false);
            panel.add(help[i]);
        }
        panelActive(1);
        panel.setVisible(true);
    }
}