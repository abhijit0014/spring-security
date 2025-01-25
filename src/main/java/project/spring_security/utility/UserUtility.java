package project.spring_security.utility;

import org.springframework.stereotype.Service;
import project.spring_security.exception.EntityValidationException;
import project.spring_security.repository.UserRepository;

@Service
public class UserUtility {

    private static UserRepository userRepository;

    public UserUtility(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static boolean isValidUsername(String username){

        if (username == null){
            throw new EntityValidationException("Username cannot be null");
        }else {

            String MIN_LENGTH = "3";
            String MAX_LENGTH = "20";
            String MIN_MAX_CHAR = ".{" + MIN_LENGTH + "," + MAX_LENGTH + "}";

            String NO_SPACE = "(?=\\S+$)";

            String USERNAME_PATTERN = NO_SPACE + MIN_MAX_CHAR;

            if (!username.matches(USERNAME_PATTERN)) {
                throw new EntityValidationException(
                        "username must be between 3 and 20 characters\n" +
                        "Doesn’t contain space, tab, etc.");
            }

        }

        if(userRepository.findByUsername(username)!=null){
            throw new EntityValidationException("Username already exits");
        }
        return true;
    }

    public static boolean isValidPassword(String password){

        if (password == null){
            throw new EntityValidationException("Password cannot be null");
        }else  {

            String MIN_LENGTH = "8";
            String MAX_LENGTH = "64";
            String MIN_MAX_CHAR = ".{" + MIN_LENGTH + "," + MAX_LENGTH + "}";


            String ONE_DIGIT = "(?=.*[0-9])";
            String LOWER_CASE = "(?=.*[a-z])";
            String UPPER_CASE = "(?=.*[A-Z])";

            boolean SPECIAL_CHAR_NEEDED = false;
            String SPECIAL_CHAR = SPECIAL_CHAR_NEEDED ? "(?=.*[@#$%^&+=])" : "";

            String NO_SPACE = "(?=\\S+$)";


            String PasswordPATTERN = ONE_DIGIT + LOWER_CASE + UPPER_CASE + SPECIAL_CHAR + NO_SPACE + MIN_MAX_CHAR;

            if (!password.matches(PasswordPATTERN)) {
                throw new EntityValidationException(
                        "Password must have 8 characters or more\n" +
                        "Include a capital letter\n" +
                        "Use at least one lowercase letter\n" +
                        "Consists of at least one digit\n" +
                        "Need to have one special symbol (i.e., @, #, $, %, etc.)\n" +
                        "Doesn’t contain space, tab, etc.");
            }

            return true;
        }
    }
}
