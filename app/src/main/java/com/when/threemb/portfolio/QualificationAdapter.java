package com.when.threemb.portfolio;

/**
 * Created by User on 3/25/2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by User on 8/21/2016.
 */
public class QualificationAdapter extends ArrayAdapter<Qualification> {
    TextView tv1,tv2,tv3,tv4;

    public QualificationAdapter(Context context, int resource, List<Qualification> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View listItemView=convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.qualification_list_item,parent,false);
        }
        Qualification currentEarthquake=getItem(position);

        tv1=(TextView)listItemView.findViewById(R.id.tv1);
        tv1.setText(currentEarthquake.getCourse());

        tv2=(TextView)listItemView.findViewById(R.id.tv2);
        tv2.setText(currentEarthquake.getInstitute());

        tv3=(TextView)listItemView.findViewById(R.id.tv3);
        tv3.setText(currentEarthquake.getBoard());

        tv4=(TextView)listItemView.findViewById(R.id.tv4);
        tv4.setText(currentEarthquake.getYear());


        return listItemView;
    }

}
