package com.example.ghifary.temperatur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText suhu_awal;
    Spinner jenis_konversi;
    Button clear, hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        suhu_awal = (EditText) findViewById(R.id.suhu_awal);
        jenis_konversi = (Spinner) findViewById(R.id.jenis_konversi);
        clear = (Button) findViewById(R.id.clear);
        hitung = (Button) findViewById(R.id.hitung);
        hasil = (TextView) findViewById(R.id.hasil);
        clear.setOnClickListener(this);
        hitung.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clear:
                suhu_awal.setText("");
                hasil.setText("");
                break;

            case R.id.hitung:
                    String text = suhu_awal.getText().toString();
                    if (text.isEmpty()){
                        Toast.makeText(MainActivity.this, "Suhu awal masih kosong", Toast.LENGTH_SHORT).show();
                    } else {
                        double suhu = Double.parseDouble(text);
                        int posisi = jenis_konversi.getSelectedItemPosition();
                        switch (posisi){
                            case 0:
                                Celcius suhu1 = new Celcius();
                                hasil.setText("Hasil Konversi :" + suhu1.calculateSuhu1(suhu));
                                break;
                            case 1:
                                Celcius suhu2 = new Celcius();
                                hasil.setText("Hasil Konversi :" + suhu2.calculateSuhu2(suhu));
                                break;
                            case 2:
                                Celcius suhu3 = new Celcius();
                                hasil.setText("Hasil Konversi :" + suhu3.calculateSuhu3(suhu));
                                break;
                            case 3:
                                Reamur reamur1 = new Reamur();
                                hasil.setText("Hasil Konversi :" + reamur1.calculateSuhu2(suhu));
                                break;
                            case 4:
                                Reamur reamur2 = new Reamur();
                                hasil.setText("Hasil Konversi :" + reamur2.calculateSuhu2(suhu));
                                break;
                            case 5:
                                Reamur reamur3 = new Reamur();
                                hasil.setText("Hasil Konversi :" + reamur3.calculateSuhu2(suhu));
                                break;
                            case 6:
                                Fahrenheit fht1 = new Fahrenheit();
                                hasil.setText("Hasil Konversi :" + fht1.calculateSuhu2(suhu));
                                break;
                            case 7:
                                Fahrenheit fht2 = new Fahrenheit();
                                hasil.setText("Hasil Konversi :" + fht2.calculateSuhu2(suhu));
                                break;
                            case 8:
                                Fahrenheit fht3 = new Fahrenheit();
                                hasil.setText("Hasil Konversi :" + fht3.calculateSuhu2(suhu));
                                break;
                            case 9:
                                Kelvin kelvin1 = new Kelvin();
                                hasil.setText("Hasil Konversi :" + kelvin1.calculateSuhu2(suhu));
                                break;
                            case 10:
                                Kelvin kelvin2 = new Kelvin();
                                hasil.setText("Hasil Konversi :" + kelvin2.calculateSuhu2(suhu));
                                break;
                            case 11:
                                Kelvin kelvin3 = new Kelvin();
                                hasil.setText("Hasil Konversi :" + kelvin3.calculateSuhu2(suhu));
                                break;

                        }

                    }
        }
    }
}
