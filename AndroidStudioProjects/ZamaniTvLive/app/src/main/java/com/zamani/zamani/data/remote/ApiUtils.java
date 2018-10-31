package com.zamani.zamani.data.remote;

/**
 * Created by adugam on 9/25/18.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://zamanitv-staging.herokuapp.com/api/v1/entrance/signup/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
