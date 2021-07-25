package com.example.datetimepicker.ui.dialog;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    /* La interfaz DatePickerDialog.OnDateSetListener es la encargada de invocar el
        método onDateSet cada vez que una nueva fecha es seleccionada.
        Pero si el método está definido sobre el mismo DatePickerFragment no nos resulta muy útil.
        Nuestra intención es acceder a la fecha seleccionada desde nuestro fragment o activity
        (desde donde sea que estemos creando nuestro DatePickerFragment).
        Para lograr ello, lo que tenemos que hacer es definir el listener en la
        clase que hará uso del DatePickerFragment, mas no en el mismo DatePickerFragment.
     */

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        /* Create a new instance of DatePickerDialog and return it
        El listener (que escucha el evento de cambio de fecha) se
        está definiendo en nuestra clase DatePickerFragment.
        En el método onCreateDialog estamos devolviendo una instancia de DatePickerDialog,
        tal como aquí se muestra: */
        return new DatePickerDialog(getActivity(), this, year, month, day);

        /* El this que se usa como segundo parámetro es lo que hace que la misma clase sea la que
        tenga que actuar de listener, y es por eso que en la cabecera de nuestra clase
        nos encontramos con implements DatePickerDialog.OnDateSetListener.
        Entonces te estarás preguntando, ¿cómo hacemos que el listener se defina en la clase desde
        la que creamos el dialog?
        Para ello debemos crear el listener en la clase que invocará el dialog (sea un fragment o
        un activity, no hay problema). Y una vez creado, debemos pasar este listener a
        nuestro DialogFragment.  Para pasar el listener como parámetro a nuestro DialogFragment
        vamos a definir un método newInstance, que será el encargado de recibirlo.
        No podemos pasar el listener en el mismo constructor, porque no es seguro (y por tanto
        Android no lo permite).
        */
    }


    // Método onDateSet. Este método es invocado cada vez que el
    // usuario cambia la fecha en el DatePicker.
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
    }

}