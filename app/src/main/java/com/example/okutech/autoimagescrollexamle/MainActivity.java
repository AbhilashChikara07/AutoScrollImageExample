package com.example.okutech.autoimagescrollexamle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageScrollPageAdaptor adaptor;
    private AutoScrollViewPager autoScrollViewPage;
    private ArrayList<String> mList = new ArrayList<>();
    private CirclePageIndicator indicator;
    private Button nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i <= 5; i++) {
            mList.add("TEXT or IMAGE can be anything");
        }

        autoScrollViewPage = (AutoScrollViewPager) findViewById(R.id.autoScrollViewPage);
        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoScrollViewPage.scrollOnce();
            }
        });

        autoScrollViewPage.setOffscreenPageLimit(mList.size());
        adaptor = new ImageScrollPageAdaptor(this, mList);
        autoScrollViewPage.setAdapter(adaptor);
        setUpAutoScrollingWithIndicator();
    }

    public void setUpAutoScrollingWithIndicator() {

        autoScrollViewPage.setInterval(5000);
        autoScrollViewPage.startAutoScroll();
        autoScrollViewPage.setBorderAnimation(true);
        autoScrollViewPage.setAutoScrollDurationFactor(4);
        indicator.setFillColor(this.getResources().getColor(R.color.color_primary_blue_dark));
        indicator.setPageColor(this.getResources().getColor(android.R.color.white));
        indicator.setStrokeWidth(0);
        indicator.setStrokeColor(this.getResources().getColor(android.R.color.transparent));
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, this.getResources().getDisplayMetrics());
        indicator.setRadius(px);
        indicator.setViewPager(autoScrollViewPage);

    }

}
