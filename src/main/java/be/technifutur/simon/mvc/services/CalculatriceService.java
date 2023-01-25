package be.technifutur.simon.mvc.services;

import javax.management.RuntimeErrorException;

import be.technifutur.simon.mvc.models.Calculatrice;

public class CalculatriceService {

    public static void processCalcul(Calculatrice calc) {
        int result = 0;

        if (calc.getOperand() == '+')
            result = calc.getNumber1() + calc.getNumber2();

        if (calc.getOperand() == '*')
            result = calc.getNumber1() * calc.getNumber2();

        if (calc.getOperand() == '/' || calc.getOperand() == '%') {
            if (calc.getNumber2() == 0)
                throw new RuntimeException("Division par 0");
            else 
                if (calc.getOperand() == '/')
                result = calc.getNumber1() / calc.getNumber2();

                else if (calc.getOperand() == '%')
                    result = calc.getNumber1() % calc.getNumber2();
        }

        if (calc.getOperand() == '-')
            result = calc.getNumber1() - calc.getNumber2();

        calc.setResult(result);
    }

    
    
}
