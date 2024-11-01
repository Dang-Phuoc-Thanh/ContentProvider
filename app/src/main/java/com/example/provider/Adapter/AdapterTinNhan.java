package com.example.provider.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.provider.Model.TinNhan;
import com.example.provider.R;

import java.util.List;

public class AdapterTinNhan extends ArrayAdapter<TinNhan> {

    private final Context context;
    private final List<TinNhan> messages;

    public AdapterTinNhan(Context context, int resource, List<TinNhan> messages) {
        super(context, resource, messages);
        this.context = context;
        this.messages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate your item layout and bind data here
        // Example:
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_tinnhan, parent, false);
        }
        TinNhan message = messages.get(position);

        TextView phoneNumberView = convertView.findViewById(R.id.txt_phone);
        TextView timestampView = convertView.findViewById(R.id.txt_time);
        TextView bodyView = convertView.findViewById(R.id.txt_body);

        phoneNumberView.setText(message.getNumber());
        timestampView.setText(message.getTime());
        bodyView.setText(message.getBody());

        return convertView;
    }
}
