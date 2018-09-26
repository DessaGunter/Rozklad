package com.example.serg.rozklad;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.N)
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

String dt[]={"Понеділок","Вівторок","Середа","Четвер","Пятниця","Субота","Неділя","Понеділок"};
    int numberWeek = Calendar.getInstance().getWeekYear();
    TableLayout table = (TableLayout)findViewById(R.id.table);
    TableRow row = (TableRow)findViewById(R.id.row);

    void myTabl() {


// get table row index android.
        int nIndex = table.indexOfChild(row);
        table.removeView(row); // invisible and height == 0
// add row into same place
        table.addView(row, nIndex); // visible

// add row into certain position
        table.addView(row, 3); // visible

// create new TableRow dynamically
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
    }
// create own function for append TableRow
    private void appendRow(TableLayout table) {
        TableRow row = new TableRow(this);

        TextView hLabel = new TextView(this);
        hLabel.setText("Some text");
        hLabel.setPadding(3, 3, 3, 3);

        TextView hNextLabel = new TextView(this);
        hNextLabel.setText("Next text");
        hNextLabel.setPadding(3, 3, 3, 3);
        hNextLabel.setGravity(Gravity.RIGHT | Gravity.TOP);

        row.addView(hLabel, new TableRow.LayoutParams(1));
        row.addView(hNextLabel, new TableRow.LayoutParams());

        table.addView(row, new TableLayout.LayoutParams());
    }



}





