package com.curiousca.koolkalk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class KalkActivity extends Activity {

    TextView resultsView;

    public enum Operation{
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    String runningNumber = "";
    String leftValue = "";
    String rightValue = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalk);

        Button oneButton = (Button)findViewById(R.id.button1);
        Button twoButton = findViewById(R.id.button2);
        Button threeButton = findViewById(R.id.button3);
        Button fourButton = findViewById(R.id.button4);
        Button fiveButton = findViewById(R.id.button5);
        Button sixButton = findViewById(R.id.button6);
        Button sevenButton = findViewById(R.id.button7);
        Button eightButton = findViewById(R.id.button8);
        Button nineButton = findViewById(R.id.button9);
        Button zeroButton = findViewById(R.id.button0);
        Button decimalButton = findViewById(R.id.buttonDec);
        Button clearButton = findViewById(R.id.buttonClear);

        ImageButton equalsButton = findViewById(R.id.imageButtonEquals);
        ImageButton divideButton = findViewById(R.id.imageButtonDivide);
        ImageButton multiplyButton = findViewById(R.id.imageButtonMultiply);
        ImageButton subtractButton = findViewById(R.id.imageButtonMinus);
        ImageButton addButton = findViewById(R.id.imageButtonPlus);

        resultsView = findViewById(R.id.resultText);
        resultsView.setText("0");

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(1);
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(2);
                }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(4);
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(5);
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(6);
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(7);
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(8);
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(9);
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });
        decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftValue = "";
                rightValue = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultsView.setText("0");

            }
        });
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.EQUAL);
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVIDE);
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULTIPLY);
            }
        });
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUBTRACT);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });
    }

    void processOperation(Operation operation){
        if (currentOperation != null){
            if (runningNumber != ""){
                rightValue = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                }
                leftValue = String.valueOf(result);
                resultsView.setText(leftValue);
            }
        }else {
            leftValue = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;
        //resultsView.setText("0");

    }

    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultsView.setText(runningNumber);

    }
}
