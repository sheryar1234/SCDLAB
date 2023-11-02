package lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PoemEditor {
    private JTextArea textArea;
    private JComboBox<String> rootsDropdown; 
    private String selectedRoot = null;

    public PoemEditor() {
        JFrame frame = new JFrame("Poem Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        textArea = new JTextArea(10, 30);
        JButton tokenizeButton = new JButton("Tokenize");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(textArea);
        panel.add(tokenizeButton);

        frame.add(panel);

        tokenizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                StringTokenizer tokenizer = new StringTokenizer(text);

                JFrame tokenizedFrame = new JFrame("Tokenized Words");
                tokenizedFrame.setLayout(new FlowLayout());

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    JTextField textField = new JTextField(token, 20);
                    textField.setEditable(false);

              
                    JButton rootButton = new JButton("Assign Root");
                    rootButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                     
                            textField.setText(token + " (Root: " + selectedRoot + ")");
                        }
                    });

                
                    JPanel wordPanel = new JPanel();
                    wordPanel.setLayout(new BorderLayout());
                    wordPanel.add(rootButton, BorderLayout.NORTH);
                    wordPanel.add(textField, BorderLayout.CENTER);

                    tokenizedFrame.add(wordPanel);
                }

           
                rootsDropdown = new JComboBox<>();
                tokenizedFrame.add(rootsDropdown);

          
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Roots.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] words = line.split("\\s+");
                        for (String word : words) {
                            rootsDropdown.addItem(word);
                        }
                    }
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                rootsDropdown.addActionListener(new ActionListener() {
                    @Override
                    
                    public void actionPerformed(ActionEvent e) {
                     
                        selectedRoot = (String) rootsDropdown.getSelectedItem();
                    }
                });

                tokenizedFrame.pack();
                tokenizedFrame.setVisible(true);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PoemEditor());
    }
}
