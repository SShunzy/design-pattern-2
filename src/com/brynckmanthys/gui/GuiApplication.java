package com.brynckmanthys.gui;

import com.brynckmanthys.gui.listener.CloseTabMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiApplication {
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JButton addButton;
    private JMenuBar menuBar;

    public GuiApplication() {
        initMenu();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tabTitle = "New Tab "+ tabbedPane1.getTabCount();
                tabbedPane1.addTab(tabTitle, getNewTabComponent());
                addCloseTab(tabTitle);
            }
        });
    }

    private void addCloseTab(String title){
        int index = tabbedPane1.indexOfTab(title);
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(title);
        JLabel tempLabel = new JLabel("   ");
        JLabel closeLabel = new JLabel(" X ");
        closeLabel.addMouseListener(new CloseTabMouseListener(title,tabbedPane1,closeLabel));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        pnlTab.add(lblTitle, gbc);

        gbc.gridx++;
        gbc.weightx = 0;
        pnlTab.add(tempLabel,gbc);

        gbc.gridx++;
        gbc.weightx = 0;
        pnlTab.add(closeLabel, gbc);

        tabbedPane1.setTabComponentAt(index, pnlTab);


    }

    public void initMenu(){
        JMenuItem menuItem1 = new JMenuItem("Importer");
        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                importAction();
            }
        });

        JMenuItem menuItem2 = new JMenuItem("Exporter");
        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                exportAction();
            }
        });


        JMenu menu1 = new JMenu("Fichier");

        menu1.add(menuItem1);
        menu1.add(menuItem2);

        menuBar.add(menu1);
    }


    private JPanel getNewTabComponent(){
        JPanel panel = new NPVTabPanel().getMainPanel();
        panel.setSize(500,500);
        return panel;
    }


    private void exportAction(){
        System.out.println("Export to file");
    }

    private void importAction(){
        System.out.println("Import from file");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        GuiApplication gui = new GuiApplication();
        frame.setContentPane(gui.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
