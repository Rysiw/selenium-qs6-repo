package tools;

import utils.Log4Test;

import java.util.Random;

/**
 * Created by Ruslan on 11/5/14.
 */
public class EmailGenerator {

    public static String emailGenerator(String userName, String endEmail){
        Log4Test.info("Generating email for registering tests");
        Random random = new Random();
        int rage=9999;
        int generator=random.nextInt(rage);
        return userName + generator + endEmail;
    }

}
