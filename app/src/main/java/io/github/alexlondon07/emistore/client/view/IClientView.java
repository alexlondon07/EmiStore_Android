package io.github.alexlondon07.emistore.client.view;

import java.util.ArrayList;

import io.github.alexlondon07.emistore.client.model.Client;
import io.github.alexlondon07.emistore.util.IBaseView;

/**
 * Created by alexlondon07 on 3/19/18.
 */

public interface IClientView extends IBaseView{

    void showClientList(ArrayList<Client> clientArrayList);

    void showAlertDialog(int error, int validate_internet);

    void showAlertError(int title, int message);
}
