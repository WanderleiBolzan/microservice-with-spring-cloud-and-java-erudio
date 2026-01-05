package br.com.wanderlei.controlers;

import br.com.wanderlei.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8081/math/sum/

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException ("Please set a Numeric value");
        return converToDouble(numberOne) + converToDouble(numberTwo) ;
    }

    private Double converToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty ())
            throw new UnsuportedMathOperationException ("Please set a Numeric value");
        String number =strNumber.replace (",", ".");
        return Double.parseDouble (number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty ()) return false;
        String number = strNumber.replace (",", ".");
        return number.matches ("[-+]?[0-9]*\\.?[0-9]+");
    }
    //http://localhost:8081/math/subtraction/
    //http://localhost:8081/math/disision/
}
