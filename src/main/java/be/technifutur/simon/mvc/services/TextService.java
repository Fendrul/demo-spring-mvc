package be.technifutur.simon.mvc.services;

import java.util.ArrayList;
import java.util.List;

public class TextService {

    public static List<String> motGenerateur(int nombreMots) {
        List<String> listeMots = new ArrayList<>();

        for (int i = 0; i < nombreMots; i++) {
            StringBuilder sb = new StringBuilder();
            
            int randLength = (int) (Math.random() * (11 + 1 - 5) + 11);
            for (int j = 0; j < randLength; j++) {
                int randLetterCode = (int) (Math.random() * ('z' + 1 - 'a') + 'a');
                sb.append((char) randLetterCode);
            }

            listeMots.add(sb.toString());
        }

        return listeMots;
    }
}
