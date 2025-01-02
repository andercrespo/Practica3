import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;


public class interficieGrafica extends JFrame{
    public interficieGrafica (String titol){
        super(titol);
        this.setLocation(100, 200);
        this.setSize(500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.iniContingutFinestraV1();   
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new interficieGrafica("Hola");
    }

    public void iniContingutFinestraV1() {
        int nfil=6, ncol=3;
        this.setLayout(new GridLayout(nfil, ncol, 10, 10));
        for (int i=0; i<nfil*ncol; i++) {
            this.add(new JButton("Opció "+(i+1)));
        }
    }
}
