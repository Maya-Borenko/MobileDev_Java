package com.example.calc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.example.calc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myLogs";
    private ActivityMainBinding binding;
    private String correct;
    private static final int CONTENT_VIEW_ID = 10101010;
    ActivityResultLauncher<Intent> startSecondActivityForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if (o.getResultCode() == Activity.RESULT_OK) {
                Intent intent = o.getData();
                if (intent != null) {
                    binding.res.setText(correct);
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.num.setShowSoftInputOnFocus(false);
        binding.step.setShowSoftInputOnFocus(false);
        Intent intent = new Intent(this, SecondActivity.class);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.info.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                            }
                                        });

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("0");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("0");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("0");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("0");
//                }
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("1");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("1");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("1");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("1");
//                }
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("2");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("2");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("2");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("2");
//                }
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("3");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("3");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("3");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("3");
//                }
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("4");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("4");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("4");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("4");
//                }
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("5");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("5");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("5");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("5");
//                }
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    binding.num.append("6");
                if (binding.num.hasFocus()){
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("6");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("6");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("6");
//                }
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("7");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("7");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("7");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("7");
//                }
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("8");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("8");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("8");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("8");
//                }
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.num.hasFocus()){
                    binding.num.append("9");
                }
                else if (binding.step.hasFocus()){
                    binding.step.append("9");
                }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).append("9");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("9");
//                }
            }
        });
        binding.btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.step.hasFocus()){
                    ((TextView)binding.step).append("/");
                }
//                if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).append("/");
//                }
            }
        });
        binding.btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int number = Integer.parseInt(String.valueOf(((TextView)binding.fragment2.findViewById(R.id.num)).getText()));
//                String[] powerAll = String.valueOf(((TextView)binding.fragment2.findViewById(R.id.step)).getText()).split("/");
                int number = Integer.parseInt(String.valueOf(((TextView)binding.num).getText()));
                String[] powerAll = String.valueOf(((TextView)binding.step).getText()).split("/");
                double power1 = Integer.parseInt(powerAll[0]);
                String ans = "";
                if (powerAll.length > 1) {
                    double power2 = Integer.parseInt(powerAll[1]);
                    if (power2!=0){
                         if ((power2%2==0 && number >=0) || power2%2!=0 || (number == 0 && power1/power2 > 0)) {
                             ans = String.valueOf(Math.pow(number, power1 / power2));
                         }
                         else {
                             ans = "Ошибка!";
                         }
                    }
                    else{
                        ans = "Ошибка!";
                        correct = "Деление на ноль!";
                    }
                }
                else{
                    if (number == 0 && power1 <= 0) {
                        ans = "Ошибка!";
                        correct = "Ноль в нулевой!";
                    }
                    else {
                        ans = String.valueOf(Math.pow(number, power1));
                        correct = "Ошибки нет";
                    }
                }
                //((TextView) binding.fragment2.findViewById(R.id.res)).setText(ans);
                intent.putExtra("Result", ans);
                startSecondActivityForResult.launch(intent);
            }
        });
        binding.btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (binding.num.hasFocus()){
                        binding.num.setText("-");
                    }
                    else if (binding.step.hasFocus()) {
                        binding.step.setText("-");
                    }
//                if ((binding.fragment2.findViewById(R.id.num)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.num)).setText("-");
//                }
//                else if ((binding.fragment2.findViewById(R.id.step)).hasFocus()){
//                    ((TextView)binding.fragment2.findViewById(R.id.step)).setText("-");
//                }
            }
        });
        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.num.setTextColor(Color.BLACK);
                binding.step.setTextColor(Color.BLACK);
                binding.num.setText("");
                binding.step.setText("");
                binding.res.setText("");
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.progInfo) {
            Toast.makeText(this, "Калькулятор степеней", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.authorInfo) {
            Toast.makeText(this, "Боренко М. Д., ИКБО-03-22", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.exit){
            showDialog();
            return true;
        }
        else if (id == android.R.id.home)
            NavUtils.navigateUpFromSameTask(this);
        return true;
    }

    public void showDialog(){
        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.show(getSupportFragmentManager(), "custom");
    }

}