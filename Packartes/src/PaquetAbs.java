import java.util.ArrayList;
import java.util.Random;

public abstract class PaquetAbs {

    ArrayList<Carte> paquetCartes; //52 cartes unique à son initialisation : 13 cartes de chaque suite. Pas de jokers,
    // pas de cartes promotionnelles.

    public PaquetAbs() {
        this.paquetCartes = new ArrayList<>();
    }


    /*
    ** Méthodes utilisables par les deux classes enfant
    */

    /**
     * Retourne un objet Carte au hasard, puis le retire de paquetCartes.
     * @return Carte
     */
    private Carte piger() {

        if (paquetCartes.isEmpty()) { //éviter un index out of bounds ce serait bien non
            System.out.println("Il ne reste pas assez de cartes.");
            return null;
        }

        Random rand = new Random();

        int indexHasard = rand.nextInt(paquetCartes.size());

        System.out.println("Carte retirée : " + paquetCartes.get(indexHasard).toString());
        paquetCartes.remove(indexHasard);

        return paquetCartes.get(indexHasard);
    }

    /**
     * Retourne des objets Carte au hasard, puis les retire de paquetCartes, à [nombreDeCartes] reprises.
     * @return Carte
     * @param nombreDeCartes int
     */
    private ArrayList<Carte> piger(int nombreDeCartes) {

        ArrayList<Carte> cartesPigees = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            cartesPigees.add(piger());
        }
        return cartesPigees;

    }

    /**
     * Ajoute un objet Carte au paquet à l'index passé.
     * @param index int
     * @param card Carte
     */
    private void inserer(int index, Carte card) {
        paquetCartes.add(index, card);
    }
}
