package com.when.threemb.portfolio;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Academics();
        Skills();
        Projects();
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    public void Call1(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "+919748930503"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void Call2(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "+919331965610"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    public void emailFunction(View view) {
        String st[]={"aman.khandelwal.howrah@gmail.com"};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL,st);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void Academics()
    {
        final ListView lv=(ListView)findViewById(R.id.listview1);
        ArrayList<Qualification> qual=new ArrayList<>();
        qual.add(new Qualification("University: Autonomous since 2014","Bachelor of Technology\nSpecialization in Information Technology\n(Pursuing)","Heritage Institute of Technology","Year: appearing final examination in 2019"));
        qual.add(new Qualification("Board: AISSCE","Higher Secondary Examination","Hariyana Vidya Mandir","Year: 2015"));
        qual.add(new Qualification("Board: CISCE","Secondary Examination","M.C.Kejriwal Vidyapeeth","Year: 2013"));
        QualificationAdapter adapter= new QualificationAdapter(this,0,qual);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ScrollingActivity.this);
                alertDialogBuilder.setTitle("Scored");
                switch (position)
                {
                    case 0:
                        alertDialogBuilder.setTitle("CGPA");
                        alertDialogBuilder.setMessage("\n 1st Semester : 8.37\n 2nd Semester : 8.52\n 3rd Semester : 7.86\n 4th Semester : 8.37");

                        break;
                    case 1:
                        alertDialogBuilder.setTitle("Percentage");
                        alertDialogBuilder.setMessage("78.6%");

                        break;
                    case 2:
                        alertDialogBuilder.setTitle("Percentage");
                        alertDialogBuilder.setMessage("92.9%");

                        break;
                }
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        lv.setVisibility(View.GONE);
    }

    public void Skills()
    {
        final ListView lv=(ListView)findViewById(R.id.listview2);
        ArrayList<String> qual=new ArrayList<>(Arrays.asList("Java","Android App development using Java and XML",
                "Beginner on Neural Networks and Deep Learning","Beginner level Machine Learning","Python","C","C++",
                "HTML","CSS","Bootstrap","Javascript","JQuery","Basic Node JS","Basic PHP","MySQLite Database Management","MongoDB","Firebase"));
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.single_item, qual);
        lv.setAdapter(listAdapter);
        lv.setVisibility(View.GONE);
    }

    public void Projects()
    {
        final ListView lv=(ListView)findViewById(R.id.listview3);
        ArrayList<String> qual=new ArrayList<>(Arrays.asList("Sudoku (Android App)","Hulladek Recycling Pvt. Ltd. (Website)","When (Android App)"));
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.single_item, qual);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri;
                Intent goToMarket;
                switch (position)
                {
                    case 0:
                         uri = Uri.parse("https://play.google.com/store/apps/details?id=com.threemb.rohitagarwal.sudoku&hl=en");
                         goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                        // To count with Play market backstack, After pressing back button,
                        // to taken back to our application, we need to add following flags to intent.
                        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        try {
                            startActivity(goToMarket);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://play.google.com/store/apps/details?id=com.threemb.rohitagarwal.sudoku&hl=en")));
                        }
                        break;
                    case 1:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hulladek.in/"));
                        startActivity(browserIntent);
                        break;
                    case 2:
                         uri = Uri.parse("https://play.google.com/store/apps/details?id=com.when.threemb.when&hl=en");
                         goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                        // To count with Play market backstack, After pressing back button,
                        // to taken back to our application, we need to add following flags to intent.
                        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        try {
                            startActivity(goToMarket);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://play.google.com/store/apps/details?id=com.when.threemb.when&hl=en")));
                        }
                        break;
                }
            }
        });
        lv.setVisibility(View.GONE);
    }

    public void academic_qual(View view)
    {
        final ListView lv=(ListView)findViewById(R.id.listview1);
        lv.setVisibility(lv.isShown()?View.GONE:View.VISIBLE);
        final TextView tv2=(TextView) findViewById(R.id.tag2);
        String s="Academic Qualifications";
        if(!lv.isShown())
            s+="  ▼";
        else
            s+="  ▲";
        tv2.setText(s);
    }
    public void skill_set(View view)
    {
        final ListView lv=(ListView)findViewById(R.id.listview2);
        lv.setVisibility(lv.isShown()?View.GONE:View.VISIBLE);
        final TextView tv2=(TextView) findViewById(R.id.tag3);
        String s="Technical Skills";
        if(!lv.isShown())
            s+="  ▼";
        else
            s+="  ▲";
        tv2.setText(s);
    }
    public void project_set(View view)
    {
        final ListView lv=(ListView)findViewById(R.id.listview3);
        lv.setVisibility(lv.isShown()?View.GONE:View.VISIBLE);
        final TextView tv2=(TextView) findViewById(R.id.tag4);
        String s="Projects";
        if(!lv.isShown())
            s+="  ▼";
        else
            s+="  ▲";
        tv2.setText(s);
    }
    public void career_obj(View view)
    {
        final TextView tv=(TextView) findViewById(R.id.CObj);
        tv.setVisibility(tv.isShown()?View.GONE:View.VISIBLE);
        final TextView tv2=(TextView) findViewById(R.id.tag1);
        String s="Career Objective";
        if(!tv.isShown())
            s+="  ▼";
        else
            s+="  ▲";
        tv2.setText(s);
    }
    public void personalDetails(View view)
    {
        final LinearLayout tv=(LinearLayout)findViewById(R.id.pDetails);
        tv.setVisibility(tv.isShown()?View.GONE:View.VISIBLE);
        final TextView tv2=(TextView) findViewById(R.id.tag0);
        String s="Personal Details";
        if(!tv.isShown())
            s+="  ▼";
        else
            s+="  ▲";
        tv2.setText(s);
    }

}
