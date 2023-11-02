package f219419;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TokenizerGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tokenize Example");
        JPanel panel = new JPanel();
        JTextField inputField = new JTextField(20);
        JButton tokenizeButton = new JButton("Tokenize");

        panel.setBackground(Color.CYAN);
        inputField.setBackground(Color.LIGHT_GRAY);
        tokenizeButton.setBackground(Color.PINK);
        tokenizeButton.setForeground(Color.WHITE);

        panel.add(inputField);
        panel.add(tokenizeButton);

        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        tokenizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                String[] words = inputText.split("\\s+");
                JFrame wordFrame = new JFrame("Tokenized Words");
                JPanel wordPanel = new JPanel();
                wordPanel.setBackground(Color.PINK);

                for (String word : words) {
                    JTextField wordField = new JTextField(word, 20);
                    wordField.setBackground(Color.ORANGE);
                    JButton assignRootButton = new JButton("Assign Root");
                    assignRootButton.setBackground(Color.MAGENTA);
                    assignRootButton.setForeground(Color.WHITE);
                    assignRootButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Your logic for assigning the root to the word
                            // For example, you can display a message here
                            JOptionPane.showMessageDialog(null, "Root assigned for " + word);
                        }
                    });
                    wordPanel.add(wordField);
                    wordPanel.add(assignRootButton);
                }

                wordFrame.add(wordPanel);
                wordFrame.setSize(300, 300);
                wordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                wordFrame.setVisible(true);
            }
        });
    }
}
