import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestorFitxers {

    public static void guardarFitxerText(String nomFitxer, LlistaMembres llistaMembres, LlistaAccions llistaAccions) {
        if (nomFitxer == null || nomFitxer.trim().isEmpty()) {
            System.out.println("El nom del fitxer no és vàlid.");
            return;
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFitxer))) {
            if ("membres.txt".equalsIgnoreCase(nomFitxer.trim())) {
                if (llistaMembres != null && llistaMembres.getMembres() != null) {
                    for (Membre membre : llistaMembres.getMembres()) {
                        if (membre != null) {
                            writer.write(membre.guardarFitxer()); // Retorna els atributs separats per ';'
                            writer.newLine();
                        }
                    }
                }
            } else if ("accions.txt".equalsIgnoreCase(nomFitxer.trim())) {
                if (llistaAccions != null && llistaAccions.getAccions() != null) {
                    for (Accio accio : llistaAccions.getAccions()) {
                        if (accio != null) {
                            writer.write(accio.toString()); // Retorna els atributs separats per ';'
                            writer.newLine();
                        }
                    }
                }
            } else {
                System.out.println("El nom del fitxer no és vàlid.");
            }
        } catch (IOException e) {
            System.err.println("Error escrivint al fitxer: " + e.getMessage());
        }
    }

    public static void llegirLlistaAssociacionsDesSerialitzat(LlistaAssociacio[] llista) {
        ObjectInputStream inputFile;
        try {
            inputFile = new ObjectInputStream(new FileInputStream("associacions.ser"));
            for (int i = 0; i < llista.length; i++) {
                llista[i] = (LlistaAssociacio) inputFile.readObject();
            }
            inputFile.close();
            System.out.println("Les associacions s'han carregat correctament des del fitxer: associacions.ser");
        } catch (IOException e) {
            System.out.println("Error en l'arxiu d'entrada: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error, no es troba la classe LlistaAssociacio: " + e.getMessage());
            } catch (ClassCastException e) {
                System.out.println("Error, el format de l'arxiu no és correcte per la definició actual de la classe LlistaAssociacio: " + e.getMessage());
            }
    }


    public static void guardarLlistaAssociacionsASerialitzat(LlistaAssociacio[] llista) {
        ObjectOutputStream outputFile;
        try {
            outputFile = new ObjectOutputStream(new FileOutputStream("associacions.ser"));
            for (int i = 0; i < llista.length; i++) {
                outputFile.writeObject(llista[i]);
            }
            outputFile.close();
            System.out.println("Les associacions s'han guardat correctament al fitxer: associacions.ser");
        } catch (IOException e) {
            System.out.println("Error en l'arxiu de sortida: " + e.getMessage());
        }
    }  
}
