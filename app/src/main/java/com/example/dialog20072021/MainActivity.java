package com.example.dialog20072021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button mBtnAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonAlertDialog);

        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void openAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thực đơn");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);


        String[] arrayFood = {"Gà","Mỳ Ý","Nước ngọt","Salad"};

        boolean[] arrayChecked = new boolean[arrayFood.length];

        builder.setMultiChoiceItems(arrayFood, arrayChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });

        // Positive button (tích cực như đồng ý hoặ có)
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int y = 0; y < arrayChecked.length; y++) {
                    if(arrayChecked[y]){
                        stringBuilder.append(arrayFood[y] + ", ");
                    }
                }
                stringBuilder.delete(stringBuilder.length() - 2 , stringBuilder.length() - 1);
                Toast.makeText(MainActivity.this, "Order của bạn là " +stringBuilder.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Negative Button (tiêu cực như là hủy hoặc không đồng ý)
//                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        mIndex = -1;
//                        Toast.makeText(MainActivity.this, "Bạn chưa chọn", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                // Neutral button (chưa xác định)
//                builder.setNeutralButton("Chưa xác định", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });

        builder.show();

        // Thực đơn
        // Gà
        // mỳ ý
        // nước ngọt
        // salad
        // ...
    }
}