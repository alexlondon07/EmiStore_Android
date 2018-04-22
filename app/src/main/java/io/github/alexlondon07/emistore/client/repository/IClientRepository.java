package io.github.alexlondon07.emistore.client.repository;

import java.util.ArrayList;

import io.github.alexlondon07.emistore.client.model.Client;

/**
 * Created by alexlondon07 on 3/22/18.
 */

public interface IClientRepository {

    ArrayList<Client> getClients() throws RepositoryError;
}
