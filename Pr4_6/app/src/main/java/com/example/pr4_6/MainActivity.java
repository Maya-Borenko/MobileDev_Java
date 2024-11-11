package com.example.pr4_6;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;
    View header1, header2, footer1, footer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header1 = createHeader("header 1");
        //header2 = createHeader("header 2");
        footer1 = createFooter("footer 1");
        //footer2 = createFooter("footer 2");
        fillData();
        boxAdapter = new BoxAdapter(this, products);
        ListView lvMain = findViewById(R.id.lvMain);
        lvMain.addHeaderView(header1);
        //lvMain.addHeaderView(header2, "some text for header 2", false);
        lvMain.addFooterView(footer1);
        //lvMain.addFooterView(footer2, "some text for footer 2", false);
        lvMain.setAdapter(boxAdapter);
    }

    private View createHeader(String text) {
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) v.findViewById(R.id.tvText)).setText(text);
        return v;
    }

    private View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        ((TextView) v.findViewById(R.id.tvText)).setText(text);
        return v;
    }

    private void fillData() {
        int[] images = {R.drawable.baseline_perm_media_24, R.drawable.baseline_person_4_24,
                R.drawable.baseline_synagogue_24, R.drawable.baseline_thermostat_24,
                R.drawable.baseline_theater_comedy_24, R.drawable.baseline_water_24,
                R.drawable.baseline_whatshot_24, R.drawable.baseline_wine_bar_24,
                R.drawable.baseline_work_outline_24, R.drawable.ic_launcher_foreground};
        for (int i=1; i <=20; i++){
            products.add(new Product("Product " + i, i*1000, images[i%10], false)); } }
    public void showResult(View v){
        String result = "Товары в корзине: ";
        for (Product p:boxAdapter.getBox()){
            if (p.box)
                result += "\n" + p.name;
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}