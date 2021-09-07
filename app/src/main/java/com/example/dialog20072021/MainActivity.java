package com.example.dialog20072021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnAlertDialog;
    int mIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonAlertDialog);

        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Đường");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);

                String[] arraySugar = {"50%","60%","70%","80%","90%","100%"};

                builder.setSingleChoiceItems(arraySugar, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mIndex = i;
                    }
                });

                // Positive button (tích cực như đồng ý hoặ có)
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, arraySugar[mIndex], Toast.LENGTH_SHORT).show();
                    }
                });

                // Negative Button (tiêu cực như là hủy hoặc không đồng ý)
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mIndex = -1;
                        Toast.makeText(MainActivity.this, "Bạn chưa chọn", Toast.LENGTH_SHORT).show();
                    }
                });
//
//                // Neutral button (chưa xác định)
//                builder.setNeutralButton("Chưa xác định", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });

                builder.show();

            }
        });
    }
}