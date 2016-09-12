/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Muntao
 */
@FacesValidator("OnlyLettersAndNumbersValidator")
public class OnlyLettersAndNumbersValidator implements Validator {

    private static final String STRING_PATTERN = "^[a-zA-Z0-9ąęóśłżźńćĘĄÓŚŁŻŹĆŃ]+$";

    private Pattern pattern;
    private Matcher matcher;

    public OnlyLettersAndNumbersValidator() {
        pattern = Pattern.compile(STRING_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage();
            String name = component.getId();
            if (name.contains("Login")) {
                msg.setSummary("Pole LOGIN może zawierać tylko litery i cyfry!");
            } else if (name.contains("Haslo")) {
                msg.setSummary("Pole HASLO może zawierać tylko litery i cyfry!");
            } else if (name.contains("Opis")) {
                msg.setSummary("Pole OPIS może zawierać tylko litery i cyfry!");
            } else if (name.contains("Haslo2")) {
                msg.setSummary("Pole POWTORZ HASLO może zawierać tylko litery i cyfry!");
            }
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
