import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;


public class interficieGrafica extends JFrame {

    /**
     * Constructor de la classe interficieGrafica.
     *
     * @param titol el títol de la finestra.
     */
    public interficieGrafica(String titol) {
        super(titol);
        this.setLocation(100, 200); // Estableix la ubicació de la finestra.
        this.setSize(500, 300); // Defineix la mida de la finestra.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Configura l'operació per defecte al tancar.
        this.iniContingutFinestraV1(); // Inicialitza el contingut de la finestra.
        this.setVisible(true); // Fa que la finestra sigui visible.
    }

    /**
     * Punt d'entrada principal del programa. Crea una instància de la interfície gràfica.
     *
     * @param args arguments de la línia de comandes (no utilitzats).
     */
    public static void main(String[] args) {
        new interficieGrafica("Hola");
    }

    /**
     * Inicialitza el contingut de la finestra amb un disseny de graella.
     *
     * Configura la finestra amb un disseny de graella (6 files i 3 columnes)
     * i afegeix botons etiquetats amb "Opció" seguit del seu número corresponent.
     */
    public void iniContingutFinestraV1() {
        int nfil = 6; // Nombre de files de la graella.
        int ncol = 3; // Nombre de columnes de la graella.
        this.setLayout(new GridLayout(nfil, ncol, 10, 10)); // Configura el disseny de la finestra.

        // Afegeix botons numerats a la graella.
        for (int i = 0; i < nfil * ncol; i++) {
            this.add(new JButton("Opció " + (i + 1)));
        }
    }
}
