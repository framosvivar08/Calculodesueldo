package com.example.calculodesueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText txtHoras, txtDias,sueldob,vhoras,dscto;
    private CheckBox chbxPago, chbxDcto;
    private RadioGroup rgRedondeo;
    private RadioButton rbRedondeo, rbNoRedondeo;
    private Button btnLimpiar, btnCalcular;
    private TextView lbl_pago, lbl_dcto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHoras = (EditText)findViewById(R.id.txtHoras);
        txtDias = (EditText)findViewById(R.id.txtDias);
        sueldob = (EditText)findViewById(R.id.sueldob);
        vhoras = (EditText)findViewById(R.id.vhoras);
        dscto = (EditText)findViewById(R.id.dscto);
        chbxPago = (CheckBox)findViewById(R.id.chbxPago);
        chbxDcto = (CheckBox)findViewById(R.id.chbxDcto);
        rgRedondeo = (RadioGroup)findViewById(R.id.rgRedondeo);
        rbNoRedondeo = (RadioButton)findViewById(R.id.rbNoRedondeo);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        lbl_dcto = (TextView)findViewById(R.id.lbl_dcto);
        lbl_pago = (TextView)findViewById(R.id.lbl_pago);

    }

    public void calcular (View view){

        int horas = Integer.parseInt(txtHoras.getText().toString());
        int dias = Integer.parseInt(txtDias.getText().toString());
        int sbase = Integer.parseInt(sueldob.getText().toString());
        int vtime = Integer.parseInt(vhoras.getText().toString());
        int dcto = Integer.parseInt(dscto.getText().toString());
        int horas_mensuales = horas*dias;
        double pago = horas_mensuales*vtime;
        double descuento = dcto;
        double pagof = pago-descuento;

        if(chbxPago.isChecked() == true){
            lbl_pago.setText(String.valueOf(pagof));
        }
        if(chbxDcto.isChecked() == true && pago >1000){

            lbl_dcto.setText(String.valueOf(descuento));
        }
        if (rgRedondeo.getCheckedRadioButtonId() == R.id.rbRedondeo) {
            int pago_redondeo = (int)Math.round(pago);
            lbl_pago.setText(String.valueOf(pago_redondeo));
            int dcto_redondeo = (int)Math.round((descuento));
            lbl_dcto.setText(String.valueOf(dcto_redondeo));
        }


    }

    public void limpiar(View view){
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            txtDias.getText().clear();
            txtHoras.getText().clear();
            sueldob.getText().clear();
            vhoras.getText().clear();
            dscto.getText().clear();
            rgRedondeo.clearCheck();
            chbxDcto.toggle();
            chbxPago.toggle();
            lbl_dcto.setText("");
            lbl_pago.setText("");

        }
    });

    }
}
