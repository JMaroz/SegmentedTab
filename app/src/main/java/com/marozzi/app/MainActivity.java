package com.marozzi.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.marozzi.segmentedtab.SegmentedGroup;
import com.marozzi.segmentedtab.SegmentedTab;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((SegmentedGroup) findViewById(R.id.group)).setOnSegmentedGroupListener(new SegmentedGroup.OnSegmentedGroupListener() {
            @Override
            public void onSegmentedTabSelected(SegmentedTab tab, int checkedId) {
                Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
