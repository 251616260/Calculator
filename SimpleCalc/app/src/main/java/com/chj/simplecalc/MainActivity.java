package com.chj.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button[] btnNum = new Button[10];
    Button btnPlus,btnMinus,btnMultiply,btnDivision,btnResult,btnClear,btnDelete;
    EditText editText;
    String num1="",num2="",operator="",expression="";
    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
    }

    private void setListener() {
        btnNum[0].setOnClickListener(v -> {
            if(!flag){
                num1+="0";
            }else{
                num2+="0";
            }
            expression+="0";
            editText.setText(expression);
        });
        btnNum[1].setOnClickListener(v -> {
            if(!flag){
                num1+="1";
            }else{
                num2+="1";
            }
            expression+="1";
            editText.setText(expression);
        });
        btnNum[2].setOnClickListener(v-> {
            if(!flag){
                num1+="2";
            } else{
                num2+="2";
            }
            expression+="2";
            editText.setText(expression);
        });
        btnNum[3].setOnClickListener(v-> {
                if(!flag){
                    num1+="3";
                }else{
                    num2+="3";
                }
                expression+="3";
                editText.setText(expression);
        });
        btnNum[4].setOnClickListener(v -> {
            if(!flag){
                num1+="4";
            }else{
                num2+="4";
            }
            expression+="4";
            editText.setText(expression);
        });
        btnNum[5].setOnClickListener(v -> {
            if(!flag){
                num1+="5";
            }else{
                num2+="5";
            }
            expression+="5";
            editText.setText(expression);
        });
        btnNum[6].setOnClickListener(v -> {
            if(!flag){
                num1+="6";
            }else{
                num2+="6";
            }
            expression+="6";
            editText.setText(expression);
        });
        btnNum[7].setOnClickListener(v -> {
            if(!flag){
                num1+="7";
            }else{
                num2+="7";
            }
            expression+="7";
            editText.setText(expression);
        });
        btnNum[8].setOnClickListener(v -> {
            if(!flag){
                num1+="8";
            }else{
                num2+="8";
            }
            expression+="8";
            editText.setText(expression);
        });
        btnNum[9].setOnClickListener(v -> {
            if(!flag){
                num1+="9";
            }else{
                num2+="9";
            }
            expression+="9";
            editText.setText(expression);
        });
        btnPlus.setOnClickListener(v -> {
            operator+="+";
            expression+=operator;
            flag=true;
            editText.setText(expression);
        });
        btnMinus.setOnClickListener(v -> {
            operator+="-";
            expression+=operator;
            flag=true;
            editText.setText(expression);
        });
        btnMinus.setOnClickListener(v -> {
            operator+="-";
            expression+=operator;
            flag=true;
            editText.setText(expression);
        });
        btnMultiply.setOnClickListener(v -> {
            operator+="*";
            expression+=operator;
            flag=true;
            editText.setText(expression);
        });
        btnDivision.setOnClickListener(v -> {
            operator+="/";
            expression+=operator;
            flag=true;
            editText.setText(expression);
        });

        btnResult.setOnClickListener(v -> {
            switch (operator){
                case "+":add();break;
                case "-":minus();break;
                case "*":multiply();break;
                case "/":division();break;
            }
        });
        btnClear.setOnClickListener(v->{
            num1="";num2="";operator="";expression="";
            flag=false;
            editText.setText("");
        });
        btnDelete.setOnClickListener(v->{
            String s = expression.substring(expression.length() - 1);
            expression = expression.substring(0, expression.length() - 1);
            editText.setText(expression);
            if(!expression.contains("=")){
                if(!s.equals("=")) {
                    if (!s.equals(operator)) {
                        if (flag) {
                            if (!num2.equals(""))
                                num2 = num2.substring(0, num2.length() - 1);
                        } else {
                            if (!num1.equals(""))
                                num1 = num1.substring(0, num1.length() - 1);
                        }
                    } else {
                        operator = "";
                        flag = false;
                    }
                }
            }
        });
    }

    private void initView() {
        btnNum[0] = (Button)this.findViewById(R.id.num0);
        btnNum[1] = (Button)this.findViewById(R.id.num1);
        btnNum[2] = (Button)this.findViewById(R.id.num2);
        btnNum[3] = (Button)this.findViewById(R.id.num3);
        btnNum[4] = (Button)this.findViewById(R.id.num4);
        btnNum[5] = (Button)this.findViewById(R.id.num5);
        btnNum[6] = (Button)this.findViewById(R.id.num6);
        btnNum[7] = (Button)this.findViewById(R.id.num7);
        btnNum[8] = (Button)this.findViewById(R.id.num8);
        btnNum[9] = (Button)this.findViewById(R.id.num9);
        btnPlus=(Button)this.findViewById(R.id.plus);
        btnMinus=(Button)this.findViewById(R.id.minus);
        btnMultiply=(Button)this.findViewById(R.id.Multiply);
        btnDivision=(Button)this.findViewById(R.id.division);
        btnResult=(Button)this.findViewById(R.id.result);
        btnClear=(Button)this.findViewById(R.id.clear);
        btnDelete=(Button)this.findViewById(R.id.delete);
        editText =(EditText)this.findViewById(R.id.edit);
    }

    private void add() {
        int i = Integer.parseInt(num1);
        int j = Integer.parseInt(num2);
        String sum = String.valueOf(i + j);
        expression+="="+sum;
        editText.setText(expression);
    }
    private void minus() {
        int i = Integer.parseInt(num1);
        int j = Integer.parseInt(num2);
        String sum = String.valueOf(i - j);
        expression+="="+sum;
        editText.setText(expression);
    }
    private void division() {
        int i = Integer.parseInt(num1);
        int j = Integer.parseInt(num2);
        if(j==0) Toast.makeText(MainActivity.this,"除数不能为零",Toast.LENGTH_SHORT).show();
        else{
            String sum = String.valueOf(i / j);
            expression+="="+sum;
            editText.setText(expression);
        }
    }
    private void multiply() {
        int i = Integer.parseInt(num1);
        int j = Integer.parseInt(num2);
        String sum = String.valueOf(i * j);
        expression+="="+sum;
        editText.setText(expression);
    }
}