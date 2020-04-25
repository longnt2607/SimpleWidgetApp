package vn.edu.ntu.nguyentruonglong.simplewidgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtKetQua;
    EditText numbA, numbB;
    RadioGroup rdgPhepTinh;
    Button btnTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addViews() {
        txtKetQua = findViewById(R.id.txtKetQua);
        numbA = findViewById(R.id.numbA);
        numbB = findViewById(R.id.numbB);
        rdgPhepTinh = findViewById(R.id.rdbPhepTinh);
        btnTinh = findViewById(R.id.btnTinh);
    }

    private void addEvents() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan();
            }
        });
    }

    private void tinhToan() {
        float soA = Float.parseFloat(numbA.getText().toString());
        float soB = Float.parseFloat(numbB.getText().toString());
        float kq;
        switch (rdgPhepTinh.getCheckedRadioButtonId()) {
            case R.id.rdbCong:
                kq = soA + soB;
                txtKetQua.setText(new Float(kq).toString());
                break;
            case R.id.rdbTru:
                kq = soA - soB;
                txtKetQua.setText(new Float(kq).toString());
                break;
            case R.id.rdbNhan:
                kq = soA * soB;
                txtKetQua.setText(new Float(kq).toString());
                break;
            case R.id.rdbChia:
                try {
                    kq = soA / soB;
                    txtKetQua.setText(new Float(kq).toString());
                } catch (Exception ex) {
                    txtKetQua.setText("Không chia được cho số 0");
                }
                break;
        }
    }
}
