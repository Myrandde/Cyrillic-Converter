import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Sample text: Виктор Цой, мой герой. Цой жив!
        Scanner scan = new Scanner(System.in);

        System.out.println("Insert Cyrillic Text:");
        String cyrillic = scan.nextLine();

        System.out.println(cyrillic);
        System.out.println("Converted Text: " + convert(cyrillic));

    }

    private static String convert(String text) {
        StringBuilder str = new StringBuilder();
        List<String> cyrillicTrans = new ArrayList<>(List.of("a","b","v","g","d","e","zh",
                "z","i","y","k","l","m","n","o","p","r","s","t","u","f","kh","ts","ch","sh","shch","'","y","'","e","yu","ya"));

        List<String> cyrillicTransCap = new ArrayList<>(List.of("A","B","V","G","D","E","Zh",
                "Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","Kh","Ts","Ch","Sh","Shch","'","Y","'","E","Yu","Ya"));

        for (char x : text.toCharArray()) {

            int charNum = (x);

            if (charNum < 1040) {
                str.append(x);
            }

            else if (charNum < 1072) {
                str.append((cyrillicTransCap.get((charNum - 16) % 32)));
            }

            else if (charNum > 1104) {
                str.append(x);
            }

            else {
                str.append(cyrillicTrans.get((charNum - 16) % 32));
            }
        }

        return str.toString();

    }
}
