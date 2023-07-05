package threads;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Umschalten {
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View(m);
        Controller c = new Controller(m, v);

        JFrame frame = new JFrame("Umschalten");
        frame.setContentPane(v);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

class Model {
    private boolean active;

    public Model() {
        this.active = true;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Set initial button states
        view.setLeftButtonEnabled(model.isActive());
        view.setRightButtonEnabled(!model.isActive());

        // Add action listeners to buttons
        view.addLeftButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setActive(!model.isActive());
                view.setLeftButtonEnabled(model.isActive());
                view.setRightButtonEnabled(!model.isActive());
            }
        });

        view.addRightButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setActive(!model.isActive());
                view.setLeftButtonEnabled(model.isActive());
                view.setRightButtonEnabled(!model.isActive());
            }
        });
    }
}

class View extends JPanel {
    private JButton leftButton;
    private JButton rightButton;

    public View(Model model) {
        this.leftButton = new JButton("Left");
        this.rightButton = new JButton("Right");

        add(leftButton);
        add(rightButton);
    }

    public void setLeftButtonEnabled(boolean enabled) {
        leftButton.setEnabled(enabled);
    }

    public void setRightButtonEnabled(boolean enabled) {
        rightButton.setEnabled(enabled);
    }

    public void addLeftButtonListener(ActionListener listener) {
        leftButton.addActionListener(listener);
    }

    public void addRightButtonListener(ActionListener listener) {
        rightButton.addActionListener(listener);
    }
}