package com.samsolution.custombottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior<LinearLayout> bottomSheetBehavior;                                  // BottomSheet Instance
    LinearLayout bottomsheetlayout;
    String[] list = {"A", "B", "C", "D", "A", "B", "C", "D","A", "B", "C", "D","A", "B", "C", "D","A", "B", "C", "D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomsheetlayout = findViewById(R.id.bottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheetlayout);

        ListView listView = findViewById(R.id.homeCountryList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        bottomSheetHide();                                                                          //BottomSheet get hide first time

        RelativeLayout minimizeLayoutIV;                                                            // It will hide the bottomSheet Layout
        minimizeLayoutIV = findViewById(R.id.minimizeLayout);
        minimizeLayoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               bottomSheetHide();
            }
        });
    }

    public void showCountryListFromBottomSheet(View view) {
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public void bottomSheetHide(){
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
}
