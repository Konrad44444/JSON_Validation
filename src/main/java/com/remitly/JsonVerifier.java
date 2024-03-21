package com.remitly;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonVerifier {
    public static boolean verifyFormat(JSONObject json) {
        try {
            // check policy name
            String policyName = json.getString("PolicyName");

            // check lenght
            if (policyName.length() == 0 || policyName.length() > 128) {
                return false;
            }
            // check pattern
            if (!policyName.matches("[\\w+=,.@-]+")) {
                return false;
            }


            // check policy document
            json.getJSONObject("PolicyDocument"); // if not a JSONObject or doesn't exists it will throw a JSONException
            
        } catch (JSONException e) {
            return false;
        }

        return true;
    }
}
