package io.github.alexlondon07.emistore.client.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import java.util.ArrayList;

import io.github.alexlondon07.emistore.R;
import io.github.alexlondon07.emistore.client.adapter.ClientAdapter;
import io.github.alexlondon07.emistore.client.model.Client;
import io.github.alexlondon07.emistore.client.presenter.ClientPresenter;
import io.github.alexlondon07.emistore.client.repository.ClientRepository;
import io.github.alexlondon07.emistore.util.BaseActivity;


public class ClientActivity extends BaseActivity<ClientPresenter> implements IClientView {

    private ListView clientList;
    private ClientAdapter clientAdapter;
    private SwipeRefreshLayout swipeRefreshLayoutClients;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        setPresenter(new ClientPresenter(new ClientRepository()));
        getPresenter().inject(this, getValidateInternet());
        createProgresDialog();
        getPresenter().getClientsPresenter();

        loadView();
    }

    private void loadView() {
        clientList = findViewById(R.id.client_list_view);
        swipeRefreshLayoutClients = findViewById(R.id.activity_client_swipeRefresh);
        swipeRefreshLayoutClients.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeRefreshLayoutClients.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getPresenter().getClientsPresenter();
                        swipeRefreshLayoutClients.setRefreshing(false);
                    }
                }, 5000);
            }
        });
    }

    @Override
    public void showClientList(final ArrayList<Client> clientArrayList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                callAdapter(clientArrayList);
            }
        });
    }

    private void callAdapter(ArrayList<Client> clientArrayList) {
        clientAdapter = new ClientAdapter(this, R.id.client_list_view, clientArrayList);
        clientList.setAdapter(clientAdapter);
    }

    @Override
    public void showAlertDialog(final int title, final int message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getShowAlertDialog().showAlertDialog(title, message, false, R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().getClientsPresenter();
                    }
                }, R.string.option_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
            }
        });
    }

    @Override
    public void showAlertDialog(int title, String message) {
        showAlertDialog(title, message);
    }

    @Override
    public void showAlertError(int title, int message) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getClientsPresenter();
    }
}
