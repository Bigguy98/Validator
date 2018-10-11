package vtt.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vtt.demo.domain.Person;
@Component
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        ValidationUtils.rejectIfEmpty(errors,"name","name.required");
        if(person.getAge() < 18) {
            System.out.println("not old enough!!!");
            errors.rejectValue("age","age.enough");
        }
    }
}
