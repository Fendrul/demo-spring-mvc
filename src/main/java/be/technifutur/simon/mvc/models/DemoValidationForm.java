package be.technifutur.simon.mvc.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DemoValidationForm {
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    private int entier;

    @NotBlank
    @NotNull
    @Null
    @NotEmpty
    @Size(min = 0, max = 10)
    @Pattern(regexp = "[0-9]+")
    private String chaine;

    private Object objet;

    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent
    private LocalDateTime dateTime;

    @NotEmpty
    @Size(min = 0, max = 9999)
    private List<Object> list;
}
