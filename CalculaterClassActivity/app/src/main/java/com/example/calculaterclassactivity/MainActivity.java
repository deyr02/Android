package com.example.calculaterclassactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    TextView mainField;
    Operand [] operands= {new Operand("0", false), new Operand("0",false)};
    Boolean isDecimalNumber = false;
    int currentOperandIndex = 0;
    enum Operations
    {
        Add,
        Subtract,
        Multiplication,
        Divide,
        Modulus,
        Equal,
        None
    }
    Operations selectedOperation = Operations.None;
    Boolean isOperationSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainField = (TextView) findViewById(R.id.main_field);

    }

    public String getOperationSign()
    {
        String output = "";
        if(isOperationSelected){
            switch (selectedOperation)
            {
                case Add:
                    output = "+";
                    break;
                case Subtract:
                    output = "-";
                    break;
                case Multiplication:
                    output = "X";
                    break;
                case Divide:
                    output = "/";
                    break;
                case Modulus:
                    output = "%";
                    break;
                default:
                    output = "";
                    break;
            }
        }
        return output;
    }


    public void DisplayText()
    {
        String Output = ""+operands[0].getStringValue();
        if(isOperationSelected){
            Output += "\n" + getOperationSign() + "\n" + operands[1].getStringValue();
        }
        mainField.setText(Output);
    }

    public void performOperation()
    {
        if(isOperationSelected  && selectedOperation != Operations.None)
        {
            String output = "0";
            double result =0;
            try
            {
                switch (selectedOperation)
                {
                    case Add:
                        result = operands[0].getDecimalValue() + operands[1].getDecimalValue();
                        if(!operands[0].IsDecimal() && !operands[1].IsDecimal())
                        {
                           output  = "" + (int)result;
                        }
                        else
                        {
                           output = "" + result;
                        }
                        break;
                    case  Subtract:
                        result = operands[0].getDecimalValue() - operands[1].getDecimalValue();
                        if(!operands[0].IsDecimal() && !operands[1].IsDecimal())
                        {
                            output  = "" + (int)result;
                        }
                        else
                        {
                            output = "" + result;
                        }
                        break;
                    case Multiplication:
                        result = operands[0].getDecimalValue() * operands[1].getDecimalValue();
                        if(!operands[0].IsDecimal() && !operands[1].IsDecimal())
                        {
                            output  = "" + (int)result;
                        }
                        else
                        {
                            output = "" + result;
                        }
                        break;
                    case  Divide:
                        result = operands[0].getDecimalValue() / operands[1].getDecimalValue();
                        if(operands[0].getDecimalValue() % operands[1].getDecimalValue() == 0)
                        {
                            output  = "" + (int)result;
                        }
                        else
                        {
                            output = "" + result;
                        }
                        break;
                    case Modulus:
                        result = operands[0].getDecimalValue() % operands[1].getDecimalValue();
                        output = "" +(int) result;
                        break;
                }

                operands[0] = new Operand(output, false);
                operands[1]= new Operand("0", false);
                isOperationSelected = false;
                selectedOperation = Operations.None;
                currentOperandIndex =0;
                DisplayText();
            }
            catch (Exception ex)
            {
                Toast.makeText( this, ex.getMessage(), Toast.LENGTH_SHORT).show();

            }

        }
    }






    public  void btn_one(View x)
    {
        String num = "1";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();

    }


    public  void btn_two(View x)
    {
        String num ="2";
        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }


    public  void btn_three(View x)
    {
        String num ="3";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }


    public  void btn_four(View x)
    {
        String num ="4";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }


    public  void btn_five(View x)
    {
        String num ="5";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }


    public  void btn_six(View x)
    {
        String num ="6";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }


    public  void btn_seven(View x)
    {
        String num ="7";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }


    public  void btn_eight(View x)
    {
        String num ="8";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }


    public  void btn_nine(View x)
    {
        String num ="9";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }

    public  void btn_zero(View x)
    {
        String num ="0";

        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue(num);
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
        }
        DisplayText();
    }

    public void btn_decimalPoint(View x)
    {
        String num =".";
        String _currentOperandValue = operands[currentOperandIndex].getStringValue();
        if(selectedOperation != Operations.Equal)
        {
            if( _currentOperandValue == "0")
            {
                operands[currentOperandIndex].setValue("0.");
            }
            else
            {
                operands[currentOperandIndex].setValue(_currentOperandValue+ num);
            }
            operands[currentOperandIndex].setDecimal(true);
        }
        DisplayText();

    }


    public void btn_clear (View x)
    {
        operands[0] = new Operand("0",false);
        operands[1] = new Operand("0",false);
        currentOperandIndex = 0;
        selectedOperation = Operations.None;
        isOperationSelected = false;
        isDecimalNumber = false;
        DisplayText();

    }

    public void btn_clearEntry (View X)
    {

       if(operands[1].getStringValue() != "0"){
           operands[1] = new Operand("0", false);
           DisplayText();
           return;
       }
       if(operands[0].getStringValue() !="0"){
           operands[0]= new Operand("0", false);
           selectedOperation = Operations.None;
           DisplayText();
           return;
       }

    }

    public void btn_add(View x)
    {
        if(isOperationSelected)
        {
            performOperation();
            isOperationSelected = true;
            selectedOperation = Operations.Add;
            currentOperandIndex =1;
            DisplayText();

        }
        else {
            isOperationSelected = true;
            selectedOperation = Operations.Add;
            currentOperandIndex =1;
            DisplayText();
        }
    }

    public void btn_subtract(View x)
    {
        if(isOperationSelected)
        {
          performOperation();
            isOperationSelected = true;
            selectedOperation = Operations.Subtract;
            currentOperandIndex =1;
            DisplayText();
        }
        else {
            isOperationSelected = true;
            selectedOperation = Operations.Subtract;
            currentOperandIndex =1;
            DisplayText();
        }
    }

    public void btn_multiplication(View x)
    {
        if(isOperationSelected)
        {
          performOperation();
            isOperationSelected = true;
            selectedOperation = Operations.Multiplication;
            currentOperandIndex =1;
            DisplayText();
        }
        else {
            isOperationSelected = true;
            selectedOperation = Operations.Multiplication;
            currentOperandIndex =1;
            DisplayText();
        }
    }

    public void btn_divide(View x)
    {
        if(isOperationSelected)
        {
          performOperation();
            isOperationSelected = true;
            selectedOperation = Operations.Divide;
            currentOperandIndex =1;
            DisplayText();
        }
        else {
            isOperationSelected = true;
            selectedOperation = Operations.Divide;
            currentOperandIndex =1;
            DisplayText();
        }
    }
    public void btn_modulus(View x)
    {
        if(isOperationSelected)
        {
          performOperation();
            isOperationSelected = true;
            selectedOperation = Operations.Modulus;
            currentOperandIndex =1;
            DisplayText();
        }
        else {
            isOperationSelected = true;
            selectedOperation = Operations.Modulus;
            currentOperandIndex =1;
            DisplayText();
        }
    }

    public void  btn_equal (View x)
    {
        if(isOperationSelected){
            performOperation();
        }
        selectedOperation = Operations.Equal;
        DisplayText();
    }

    public  void  btn_backward(View x)
    {
        String currentValue = operands[currentOperandIndex].getStringValue();
        if(currentValue.length() > 0  && currentValue != "0")
        {
            currentValue = currentValue.substring(0, currentValue.length()-1);
            operands[currentOperandIndex].setValue(currentValue);
        }
        if(currentValue.length() == 0){
            operands[currentOperandIndex].setValue("0");

        }
        DisplayText();
    }


}