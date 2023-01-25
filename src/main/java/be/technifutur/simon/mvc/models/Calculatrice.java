package be.technifutur.simon.mvc.models;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Calculatrice {

    @Positive
    int number1, number2;
    char operand;
    int result;
}
