package com.example.ankitkumar.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar tableCount;
    ListView tableList;

    public void setTableContent(int tableNo){
        if(tableNo==0) tableNo++;
        ArrayList<Integer> tableof = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            tableof.add((i+1)*tableNo);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,tableof);
        tableList.setAdapter(adapter);
    }

    public void setMax(View view){
        int max = Integer.parseInt(((EditText)findViewById(R.id.editText2)).getText().toString());
        tableCount.setMax(max);
        tableCount.setProgress(max);
        setTableContent(max);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableCount = (SeekBar)findViewById(R.id.seekBar);
        tableList = (ListView)findViewById(R.id.listView);

        tableCount.setMax(25);
        tableCount.setProgress(17);
        setTableContent(17);

        tableCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setTableContent(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
