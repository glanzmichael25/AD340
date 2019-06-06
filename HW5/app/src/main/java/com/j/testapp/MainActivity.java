package com.j.testapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declare book array]
    private String[] array = new String[]{"The Hobbit","A Song of Ice and Fire","The Signature of All Things",
            "The Hitchhiker's Guide to the Galaxy","The Miracle of Mindfulness"};

    //declare variables
    private Button button;
    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton checkedRadioButton;
    private String bookType;
    private String bookTitle;
    private Spinner spinner;
    private EditText editTextQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //gets references
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.button_show_cost);
        button.setOnClickListener(this);

        textView = findViewById(R.id.cost);

        editTextQuantity = findViewById(R.id.edit_text_book_quantity);

        radioGroup = findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //verify that radio is chosen
                checkedRadioButton = findViewById(checkedId);
                bookType = checkedRadioButton.getText().toString();

            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                bookTitle = array[position];
            }
            //default selected
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        String text = editTextQuantity.getText().toString();

        try {
            int quantity = Integer.parseInt(text);
            Book book = new Book(bookTitle, bookType);

            TextView textView = findViewById(R.id.cost);

            textView.setText(" Book: " + book.getTitle()

                    + "\n Book Type: " + book.getoldbookOrNewbook()
                    + "\n Quantity: " + quantity
                    + "\n Cost: " + "$" + String.format("%.2f", book.cost(quantity)));


        } catch (NumberFormatException e) {

            Toast.makeText(getApplicationContext(), "Input required", Toast.LENGTH_SHORT).show();
        }

    }
}
