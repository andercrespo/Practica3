import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public static File convertirLlistaASerialitzat(String nomFitxer, LlistaAssociacions llistaAssociacions) {
        File fitxer = new File(nomFitxer);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fitxer))) {
            // Escriure l'objecte serialitzat al fitxer
            oos.writeObject(llistaAssociacions);
        } catch (Exception e) {
            System.err.println("Error al serialitzar la llista: " + e.getMessage());
            e.printStackTrace();
        }

        return fitxer;
    }
}
