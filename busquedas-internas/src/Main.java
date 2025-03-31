
import controlador.MainMenuController;
import vista.MainMenuView;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenuView view = new MainMenuView();
            new MainMenuController(view);
            view.setVisible(true);
        });
    }
}
