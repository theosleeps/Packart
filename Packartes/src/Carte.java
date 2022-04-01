public class Carte {

    private String valeur;
    private Suite suite;

    public Carte(String valeur, Suite suite) {

        this.valeur = valeur;
        this.suite = suite;

    }

    @Override
    public String toString() {

        String TheOneString =  new String(valeur + (suite.toString()) );

        System.out.println(TheOneString);
        return TheOneString;
    }

}
