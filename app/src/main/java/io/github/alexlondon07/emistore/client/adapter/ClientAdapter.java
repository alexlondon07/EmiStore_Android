package io.github.alexlondon07.emistore.client.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.alexlondon07.emistore.R;
import io.github.alexlondon07.emistore.client.model.Client;

/**
 * Created by alexlondon07 on 3/19/18.
 */

public class ClientAdapter extends ArrayAdapter<Client> {

    private ArrayList<Client> clientArrayList;
    private Activity context;
    private int layout;
    private Client client;
    private TextView name, lastName, cellPhone;


    public ClientAdapter(Activity context, int resource, ArrayList<Client> clientArrayList){
        super(context, resource, clientArrayList);
        this.context = context;
        this.clientArrayList = clientArrayList;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_item, parent, false);
        this.client = this.clientArrayList.get(position);
        loadView(convertView);
        name.setText(client.getName());
        lastName.setText(client.getLastName());
        cellPhone.setText(client.getCellphone());
        return convertView;
    }

    private void loadView(View convertView) {
        name = convertView.findViewById(R.id.client_item_name);
        lastName = convertView.findViewById(R.id.client_item_last_name);
        cellPhone = convertView.findViewById(R.id.client_item_cellphone);
    }


}
