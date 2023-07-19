package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Hoadondien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadondien);
        Button btntinhtien = findViewById(R.id.btn_tinhtien);
        Button btntinhlai = findViewById(R.id.btn_tinhlai);
        Button btnthoat = findViewById(R.id.btn_thoat);
        EditText txthoten = findViewById(R.id.txt_hoten);
        EditText txtcstt = findViewById(R.id.txt_cstt);
        EditText txtcstn = findViewById(R.id.txt_cstn);
        TextView txtthanhtien = findViewById(R.id.txt_thanhtien);
        CheckBox VAT = findViewById(R.id.chboxVAT);
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });
        VAT.setChecked(true);
        btntinhtien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtcstt.getText().toString().isEmpty() || txtcstn.getText().toString().isEmpty() ||
                        txthoten.getText().toString().isEmpty())
                {
                    Toast.makeText(Hoadondien.this, "Không được để trống thông tin!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    float cstt = Float.parseFloat(txtcstt.getText().toString());
                    float cstn = Float.parseFloat(txtcstn.getText().toString());
                    float sodien = cstn - cstt;
                    float thanhtien = (float) (2500* (sodien + sodien * 0.1));
                    txtthanhtien.setText("" + thanhtien);
                }

            }
        });
        btntinhlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txthoten.setText("");
                txtcstt.setText("");
                txtcstn.setText("");
                txtthanhtien.setText("");
            }
        });
    }
}