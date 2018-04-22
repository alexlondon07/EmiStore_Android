package io.github.alexlondon07.emistore.service;

import java.util.ArrayList;

import io.github.alexlondon07.emistore.client.model.Client;
import retrofit.http.GET;

/**
 * Created by alexlondon07 on 3/22/18.
 */

public interface IClientServices {

    @GET("/clients")
    ArrayList<Client> getClients();
}
