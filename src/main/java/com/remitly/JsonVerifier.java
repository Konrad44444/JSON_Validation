package com.remitly;

import org.json.JSONArray;
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

    public static boolean verifyResourceField(JSONObject json) {
        try {
            JSONObject policyDocument = json.getJSONObject("PolicyDocument");

            JSONArray statements = policyDocument.getJSONArray("Statement");

            for (Object s : statements) {
                JSONObject statement = (JSONObject) s;

                // for each statement check resource
                // resource can be object or array
                String resourcesString = statement.optString("Resource");

                // if there is no resource field
                if (resourcesString.equals("")) {
                    return false;
                }

                // string preparations
                resourcesString = resourcesString.replace("[", "");
                resourcesString = resourcesString.replace("]", "");
                String[] resources = resourcesString.split(",");

                for (String resource : resources) {
                    if (resource.equals("*")) {
                        return false;
                    }
                }
            }

        } catch (JSONException e) {
            return false;
        }

        return true;
    }

}
