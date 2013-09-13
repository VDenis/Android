package com.example.temp1;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DatePickerFragment extends DialogFragment{
	
  private int selectedYear;
  public int getYear() {return selectedYear;}
  //private void setYear(int newProperty){year = newProperty;}
	
  private int  monthOfYear;
  public int getMonthOfYear() {return monthOfYear;}
  //private void setMonthOfYear(int newProperty){monthOfYear = newProperty;}
  
  private int dayOfMonth;
  public int getDayOfMonth() {return dayOfMonth;}
  //private void setDayOfMonth(int newProperty){dayOfMonth = newProperty;}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), (MainActivity)getActivity(), year, month, day);
    }

}
