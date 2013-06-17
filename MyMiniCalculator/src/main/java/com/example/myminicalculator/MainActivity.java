package com.example.myminicalculator;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends Activity {
    private EditText text;
    private EditText showNumber;
    private float x;
    private float y;
    int operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
        showNumber = (EditText) findViewById(R.id.editText2);
    }

    // This method is called at button click because we assigned the name to the
    // "OnClick property" of the button
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button6: // Clear
                text.setText("");
                showNumber.setText("");
                return;
        }

        if (text.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number",
                    Toast.LENGTH_LONG).show();
            return;
        } else {
            switch (view.getId()) {
                case R.id.button: // +
                    x = Float.parseFloat(text.getText().toString());
                    operation = 1;
                    text.setText("");
                    break;
                case R.id.button2: // -
                    x = Float.parseFloat(text.getText().toString());
                    operation = 2;
                    text.setText("");
                    break;
                case R.id.button3: // *
                    x = Float.parseFloat(text.getText().toString());
                    operation = 3;
                    text.setText("");
                    break;
                case R.id.button4: // /
                    x = Float.parseFloat(text.getText().toString());
                    operation = 4;
                    text.setText("");
                    break;
                case R.id.button5: // =
                    y = Float.parseFloat(text.getText().toString());
                    text.setText("");
                    showNumber.setText(String.valueOf(calculate(x, y)));
                    break;
            }
        }
    }

    public float calculate(float x, float y) {
        switch (operation) {
            case 1:
                return (x+y);
            case 2:
                return (x-y);
            case 3:
                return (x*y);
            case 4:
                return (x/y);
        }
        return 0;
    }
}
