package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Pizza customersPizza;

    RadioGroup crustRadioGroup;

    CheckBox anchoviesCheckbox;
    CheckBox pineappleCheckbox;
    CheckBox garlicCheckBox;
    CheckBox okraCheckBox;

    RadioGroup toGoOrNotRadioGroup;

    SeekBar sizeSeekBar;

    TextView currentSize;

    TextView finalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customersPizza = new Pizza();

        crustRadioGroup = findViewById(R.id.radioGroup_crust);

        anchoviesCheckbox = findViewById(R.id.checkBox_anchovies);
        pineappleCheckbox = findViewById(R.id.checkBox_pineapple);
        garlicCheckBox = findViewById(R.id.checkBox_garlic);
        okraCheckBox = findViewById(R.id.checkBox_okra);

        toGoOrNotRadioGroup = findViewById(R.id.radioGroup_toGoOrNot);

        sizeSeekBar = findViewById(R.id.seekBar_size);

        currentSize = findViewById(R.id.textView_inches);

        finalPrice = findViewById(R.id.textView_price);

        crustRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton_crispy:
                        customersPizza.setCrust_price(0);
//                        System.out.println("Crispy crust selected.");
                        break;
                    case R.id.radioButton_thick:
                        customersPizza.setCrust_price(2.50);
//                        System.out.println("Thick crust selected.");
                        break;
                    case R.id.radioButton_soggy:
                        customersPizza.setCrust_price(5.00);
//                        System.out.println("Soggy crust selected.");
                        break;
                    default:
                        System.out.println("id not found");
                }
                finalPrice.setText("$" + String.format("%.2f", calculateFinalTotal()));
            }
        });

        anchoviesCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == anchoviesCheckbox && isChecked) {
                    customersPizza.setTopping_count(customersPizza.getTopping_count() + 1);
//                    System.out.println("Anchovies checked.");
                } else {
                    customersPizza.setTopping_count(customersPizza.getTopping_count() -1);
//                    System.out.println("Anchovies unchecked.");
                }
                finalPrice.setText("$" + String.format("%.2f", calculateFinalTotal()));
            }
        });

        pineappleCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == pineappleCheckbox && isChecked) {
                    customersPizza.setTopping_count(customersPizza.getTopping_count() + 1);
//                    System.out.println("Pineapple checked.");
                } else {
                    customersPizza.setTopping_count(customersPizza.getTopping_count() - 1);
//                    System.out.println("Pineapple unchecked.");
                }
                finalPrice.setText("$" + String.format("%.2f", calculateFinalTotal()));
            }
        });

        garlicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == garlicCheckBox && isChecked) {
                    customersPizza.setTopping_count(customersPizza.getTopping_count() + 1);
//                    System.out.println("Garlic checked.");
                } else {
                    customersPizza.setTopping_count(customersPizza.getTopping_count() - 1);
//                    System.out.println("Garlic unchecked.");
                }
                finalPrice.setText("$" + String.format("%.2f", calculateFinalTotal()));
            }
        });

        okraCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == okraCheckBox && isChecked) {
                    customersPizza.setTopping_count(customersPizza.getTopping_count() + 1);
//                    System.out.println("Okra checked.");
                } else {
                    customersPizza.setTopping_count(customersPizza.getTopping_count() - 1);
//                    System.out.println("Okra unchecked.");
                }
                finalPrice.setText("$" + String.format("%.2f", calculateFinalTotal()));
            }
        });

        toGoOrNotRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton_atRestaurant:
                        customersPizza.setToGo_price(0);
//                        System.out.println("At restaurant selected.");
                        break;
                    case R.id.radioButton_pickup:
                        customersPizza.setToGo_price(0);
//                        System.out.println("Pickup selected.");
                        break;
                    case R.id.radioButton_deliver:
                        customersPizza.setToGo_price(3.0);
//                        System.out.println("Delivery selected.");
                        break;
                    default:
                        System.out.println("id not found");
                }
                finalPrice.setText("$" + String.format("%.2f", calculateFinalTotal()));
            }
        });

        sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentSize.setText(progress + " in" );

                customersPizza.setSize(progress);
//                System.out.println("Pizza size changed.");

                finalPrice.setText("$" + String.format("%.2f", calculateFinalTotal()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private double calculateFinalTotal() {
        double sizePrice = 0.05 * customersPizza.getSize();
        double toppingPrice = 0.05 * customersPizza.getTopping_count() * customersPizza.getSize();
        double crustPrice = customersPizza.getCrust_price();
        double deliveryPrice = customersPizza.getToGo_price();
        return sizePrice + toppingPrice + crustPrice + deliveryPrice;
    }
}
