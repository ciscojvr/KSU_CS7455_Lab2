package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup crustRadioGroup;

    CheckBox anchoviesCheckbox;
    CheckBox pineappleCheckbox;
    CheckBox garlicCheckBox;
    CheckBox okraCheckBox;

    RadioGroup toGoOrNotRadioGroup;

    SeekBar sizeSeekBar;

    TextView currentSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crustRadioGroup = (RadioGroup)findViewById(R.id.radioGroup_crust);

        anchoviesCheckbox = (CheckBox)findViewById(R.id.checkBox_anchovies);
        pineappleCheckbox = (CheckBox)findViewById(R.id.checkBox_pineapple);
        garlicCheckBox = (CheckBox)findViewById(R.id.checkBox_garlic);
        okraCheckBox = (CheckBox)findViewById(R.id.checkBox_okra);

        toGoOrNotRadioGroup = (RadioGroup)findViewById(R.id.radioGroup_toGoOrNot);

        sizeSeekBar = (SeekBar)findViewById(R.id.seekBar_size);

        currentSize = (TextView)findViewById(R.id.textView_inches);

        Double totalCost = 00.00;


        crustRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int currentId = crustRadioGroup.getCheckedRadioButtonId();
                RadioButton currentCrustRB = (RadioButton)findViewById(currentId);

                if (currentCrustRB.equals(R.id.radioButton_crispy)) {

                }
            }
        });


        anchoviesCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == anchoviesCheckbox && isChecked) {

                }
            }
        });

        pineappleCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == pineappleCheckbox && isChecked) {

                }
            }
        });

        garlicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == garlicCheckBox && isChecked) {

                }
            }
        });

        okraCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == okraCheckBox && isChecked) {

                }
            }
        });

        toGoOrNotRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int currentId = toGoOrNotRadioGroup.getCheckedRadioButtonId();
                RadioButton currentToGoOrNotRB = (RadioButton)findViewById(currentId);
            }
        });

        sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentSize.setText(progress + " in" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
