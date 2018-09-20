package com.example.serg.rozklad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class Rozklad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rozklad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rozklad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.act11A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "11А");
            startActivity(intent); return true;  }
        if (id == R.id.act11B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "11Б");
            startActivity(intent); return true;  }
        if (id == R.id.act12A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "12А");
            startActivity(intent); return true;  }
        if (id == R.id.act12B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "12Б");
            startActivity(intent); return true;  }
        if (id == R.id.act13A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "13А");
            startActivity(intent); return true;  }
        if (id == R.id.act13B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "13Б");
            startActivity(intent); return true;  }
        if (id == R.id.act21A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "21А");
            startActivity(intent); return true;  }
        if (id == R.id.act21B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "21Б");
            startActivity(intent); return true;  }
        if (id == R.id.act22A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "22А");
            startActivity(intent); return true;  }
        if (id == R.id.act22B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "22Б");
            startActivity(intent); return true;  }
        if (id == R.id.act23A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "23А");
            startActivity(intent); return true;  }
        if (id == R.id.act23B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "23Б");
            startActivity(intent); return true;  }
        if (id == R.id.act31A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "31А");
            startActivity(intent); return true;  }
        if (id == R.id.act31B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "31Б");
            startActivity(intent); return true;  }
        if (id == R.id.act32A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "32А");
            startActivity(intent); return true;  }
        if (id == R.id.act32B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "32Б");
            startActivity(intent); return true;  }
        if (id == R.id.act33A) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "33А");
            startActivity(intent); return true;  }
        if (id == R.id.act33B) {Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("GR", "33Б");
            startActivity(intent); return true;  }




        return super.onOptionsItemSelected(item);
    }
}
