import java.util.ArrayList;

/**
 * Ceci n'est PAS le main. C'est une main, genre c'est le truc avec cinq doigts qui tient des cartes.
 * @author Théo Moukhallelati
 * @version 0.2;
 * @since 2022-04-01
 */
public class Main extends PaquetAbs{

    /**
     * Cette méthode retire une carte de la main et la retourne.
     * @param carteAjouer Carte
     */
    private void jouer(Carte carteAjouer) {
        paquetCartes.remove(carteAjouer);
    }

}