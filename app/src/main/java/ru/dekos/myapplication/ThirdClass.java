package ru.dekos.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ThirdClass extends AppCompatActivity {
    EditText editText2;
    Button button3;

    String string;
    int res1=1;
    int kelt=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdmain);

        editText2 = (EditText) findViewById(R.id.editText2);
        button3 = (Button) findViewById(R.id.button3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            string = extras.getString("pass2");

        }

        editText2.setText(string);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("pass3",editText2.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
