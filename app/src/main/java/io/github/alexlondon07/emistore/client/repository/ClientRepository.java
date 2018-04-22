package io.github.alexlondon07.emistore.client.repository;

import java.util.ArrayList;

import io.github.alexlondon07.emistore.client.model.Client;
import io.github.alexlondon07.emistore.helper.ServicesFactory;
import io.github.alexlondon07.emistore.service.IClientServices;
import retrofit.RetrofitError;

/**
 * Created by alexlondon07 on 3/22/18.
 */

public class ClientRepository implements IClientRepository {

    private IClientServices clientServices;

    public ClientRepository() {
        ServicesFactory servicesfactory = new ServicesFactory();
        clientServices = (IClientServices) servicesfactory.getInstance(IClientServices.class);
    }

    @Override
    public ArrayList<Client> getClients() throws RepositoryError {
        try {
            ArrayList<Client> clientArrayList = clientServices.getClients();
            return  clientArrayList;
        }catch (RetrofitError retrofitError){
            retrofitError.printStackTrace();
            throw MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
        }
    }
}
