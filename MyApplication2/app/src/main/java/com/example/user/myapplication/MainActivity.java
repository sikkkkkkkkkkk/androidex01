package com.example.user.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.btn_yes);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.btn_no);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.btn_send);
        button3.setOnClickListener(this);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        checkBox.setOnClickListener(this
        );
    }

    @Override
    public void onClick(View v) {

        String str = new String();

        switch (v.getId()) {

            case R.id.btn_yes:
                str = "\" 예\"버튼을 눌렀습니다.";
                break;
            case R.id.btn_no:
                str = "\" 아니오\"버튼을 눌렀습니다.";
                break;
            case R.id.btn_send:
                str = "\" 전송\"버튼을 눌렀습니다.";

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("전송 문자열");
                EditText editText = (EditText) findViewById(R.id.edittext);
                String dialogStr = String.valueOf(editText.getText());
                builder.setMessage(dialogStr);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);

                AlertDialog alter = builder.create();
                alter.show();
                break;


            case R.id.checkbox:
                CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
                if (checkBox.isChecked())
                    checkBox.setText("항상켜기");
                else
                    checkBox.setText("항상 켜지않기");
                str = "체크박스를 눌렀습니다.";
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();


    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        Toast.makeText(getApplicationContext(), "밝기가 변경되었습니다.", Toast.LENGTH_LONG).show();

        String str = String.valueOf(progress);
        EditText textField = (EditText) findViewById(R.id.edittext);
        textField.setText(str);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
