package com.example.ivalion.landscapeportrait;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Portrait extends AppCompatActivity {

    Button bt_env;
    EditText et_nom;
    TextView tv_edat, tv_frase, tv_com;
    RadioButton rb_m, rb_f;
    Intent i;
    Bundle b, b2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


        et_nom = (EditText) findViewById(R.id.et_Nom);
        tv_edat = (TextView) findViewById(R.id.tv_edat);
        tv_frase = (TextView) findViewById(R.id.tv_frase);
        rb_m = (RadioButton) findViewById(R.id.rb_masc);
        rb_f = (RadioButton) findViewById(R.id.rb_fem);
        bt_env = (Button) findViewById(R.id.btn_enviar);
        tv_com = (TextView) findViewById(R.id.tv_com);


        if (savedInstanceState != null) {

            String com = savedInstanceState.getString("com");
            tv_com.setText(com);
            String edad = savedInstanceState.getString("edad");
            tv_edat.setText(edad);
            String frase = savedInstanceState.getString("frase");
            tv_frase.setText(frase);
        }
        bt_env.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(getApplicationContext(), subActivity.class);
                b = new Bundle();
                b.putString("nom", et_nom.getText().toString());
                i.putExtras(b);

                startActivityForResult(i, 1);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            tv_com = (TextView) findViewById(R.id.tv_com);
            tv_com.setVisibility(View.VISIBLE);
            b2 = data.getExtras();
            int edad = Integer.parseInt(b2.getString("edat"));
            if (edad < 0)
                edad = edad * (-1);
            tv_edat.setText(" " + edad + " ");
            if (edad < 18)
                tv_frase.setText("");
            else if (edad > 18 && edad < 25)
                tv_frase.setText(R.string.frase18a);
            else if (edad >= 25 && edad < 35)
                tv_frase.setText(R.string.frase25a);
            else if (edad > 35)
                tv_frase.setText(R.string.frase35a);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        tv_com = (TextView) findViewById(R.id.tv_com);
        tv_edat = (TextView) findViewById(R.id.tv_edat);
        tv_frase = (TextView) findViewById(R.id.tv_frase);

        outState.putString("com", tv_com.getText().toString());
        outState.putString("edad", tv_edat.getText().toString());
        outState.putString("frase", tv_frase.getText().toString());

        tv_com.setVisibility(View.VISIBLE);

        super.onSaveInstanceState(outState);

    }
}

