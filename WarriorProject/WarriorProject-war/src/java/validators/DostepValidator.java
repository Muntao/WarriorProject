/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

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
@FacesValidator("DostepValidator")
public class DostepValidator implements Validator {

    public DostepValidator() {

    }

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        
        boolean a = Integer.parseInt(value.toString()) == 1;
        boolean b = Integer.parseInt(value.toString()) == 0;

        if (!(a || b)){    
 
            FacesMessage msg = new FacesMessage("Pole DOSTEP jest niepoprawne!", "Pole DOSTEP jest niepoprawny!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }
    }
}
