package utils;

import org.apache.commons.lang3.RandomStringUtils;

public abstract class GenerateRandom {

    public static String generateRandomEmail(String baseEmail){
        String randomEmailIdentifier = RandomStringUtils.randomNumeric(4);
        String finalEmail = baseEmail + randomEmailIdentifier + "@gmail.com";
        return finalEmail;
    }
}
