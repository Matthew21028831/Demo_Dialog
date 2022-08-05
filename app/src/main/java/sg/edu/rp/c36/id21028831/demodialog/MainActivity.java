package sg.edu.rp.c36.id21028831.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnExercise3;
    Button btnDemo4;
    Button btnDemo5;

    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvExercise3;
    TextView tvDemo4;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1=findViewById(R.id.buttonDemo1);
        btnDemo2=findViewById(R.id.buttonDemo2);
        btnDemo3=findViewById(R.id.buttonDemo3);
        btnExercise3=findViewById(R.id.buttonExercise3);
        btnDemo4=findViewById(R.id.buttonDemo4);
        btnDemo5=findViewById(R.id.buttonDemo5);

        tvDemo2=findViewById(R.id.textViewDemo2);
        tvDemo3=findViewById(R.id.textViewDemo3);
        tvExercise3=findViewById(R.id.textViewExercise3);
        tvDemo4=findViewById(R.id.textViewDemo4);
        tvDemo5=findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating the Dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Setting dialog details
//                myBuilder.setTitle("Demo 1-Simple Dialog");
//                myBuilder.setMessage("I can develop Android App");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("close", null);

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a single Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                //Configure the 'positive'' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected positive");
                    }
                });

                //Configure the 'negative' button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });

                //Configure the 'neutral' button
                myBuilder.setNeutralButton("cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);
                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3input, null);

                final EditText etInput1=viewDialog.findViewById(R.id.editTextNo1);
                final EditText etInput2=viewDialog.findViewById(R.id.editTextNo2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int number1=Integer.parseInt(etInput1.getText().toString());
                        int number2=Integer.parseInt(etInput2.getText().toString());
                        int sum=number1+number2;

                        tvExercise3.setText("The sum is " + sum);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: "+dayOfMonth+ "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                //Create the date picker dialog to show the current date when it first appears
                Calendar now=Calendar.getInstance();
                int year=now.get(Calendar.YEAR);
                int month=now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog=new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the listener to set the item
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time "+hourOfDay+": "+minute);
                    }
                };

                //Create the Time Picker dialog
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute

                TimePickerDialog myTimeDialog=new TimePickerDialog(MainActivity.this, myTimeListener, hourOfDay, minute, false);
                myTimeDialog.show();
            }
        });
    }
}