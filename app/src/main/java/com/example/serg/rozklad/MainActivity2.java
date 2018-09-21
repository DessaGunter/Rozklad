package com.example.serg.rozklad;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String gr = getIntent().getStringExtra("GR");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //========================================================================================
        double version = 0.1;
        String url;
        url = "http://ftl92.esy.es/index.php/api/findbygroup";
        String [] fields = {
                "group:"+gr+";"
                // ,"data:12.09.2018;"
        };
        ConnectionFactory connection = new ConnectionFactory(fields,url,version);
       // System.out.println("-----=>");
        String response = connection.buildConnection();
        System.out.println(gr+"-->>>\n"+response);
        //System.out.println(new Parser().getParaList(response));
        //----------------------------------------------------------------------------------------





        myTabl(gr);
    }
void myTabl(String gr){









    TableLayout tableLayout = new TableLayout(this);
    tableLayout.setLayoutParams(new TableLayout.LayoutParams(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
    ));
    tableLayout.setStretchAllColumns(true);

    TextView textView1 = new TextView(this);
    textView1.setText(gr);
    TextView textView2 = new TextView(this);
    textView2.setText("Column 2");
    TextView textView3 = new TextView(this);
    textView3.setText("Column 3");

    TextView textView4 = new TextView(this);
    textView4.setText(gr);
    TextView textView5 = new TextView(this);
    textView5.setText("Column 5");
    TextView textView6 = new TextView(this);
    textView6.setText("Column 6");

    TextView textView7 = new TextView(this);
    textView7.setText(gr);
    TextView textView8 = new TextView(this);
    textView8.setText("Column 8");
    TextView textView9 = new TextView(this);
    textView9.setText("Column 9");

    TableRow tableRow1 = new TableRow(this);
    TableRow tableRow2 = new TableRow(this);
    TableRow tableRow3 = new TableRow(this);

    tableRow1.addView(textView1);
    tableRow1.addView(textView2);
    tableRow1.addView(textView3);

    tableRow2.setBackgroundColor(0xffcccccc);
    tableRow2.addView(textView4);
    tableRow2.addView(textView5);
    tableRow2.addView(textView6);

    tableRow3.addView(textView7);
    tableRow3.addView(textView8);
    tableRow3.addView(textView9);

    tableLayout.addView(tableRow1);
    tableLayout.addView(tableRow2);
    tableLayout.addView(tableRow3);
    setContentView(tableLayout);
}
}

