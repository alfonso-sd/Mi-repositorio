import es.usal.progiii.tools.Esdia;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int i;
        String [] frases = new String[5];
        for(i = 0; i < frases.length ; i++){
            frases[i] = Esdia.readString("Di algo: ");
        }
        Arrays.sort(frases);
        System.out.println("Estas son las cinco frases que has dicho, ordenadas alfabéticamente: ");
        for(String frase: frases){
            System.out.println(frase);
        }
    }
}
