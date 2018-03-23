package io.github.alexlondon07.emistore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.alexlondon07.emistore.R;
import io.github.alexlondon07.emistore.client.model.Client;

/**
 * Created by alexlondon07 on 3/19/18.
 */

public class ClientAdapter extends BaseAdapter {

    private ArrayList<Client> clientArrayList;
    private Context context;
    private int layout;
    private Client client;
    private TextView name, lastName, cellPhone;


    public ClientAdapter(Context context, int resource, int layout, ArrayList<Client> clientArrayList){
        this.context = context;
        this.layout = layout;
        this.clientArrayList = clientArrayList;
    }


    @Override
    public int getCount() {
        return  clientArrayList.size();
    }

    @Override
    public Client getItem(int position) {
        return clientArrayList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){

            //La primera vez que entre, se infla la vista y adjuntamos las referencias del layout en una nueva instancia de nuestro viewholder
            convertView = LayoutInflater.from(context).inflate(layout, null);

            viewHolder = new ViewHolder();
            viewHolder.textViewName = convertView.findViewById(R.id.client_item_name);
            viewHolder.textViewLastName = convertView.findViewById(R.id.client_item_last_name);
            viewHolder.textViewCellPhone = convertView.findViewById(R.id.client_item_cellphone);
            convertView.setTag(viewHolder);

        }else{
            //Obtenemos la referencia, reciclamos su uso sin necesidad de buscar de nuevo
            viewHolder = (ViewHolder) convertView.getTag();
        }


        //Obtenemos el objeto actual
        final Client currentClient = getItem(position);
        viewHolder.textViewName.setText(currentClient.getName());
        viewHolder.textViewLastName.setText(currentClient.getLastName());
        viewHolder.textViewCellPhone.setText(currentClient.getCellphone());

        //Retornamos el Objeto Client con los datos correspondientes
        return convertView;
    }

    static class ViewHolder{
        private TextView textViewName, textViewLastName, textViewCellPhone;
    }

}
