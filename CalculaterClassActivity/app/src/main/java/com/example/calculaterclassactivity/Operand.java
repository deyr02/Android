package com.example.calculaterclassactivity;

public class Operand {
    private  String _value = "0";
    private  Boolean _isDecimal = false;
    public Operand(String num, Boolean isDecimal){
         this._value = num;
         this._isDecimal = isDecimal;
    }
    public  String getStringValue()
    {
        return _value;
    }
    public Double getDecimalValue() throws Exception {
        try{
            return Double.parseDouble(_value);
        }
        catch (Exception ex){
           throw new Exception("Unable to convert");
        }
    }


    public  void setValue( String num)
    {
        _value= num;
    }


    public  Boolean IsDecimal(){
        return  _isDecimal;
    }
    public void setDecimal(boolean value){
        _isDecimal = value;
    }
}
