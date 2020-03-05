package com.example.certamen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button gen_numbers, add, sust, c, mult, div, par, primo;
    TextView firstNumber, secondNumber, op_type, result, es;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (TextView) findViewById(R.id.firstNumber);
        secondNumber = (TextView) findViewById(R.id.secondNumber);
        op_type = (TextView) findViewById(R.id.op_type);
        result = (TextView) findViewById(R.id.result);
        es = (TextView) findViewById(R.id.es);

        gen_numbers = (Button) findViewById(R.id.gen_numbers);
        add = (Button) findViewById(R.id.add);
        sust = (Button) findViewById(R.id.sust);
        c = (Button) findViewById(R.id.c);
        mult = (Button) findViewById(R.id.mult);
        div = (Button) findViewById(R.id.div);
        par = (Button) findViewById(R.id.par);
        primo = (Button) findViewById(R.id.primo);

        gen_numbers.setOnClickListener(this);
        add.setOnClickListener(this);
        sust.setOnClickListener(this);
        c.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);
        par.setOnClickListener(this);
        primo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gen_numbers:
                gen_numbers();
                break;

            case R.id.add:
                add();
                break;

            case R.id.sust:
                sust();
                break;

            case R.id.c:
                c();
                break;

            case R.id.mult:
                mult();
                break;

            case R.id.div:
                div();
                break;

            case R.id.par:
                par();
                break;

            case R.id.primo:
                primo();
                break;
        }
    }

    private void gen_numbers(){
        int random1 = (int)(Math.random()*100 + 1);
        int random2 = (int)(Math.random()*100 + 1);

        firstNumber.setText(Integer.toString(random1));
        secondNumber.setText(Integer.toString(random2));
    }

    private void c(){
        firstNumber.setText("");
        secondNumber.setText("");
        result.setText("");
        es.setText("");
    }

    private void add(){
        try{
            int number1 = Integer.parseInt(firstNumber.getText().toString());
            int number2 = Integer.parseInt(secondNumber.getText().toString());

            if(!firstNumber.getText().toString().equals("")) {
                result.setText(Integer.toString(number1 + number2));
            }
        }catch(Exception e){
            Log.d("Error", e.toString());
        }
    }

    private void sust(){
        try{
            int number1 = Integer.parseInt(firstNumber.getText().toString());
            int number2 = Integer.parseInt(secondNumber.getText().toString());

            if(!firstNumber.getText().toString().equals("")) {
                result.setText(Integer.toString(number1 - number2));
            }
        }catch(Exception e){
            Log.d("Error", e.toString());
        }
    }

    private void mult(){
        try{
            int number1 = Integer.parseInt(firstNumber.getText().toString());
            int number2 = Integer.parseInt(secondNumber.getText().toString());

            if(!firstNumber.getText().toString().equals("")) {
                result.setText(Integer.toString(number1 * number2));
            }
        }catch(Exception e){
            Log.d("Error", e.toString());
        }
    }

    private void div(){
        try{
            double number1 = Integer.parseInt(firstNumber.getText().toString());
            double number2 = Integer.parseInt(secondNumber.getText().toString());

            if(!firstNumber.getText().toString().equals("")) {
                result.setText(Double.toString(number1 / number2));
            }
        }catch(Exception e){
            Log.d("Error", e.toString());
        }
    }

    private void par(){
        try{
            int resultadoInt = Integer.parseInt(result.getText().toString());
            String resultadoString = result.getText().toString();

            if(!resultadoString.equals("")){
                if(resultadoInt % 2 == 0 && resultadoInt > 0 && resultadoInt != 0){
                    es.setText("ES PAR");
                }else{
                    es.setText("NO ES PAR");
                }
            }else{
                result.setText("ERROR!");
            }
        }catch(Exception e){
            if(es.getText().toString().equals("")){
                es.setText("ERROR!");
            }else{
                Log.d("Error", e.toString());
            }
        }
    }

    private void primo(){
        try{
            int resultadoInt = Integer.parseInt(result.getText().toString());
            String resultadoString = result.getText().toString();
            boolean esPrimo = true;
            if(resultadoInt <= 1 || resultadoString.equals("")){
                es.setText("NO ES PRIMO");
            }else{
                if(resultadoInt == 4 || resultadoInt == 6 || resultadoInt == 8 || resultadoInt == 9){
                    es.setText("ES PRIMO");
                }else{
                    if(resultadoInt % 2 == 0) esPrimo = false;
                    if(resultadoInt % 3 == 0) esPrimo = false;
                    if(resultadoInt % 4 == 0 ) esPrimo = false;
                    if(resultadoInt % 5 == 0) esPrimo = false;
                    if(resultadoInt % 6 == 0) esPrimo = false;
                    if(resultadoInt % 7 == 0) esPrimo = false;
                    if(resultadoInt % 8 == 0) esPrimo = false;
                    if(resultadoInt % 9 == 0) esPrimo = false;

                    if(esPrimo){
                        es.setText("ES PRIMO");
                    }else{
                        es.setText("NO ES PRIMO");
                    }
                }
            }
        }catch(Exception e){
            if(es.getText().toString().equals("")){
                es.setText("ERROR!");
            }else{
                Log.d("Error", e.toString());
            }
        }
    }
}
