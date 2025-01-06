import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GestorFitxers {

    public static void guardarFitxerText(String nomFitxer, LlistaMembres llistaMembres, LlistaAccions llistaAccions, LlistaAssociacio llistaAssociacio) {
        if (nomFitxer == null || nomFitxer.trim().isEmpty()) {
            System.out.println("El nom del fitxer no és vàlid.");
            return;
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFitxer))) {
            if ("membres.txt".equalsIgnoreCase(nomFitxer.trim())) {
                if (llistaMembres != null && llistaMembres.getMembres() != null) {
                    for (Membre membre : llistaMembres.getMembres()) {
                        if (membre != null) {
                            writer.write(membre.toString());
                            writer.newLine();
                        }
                    }
                }
            } else if ("accions.txt".equalsIgnoreCase(nomFitxer.trim())) {
                if (llistaAccions != null && llistaAccions.getAccions() != null) {
                    for (Accio accio : llistaAccions.getAccions()) {
                        if (accio != null) {
                            writer.write(accio.toString());
                            writer.newLine();
                        }
                    }
                }
            } else if ("associacions.txt".equalsIgnoreCase(nomFitxer.trim())) {
                if (llistaAssociacio != null && llistaAssociacio.getAssociacions() != null) {
                    for (Associacio associacio : llistaAssociacio.getAssociacions()) {
                        if (associacio != null) {
                            writer.write(associacio.toString());
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

    public static Object[] convertirSerialitzatEnLlista(String cadena) {
        cadena = cadena.trim();
        if (cadena.startsWith("[") && cadena.endsWith("]")) {
            cadena = cadena.substring(1, cadena.length() - 1).trim();
        } else {
            throw new IllegalArgumentException("El format de la cadena no és vàlid.");
        }
        if (cadena.isEmpty()) {
            return new Object[0];
        }
        String[] elements = cadena.split(",");
        Object[] resultat = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i].trim();
            try {
                resultat[i] = Integer.parseInt(element);
            } catch (NumberFormatException e) {
                resultat[i] = element;
            }
        }
        return resultat;
    }

    public static File convertirLlistaASerialitzat(String nomFitxer, LlistaAssociacio llistaAssociacions) {
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
