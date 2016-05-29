package ru.dekos.myapplication;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SecondClass extends AppCompatActivity{


    EditText editText;

    ImageButton imageButton4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);


        editText = (EditText) findViewById(R.id.editText);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);


        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("pass",editText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();

            }
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data!=null){
            editText.setText(data.getStringExtra("pass2"));
        }
    }
}
