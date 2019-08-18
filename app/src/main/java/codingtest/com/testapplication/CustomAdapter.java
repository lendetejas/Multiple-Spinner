package codingtest.com.testapplication;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends ArrayAdapter<String> {

    private ArrayList mData;
    public Resources mResources;
    private LayoutInflater mInflater;


    public CustomAdapter(
            Activity activitySpinner,
            int textViewResourceId,
            ArrayList objects,
            Resources resLocal
    ) {
        super(activitySpinner, textViewResourceId, objects);

        mData = objects;
        mResources = resLocal;
        mInflater = (LayoutInflater) activitySpinner.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = mInflater.inflate(R.layout.custom_spinner_items, parent, false);
        TextView label = (TextView) row.findViewById(R.id.list_item);
        TextView label1 = (TextView) row.findViewById(R.id.textid);
        label.setText(mData.get(position).toString());
        label1.setText(mData.get(position).toString());

        row.setTag(R.string.meta_position, Integer.toString(position));
        row.setTag(R.string.meta_title, mData.get(position).toString());

        return row;
    }
}