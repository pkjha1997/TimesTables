package pkjha1997.timestables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);

        seekBar.setMax(20);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (progress < min){
                    timesTable = min;
                    seekBar.setProgress(min);
                } else {
                    timesTable = progress;
                }
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);

    }
    public void generateTimesTable(int timesTable) {

        ArrayList<String> timesTableContent = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            timesTableContent.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        listView.setAdapter(mArrayAdapter);
    }
}
