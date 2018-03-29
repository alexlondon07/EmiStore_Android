package io.github.alexlondon07.emistore.client.presenter;

import java.util.ArrayList;

import io.github.alexlondon07.emistore.R;
import io.github.alexlondon07.emistore.client.model.Client;
import io.github.alexlondon07.emistore.client.repository.IClientRepository;
import io.github.alexlondon07.emistore.client.repository.RepositoryError;
import io.github.alexlondon07.emistore.client.view.IClientView;
import io.github.alexlondon07.emistore.util.BasePresenter;

/**
 * Created by alexlondon07 on 3/19/18.
 */

public class ClientPresenter extends BasePresenter<IClientView> {

    private IClientRepository clientRepository;

    public ClientPresenter(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void getClientsPresenter(){
        if(getValidateInternet().isConnected()){
            createThreadClient();
        }else{
            getView().showAlertDialog(R.string.error, R.string.validate_internet);
        }
    }

    private void createThreadClient() {
        getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getClientsRepository();
            }
        });
        thread.start();
    }

    /**
     * Función para obtener listado de Cliente de bd
     */
    private void getClientsRepository() {
        try {

            ArrayList<Client>  clientArrayList = clientRepository.getClients();
            getView().showClientList(clientArrayList);

        }catch (RepositoryError repositoryError){
            getView().showAlertDialog(R.string.error, repositoryError.toString());
        }finally {
            getView().hideProgress();
        }
    }
}
