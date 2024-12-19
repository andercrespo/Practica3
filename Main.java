import java.util.Scanner;

public class Main {

    private static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) {
        mostraMenu();
        int opcio = Integer.parseInt(teclat.nextLine());

        while (opcio != 18) {
            switch (opcio) {
                case 1:
                    opcio1();
                    break;
                case 2:
                    opcio2();
                    break;
                case 3:
                    opcio3();
                    break;
                case 4:
                    opcio4();
                    break;
                case 5:
                    opcio5();
                    break;
                case 6:
                    opcio6();
                    break;
                case 7:
                    opcio7();
                    break;
                case 8:
                    opcio8();
                    break;
                case 9:
                    opcio9();
                    break;
                case 10:
                    opcio10();
                    break;
                case 11:
                    opcio11();
                    break;
                case 12:
                    opcio12();
                    break;
                case 13:
                    opcio13();
                    break;
                case 14:
                    opcio14();
                    break;
                case 15:
                    opcio15();
                    break;
                case 16:
                    opcio16();
                    break;
                case 17:
                    opcio17();
            }
            mostraMenu();
            opcio = Integer.parseInt(teclat.nextLine());
        }
        System.out.println("Sortint de l'aplicació.");
    }

    public static void mostraMenu() {
        System.out.println("\n\nOpcions del menú:");
        System.out.println("\t1. Mostrar les dades de la llista d’associacions.");
        System.out.println("\t2. Mostrar les dades de la llista de membres que formen part d’una associació.");
        System.out.println("\t3. Mostrar les dades de la llista de membres actius.");
        System.out.println("\t4. Mostrar les dades de la llista d’accions.");
        System.out.println("\t5. Obtenir i mostrar la llista d’accions que ofereix una associació concreta.");
        System.out.println("\t6. Obtenir i mostrar la llista de les xerrades en una franja de dates.");
        System.out.println("\t7. Afegir una nova associació.");
        System.out.println("\t8. Alta d’un membre a una associació.");
        System.out.println("\t9. Afegir una nova xerrada.");
        System.out.println("\t10. Afegir una nova demostració.");
        System.out.println("\t11. Consultar i mostrar demostracions no actives.");
        System.out.println("\t12. Calcular la persona més activa.");
        System.out.println("\t13. Consultar xerrades amb més assistents.");
        System.out.println("\t14. Valorar una xerrada.");
        System.out.println("\t15. Consultar la xerrada millor valorada.");
        System.out.println("\t16. Mostrar dades de les xerrades que farà una persona.");
        System.out.println("\t17. Donar de baixa demostracions no actives abans d’una data.");
        System.out.println("\t18. Sortir de l'aplicació.");
        System.out.print("\nIndica opció: ");
    }

    public static void opcio1() {
    }

    public static void opcio2() {
    }

    public static void opcio3() {
    }

    public static void opcio4(String[] args) {
        LlistaAccions llista = new LlistaAccions(10);
        System.out.println("Totes les accions disponibles:");
        System.out.println(llista.obtenirInformacio());
    }
}

    }

    public static void opcio5() {
    }

    public static void opcio6() {
    }

    public static void opcio7() {
    }

    public static void opcio8() {
    }

    public static void opcio9() {
    }

    public static void opcio10() {
    }

    public static void opcio11() {
    }

    public static void opcio12() {
    }

    public static void opcio13() {
    }

    public static void opcio14() {
    }

    public static void opcio15() {
    }

    public static void opcio16() {
    }

    public static void opcio17() {
    }
}
