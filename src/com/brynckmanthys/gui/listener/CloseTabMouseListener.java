package com.brynckmanthys.gui.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CloseTabMouseListener implements MouseListener {
    private String tabName;
    private JLabel parent;
    private JTabbedPane tabPane;

    public CloseTabMouseListener(String tabName, JTabbedPane tabPane, JLabel parent) {
        this.tabName = tabName;
        this.tabPane = tabPane;
        this.parent = parent;
    }

    public String getTabName() {
        return tabName;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = tabPane.indexOfTab(getTabName());
        if (index >= 0) {

            tabPane.removeTabAt(index);
            // It would probably be worthwhile getting the source
            // casting it back to a JButton and removing
            // the action handler reference ;)

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        parent.setOpaque(true);
        parent.setBackground(Color.gray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        parent.setOpaque(false);
        parent.setBackground(Color.WHITE);
    }
}
