package de.imker.validation.validators;

import de.imker.validation.constrains.NotWeakPassword;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<NotWeakPassword, String> {

  private static final Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{5,}$");
  @Override
  public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
  }

}
