package package_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Main extends Application implements ActionListener {

    static boolean isPlaying = false;

    public static void main(String[] args) {

        JFrame myFrame = new JFrame("Player");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(900, 600);

        FileHandler mySongsFile = new FileHandler("songs_list.dat");

        String path = "C:\\Users\\iTunes Media\\Music\\Amber Mark\\3_33am\\02 Lose My Cool.m4a";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        JPanel controlPanel = new JPanel();
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!isPlaying) {
                    mediaPlayer.play();
                    isPlaying = true;
                } else {
                    mediaPlayer.pause();
                    isPlaying = false;
                }

            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem addItem = new JMenuItem("Add File to Library");
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fc = new JFileChooser();
                int isSelected = fc.showOpenDialog(null);

                if (isSelected == JFileChooser.APPROVE_OPTION) {
                    File newSong = fc.getSelectedFile();
                    FileHandler.copyFile(newSong);
                    System.out.println(newSong.getAbsolutePath());
                    System.out.println(newSong.getPath());
                    System.out.println(newSong.getName());
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        menu.add(addItem);
        menu.add(exitItem);
        menuBar.add(menu);

        JProgressBar slider = new JProgressBar();
        controlPanel.add(playButton);
        controlPanel.add(new JButton("before"));
        controlPanel.add(new JButton("Next"));

        JPanel songlistPanel = new JPanel();
        songlistPanel.setLayout(new FlowLayout());
        songlistPanel.setPreferredSize(new Dimension(600, 300));
        songlistPanel.setBackground(Color.darkGray);

        myFrame.setJMenuBar(menuBar);
        myFrame.add(songlistPanel, BorderLayout.WEST);
        myFrame.add(controlPanel, BorderLayout.SOUTH);
        myFrame.setVisible(true);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
