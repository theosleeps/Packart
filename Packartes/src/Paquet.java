import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Classe paquet de cartes, sert à instancier et manipuler un deck.
 * @author Théo Moukhallelati
 * @version 0.2;
 * @since 2022-03-30
 */
public class Paquet extends PaquetAbs {

    ArrayList<Carte> paquetCartes; //52 cartes unique à son initialisation : 13 cartes de chaque suite. Pas de jokers,
                                   // pas de cartes promotionnelles.

    public Paquet() {
        this.paquetCartes = new ArrayList<>();
        generer();
    }


    /**
     * remplit le ArrayListe qui constitue le dit paquet
     */
    private void generer() {
        Carte card;

        int compteurValeur =1;
        String valeur;
        Suite suiteGen;

        for (int i = 1; i <= 52; i++) {

            if (compteurValeur == 13) {
                compteurValeur = 0;
            }

            if (i <=26) {
                valeur = switch (compteurValeur) {
                    case 1 -> "A";
                    case 2 -> "2";
                    case 3 -> "3";
                    case 4 -> "4";
                    case 5 -> "5";
                    case 6 -> "6";
                    case 7 -> "7";
                    case 8 -> "8";
                    case 9 -> "9";
                    case 10 -> "10";
                    case 11 -> "J";
                    case 12 -> "Q";
                    default -> "K"; //13
                };
            }

            else {
                valeur = switch (compteurValeur) {
                    case 1 -> "K";
                    case 2 -> "Q";
                    case 3 -> "J";
                    case 4 -> "10";
                    case 5 -> "9";
                    case 6 -> "8";
                    case 7 -> "7";
                    case 8 -> "6";
                    case 9 -> "5";
                    case 10 -> "4";
                    case 11 -> "3";
                    case 12 -> "2";
                    default -> "A"; //1
                };
            }
            if ( i <= 13) {
                suiteGen = Suite.PIC;
            }
            else if (i <= 26) {
                suiteGen = Suite.CARREAU;
            }
            else if (i <= 39) {
                suiteGen = Suite.TRÈFLE;
            }
            else {
                suiteGen = Suite.CŒUR;
            }

            card = new Carte(valeur, suiteGen);
            card.toString(); //pour tester

            paquetCartes.add(card);
            compteurValeur++;

        }

    }


    /**
     * Retourne le premier objet Carte indexé, puis le retire de paquetCartes.
     * @return Carte
     */
    private Carte piocher() {

        try {
            Carte copieCarte = paquetCartes.get(0);
            paquetCartes.remove(0);
            return copieCarte;
        } catch (ArrayIndexOutOfBoundsException pasAssezDeCartes) {
            System.out.println("Le paquet est vide.");
            return null;
        }

    }

    /**
     * Retourne le premier objet Carte indexé, puis le retire de paquetCartes, à [nombreDeCartes] reprises.
     * @return Carte
     */
    private ArrayList<Carte> piocher(int nombreDeCartes) {

        if (nombreDeCartes > paquetCartes.size()) { //éviter un index out of bounds ce serait bien non
            System.out.println("Il ne reste pas assez de cartes.");
            return null;
        }

        ArrayList<Carte> cartesPiochees = new ArrayList<>();

        for (int i = 0; i < nombreDeCartes; i++) {
            cartesPiochees.add(piocher());
        }
        return cartesPiochees;

    }

    /**
     * Utilise la méthode shuffle sur le paquet.
     */
    private void brasser() {
        Collections.shuffle(paquetCartes);
    }


    /**
     * Retourne le nombre de cartes dans le paquet.
     * @return int
     */
    private int getNombreCartes() {
        return paquetCartes.size();
    }

}
