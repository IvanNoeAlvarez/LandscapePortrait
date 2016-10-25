package com.example.ivalion.landscapeportrait;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class subActivity extends AppCompatActivity {

    Button btn_cont;
    TextView tv_nom;
    EditText et_num;
    Bundle b;
    Intent i,data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        i = new Intent();
        data = getIntent();

        tv_nom = (TextView)findViewById(R.id.tv_nom);

        Bundle b2 = data.getExtras();
        String nombre = b2.getString("nom");
        tv_nom.setText(" "+nombre);


        et_num = (EditText)findViewById(R.id.et_edat);

        btn_cont = (Button)findViewById(R.id.btn_ok);
        btn_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_num.getText().toString().isEmpty()) {
                    b = new Bundle();
                    b.putString("edat", et_num.getText().toString());
                    i.putExtras(b);
                    setResult(RESULT_OK,i);
                    finish();
                }else
                    Toast.makeText(subActivity.this,"Rellena la edad",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
