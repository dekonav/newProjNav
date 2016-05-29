package ru.dekos.myapplication;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.FragmentActivity;
        import android.support.v7.app.AppCompatActivity;
        import android.util.SparseBooleanArray;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageButton imageButton,imageButton2,imageButton3;
    public List<String> list = new ArrayList();
    public int kit=0;
    ListView listView;
    ArrayAdapter<String> adapter;
    String strg="serrga";
    final int red = 1;
    final int newr = 2;
    int posit=0;
    boolean Nexter = true;
    SparseBooleanArray sbArr;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);



        button = (Button) findViewById(R.id.button);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondClass.class);
                startActivityForResult(intent,1);
            }
        });
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,list);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Nexter) {
                    Intent intentv = new Intent(getApplicationContext(), ThirdClass.class);
                    intentv.putExtra("pass2", list.get(position).toString());
                    posit = position;
                    startActivityForResult(intentv, 2);
                }
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            strg = extras.getString("pass3");
        }


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_multiple_choice,list);
                listView.setAdapter(adapter);
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                listView.setSelected(true);
                Nexter=false;
                imageButton.setVisibility(View.VISIBLE);
                imageButton3.setVisibility(View.VISIBLE);

                sbArr = listView.getCheckedItemPositions();

                Toast.makeText(getApplicationContext(),"Редактор открыт",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_selectable_list_item,list);
                listView.setAdapter(adapter);
                Nexter=true;
                imageButton.setVisibility(View.INVISIBLE);
                imageButton3.setVisibility(View.INVISIBLE);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<sbArr.size();i++){
                    int key=sbArr.keyAt(i);
                    if(sbArr.get(key)){
                        list.remove(key);
                        listView.setAdapter(adapter);
                    }
                }

            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            switch (requestCode) {
                case 1:
                    list.add(data.getStringExtra("pass"));
                    listView.setAdapter(adapter);
                    break;
                case 2:
                    list.set(posit,data.getStringExtra("pass3"));
                    listView.setAdapter(adapter);
                    break;
            }
        }


    }



}
