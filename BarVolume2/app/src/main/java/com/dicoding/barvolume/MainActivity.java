package com.dicoding.barvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText edtWidth;
    EditText edtHeight;
    EditText edtLength;
    Button btnCalculate;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth= (EditText) findViewById(R.id.edt_width);
        edtHeight= (EditText) findViewById(R.id.edt_height);
        edtLength = (EditText) findViewById(R.id.edt_length);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_calculate){
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if(TextUtils.isEmpty(inputLength)){
                isEmptyFields =true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(inputWidth)){
                isEmptyFields=true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(inputHeight)){
                isEmptyFields=true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }

            Double length = toDouble(inputLength);
            Double width= toDouble(inputWidth);
            Double height =toDouble(inputHeight);

            if(length==null){
                isInvalidDouble=true;
                edtLength.setError("Field ini harus berupa nomor yang valid");
            }

            if(width==null){
                isInvalidDouble=true;
                edtHeight.setError("Field ini harus berupa nomor yang valid");
            }

            if(height==null){
                isInvalidDouble=true;
                edtHeight.setError(("Field ini harus berupa nomor yang valid"));
            }
            if(!isEmptyFields && !isInvalidDouble){
                double volume = length * width * height;

                tvResult.setText("Field ini harus berupa nomor yang valid");
            }
        }
    }
    Double toDouble(String str){
        try{
            return Double.valueOf(str);
        } catch(NumberFormatException e){
            return null;
        }
    }
}
