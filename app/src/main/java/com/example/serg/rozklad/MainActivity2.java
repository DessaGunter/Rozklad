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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        final Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ftl92.esy.es/index.php/") // Адрес сервера
                .addConverterFactory(GsonConverterFactory.create()) // говорим ретрофиту что для сериализации необходимо использовать GSON
                .build();

        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("group", gr);

        Server service = retrofit.create(Server.class);
        Call<List<FindByGroupGesult>> call = service.findbygroup(postDataParams);
        call.enqueue(new Callback<List<FindByGroupGesult>>() {
            @Override
            public void onResponse(Call<List<FindByGroupGesult>> call, Response<List<FindByGroupGesult>> response) {
                if (response.isSuccessful()) {
                    System.out.println("Все ОК");// запрос выполнился успешно, сервер вернул Status 200
                    List<FindByGroupGesult> rezList =response.body();
            for (FindByGroupGesult x:rezList)
                    System.out.println("--->>>>"+x+"\n");




                } else {
                    System.out.println("Помилка сервера");// сервер вернул ошибку
                }
            }

            @Override
            public void onFailure(Call<List<FindByGroupGesult>> call, Throwable t) {
                System.out.println("Помилка запиту");// ошибка во время выполнения запроса
            }
        });


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

