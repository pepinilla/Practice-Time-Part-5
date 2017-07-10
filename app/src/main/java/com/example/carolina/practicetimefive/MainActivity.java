package com.example.carolina.practicetimefive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    FileHelper fileHelper;
    ActivityHelper activityHelper = new ActivityHelper();
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @Bind(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked(View v) {
        String xml = fileHelper.readFileFromAssets(this, "data.xml");
     //   text.setText(xml);

        MyPullParser parser = new MyPullParser();
        List <Product> products = parser.parseXML(xml);
        text.append("THere are " + products.size() + " products\n");

        for (Product product:products) {
            StringBuilder builder = new StringBuilder(product.getName())
                    .append(" (")
                    .append(product.getPrice())
                    .append(" )");
            text.append(builder.toString());
        }


    }


}
