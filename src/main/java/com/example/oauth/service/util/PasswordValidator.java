package com.example.oauth.service.util;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordValidator {

    private Pattern pattern = null;

    /**
     * No one can make a direct instance
     * */
    public PasswordValidator()
    {
        pattern = getPattern(true, true, true, 8,16);
    }

    /**
     * Force the user to build a validator using this way only
     * */
    public static Pattern getPattern( boolean forceSpecialChar,
                                      boolean forceCapitalLetter,
                                      boolean forceNumber,
                                      int minLength,
                                      int maxLength)
    {
        StringBuilder patternBuilder = new StringBuilder("((?=.*[a-z])");

        if (forceSpecialChar)
        {
            patternBuilder.append("(?=.*[@#$%^&+=!])");
        }

        if (forceCapitalLetter)
        {
            patternBuilder.append("(?=.*[A-Z])");
        }

        if (forceNumber)
        {
            patternBuilder.append("(?=.*\\d)");
        }

        patternBuilder.append(".{" + minLength + "," + maxLength + "})");
        return Pattern.compile(patternBuilder.toString());
    }

    /**
     * Check if the provided password is valid
     * @param password a string value
     * @return true / false
     */
    public boolean isValid(String password){
        Matcher m = pattern.matcher(password);
        return m.matches();
    }
}
