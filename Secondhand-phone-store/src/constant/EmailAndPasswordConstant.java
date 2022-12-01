package constant;

public class EmailAndPasswordConstant {
    public static final String REGEX_EMAIL ="^[a-zA-Z]{1,}[\\w]{1,}@([\\w]{1,}\\.)[\\w]+$";

    public static final String REGEX_PASSWORD ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{7,15}$";

    /*      ^                 # start-of-string
            (?=.*[0-9])       # a digit must occur at least once
            (?=.*[a-z])       # a lower case letter must occur at least once
            (?=.*[A-Z])       # an upper case letter must occur at least once
            (?=.*[@#$%^&+=])  # a special character must occur at least once
            .{7,15}           # anything, from 7 to 15 letters
            $                 # end-of-string
     */
}
