import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class GestorFitxers {

    public void llegirFitxerText(String nomFitxer, LlistaMembres llistaMembres, LlistaAccions llistaAccions) {
        try (BufferedReader lector = new BufferedReader(new FileReader(nomFitxer))) {
            String linia;
            while ((linia = lector.readLine()) != null) {
                String[] dades = linia.split(";"); // Separar els atributs per ';'

                // Processar dades segons el fitxer
                if (nomFitxer.equalsIgnoreCase("membres.txt")) {
                    processarMembre(dades, llistaMembres);
                } else if (nomFitxer.equalsIgnoreCase("accions.txt")) {
                    processarAccio(dades, llistaAccions);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al llegir el fitxer: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al processar dades numèriques: " + e.getMessage());
        }
    }
    public static void guardarFitxerText(String nomFitxer, LlistaMembres llistaMembres, LlistaAccions llistaAccions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFitxer))) {
            if ("membres.txt".equals(nomFitxer)) {
                for (Membre membre : llistaMembres.getMembres()) {
                    writer.write(membre.toString());
                    writer.newLine();
                }
            } else if ("accions.txt".equals(nomFitxer)) {
                for (Accio accio : llistaAccions.getAccions()) {
                    writer.write(accio.toString());
                    writer.newLine();
                }
            } else {
                System.out.println("El nom del fitxer no és vàlid.");
            }
        } catch (IOException e) {
            System.err.println("Error escrivint al fitxer: " + e.getMessage());
        }
    }
}


    private void processarMembre(String[] dades, LlistaMembres llistaMembres) {
        String tipus = dades[0];
        String alies = dades[1];
        String correu = dades[2];
        LocalDate[] dataAlta = { LocalDate.parse(dades[3]) };
        LocalDate[] dataBaixa = { dades[4].isEmpty() ? null : LocalDate.parse(dades[4]) };
        LlistaAssociacio associacions = null; // Placeholder

        if (tipus.equalsIgnoreCase("Alumne")) {
            String ensenyament = dades[5];
            int anysETSE = Integer.parseInt(dades[6]);
            boolean graduat = Boolean.parseBoolean(dades[7]);

            Alumne alumne = new Alumne(alies, correu, dataAlta, dataBaixa, associacions, tipus, ensenyament, anysETSE, graduat);
            llistaMembres.afegirMembre(alumne);
        } else if (tipus.equalsIgnoreCase("Professor")) {
            String departament = dades[5];
            int despatx = Integer.parseInt(dades[6]);

            Professor professor = new Professor(alies, correu, dataAlta, dataBaixa, associacions, tipus, departament, despatx);
            llistaMembres.afegirMembre(professor);
        }
    }

    private void processarAccio(String[] dades, LlistaAccions llistaAccions) {
        String tipus = dades[0];
        String codi = dades[1];
        String titol = dades[2];
        Associacio[] associacionsOrganitzadores = {}; // Placeholder
        Membre responsable = null; // Placeholder

        if (tipus.equalsIgnoreCase("Xerrada")) {
            LocalDate dataRealitzacio = LocalDate.parse(dades[3]);
            int nombreAssistents = Integer.parseInt(dades[4]);
            int[] valoracions = {}; // Placeholder
            Membre[] impartidors = {}; // Placeholder

            Xerrada xerrada = new Xerrada(codi, titol, associacionsOrganitzadores, responsable, tipus, dataRealitzacio, nombreAssistents, valoracions, impartidors);
            llistaAccions.afegirAccio(xerrada);
        }
        else if (tipus.equalsIgnoreCase("Demostracio")) {
            LocalDate[] dataDisseny = { LocalDate.parse(dades[5]) };
            boolean esValida = Boolean.parseBoolean(dades[6]);
            int nombreVegadesOfertes = Integer.parseInt(dades[7]);
            double costMaterials = Double.parseDouble(dades[8]);
            
            Demostracio demostracio = new Demostracio(codi, titol, associacionsOrganitzadores, responsable, tipus, dataDisseny, esValida, nombreVegadesOfertes, costMaterials);
            
            llistaAccions.afegirAccio(demostracio);
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
}




