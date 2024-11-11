package com.example.pr4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String[] name = {"Киса", "Мося", "Кеша", "Рыжий", "Саймон", "Рокки", "Гудвин", "Том", "Эфи", "Китти", "Алан", "Аби", "Абу"};
    String[] breed = {"Мейн-кун", "Сфинкс", "Норвежская", "Б/п", "Манчкин", "Персидская", "Британская", "Бенгальская", "Британская", "Сфинкс", "Мейн-кун", "Вислоухая", "Персидская"};
    int age[] = {1, 10, 5, 17, 2, 8, 3, 8, 10, 2, 4, 6, 7};
    int[] colors = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < name.length; i++){
            View item = ltInflater.inflate(R.layout.item, linLayout, false);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(name[i]);
            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText("Порода: "+breed[i]);
            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            tvSalary.setText("Возраст: "+String.valueOf(age[i]));
            item.getLayoutParams().width = RelativeLayout.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i%2]);
            linLayout.addView(item);
        }
    }
}