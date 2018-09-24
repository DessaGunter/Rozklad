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
import android.widget.ScrollView;
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

    List<FindByGroupGesult> rezList;
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
                    rezList =response.body();
                    myTabl();
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
 }


void myTabl(){


    TableLayout tableLayout = new TableLayout(this);
    tableLayout.setLayoutParams(new TableLayout.LayoutParams(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
    ));
    tableLayout.setStretchAllColumns(true);
    TextView textView1 = new TextView(this); textView1.setText("# / Ауд");
    TextView textView2 = new TextView(this); textView2.setText("Предмет\nВикладач");
    TableRow tableRow1 = new TableRow(this);
    tableRow1.setBackgroundColor(0xFFFF0000);
    tableRow1.addView(textView1);
    tableRow1.addView(textView2);

    tableLayout.addView(tableRow1);

    for (FindByGroupGesult x:rezList){
    TableRow tableRow01 = new TableRow(this);
    TableRow tableRow02 = new TableRow(this);
    TextView textView01 = new TextView(this);   textView01.setText(x.getN_para());
    TextView textView02 = new TextView(this);   textView02.setText(x.getPredmet());
    TextView textView03 = new TextView(this);   textView03.setText(x.getAud());
    TextView textView04 = new TextView(this);   textView04.setText(x.getTeach());
    tableRow01.addView(textView01);    tableRow01.addView(textView02);
    tableRow02.addView(textView03);    tableRow02.addView(textView04);
    tableLayout.addView(tableRow01); tableLayout.addView(tableRow02);
    tableRow01.setBackgroundColor(0xffcccccc);
        //ScrollView scrV = new ScrollView();
        tableLayout.setScrollContainer(true);
    setContentView(tableLayout);
}
}}

