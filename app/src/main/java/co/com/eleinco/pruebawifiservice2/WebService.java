package co.com.eleinco.pruebawifiservice2;

import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpsTransportSE;

/**
 * Created by GERENCIA ELEINCO on 10/08/2016.
 */
public class WebService {

    private final String NAMESPACE = "http://www.w3schools.com/xml/";
    private final String URL = "http://www.w3schools.com/xml/tempconvert.asmx?op=CelsiusToFahrenheit";
    private final String SOAP_ACTION = "http://www.w3schools.com/xml/CelsiusToFahrenheit";
    private final String METHOD_NAME = "CelsiusToFahrenheit";

    private class TareaWSConsulta extends AsyncTask<String, Integer, Boolean>{

        protected Boolean doInBackground(String... params){
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            HttpsTransportSE transporte = new HttpsTransportSE(URL);

            try {
                transporte.call(SOAP_ACTION, envelope);
                SoapObject resSoap = (SoapObject)envelope.getResponse();
                
            }
        }
    }
}
