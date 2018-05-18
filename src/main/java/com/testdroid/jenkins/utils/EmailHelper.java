package com.testdroid.jenkins.utils;

import org.apache.commons.lang.StringUtils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailHelper {

    private static final Logger LOGGER = Logger.getLogger(EmailHelper.class.getSimpleName());

    public static List<String> getEmailAddresses(String email) {
        ArrayList<String> result = new ArrayList<>();
        if (StringUtils.isNotBlank(email)) {
            String[] emails = email.split(",");

            for (String e : emails) {
                if (StringUtils.isNotBlank(e)) {
                    try {
                        result.add(new InternetAddress(e.trim()).getAddress());
                    } catch (AddressException ex) {
                        LOGGER.log(Level.WARNING, String.format("Cannot parse %s to email address", e), ex);
                    }
                }
            }
        }

        return result;
    }
}
