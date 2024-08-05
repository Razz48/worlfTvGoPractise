//package com.example.worldtvgo.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import com.example.worldtvgo.R;
//
//import java.util.List;
//
//public class CustomSpinnerAdapter extends ArrayAdapter<String> {
//
//    private Context context;
//    private List<String> items;
//    private int textColor;
//
//    public CustomSpinnerAdapter(Context context, List<String> items, int textColor) {
//        super(context, R.layout.spinner_item, items);
//        this.context = context;
//        this.items = items;
//        this.textColor = textColor;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
//        }
//        TextView textView = convertView.findViewById(android.R.id.text1);
//        textView.setText(items.get(position));
//        textView.setTextColor(textColor);
//        return convertView;
//    }
//
//    @Override
//    public View getDropDownView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_dropdown_item, parent, false);
//        }
//        TextView textView = convertView.findViewById(android.R.id.text1);
//        textView.setText(items.get(position));
//        textView.setTextColor(textColor);
//        return convertView;
//    }
//}