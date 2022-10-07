package com.example.sendmessagebinding.iu;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageApplication;
import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivitySendMessageBinding;

/**
 * <h1>Proyecto SendMessageBinding</h1>
 * En este proyecto aprenderemos a realizar las siguietes operaciones
 * <ol>
 *     <li>Crear un evento en un componente Button en codigo XML</li>
 *     <li>Crear un escuchador/listener del evento OnClick()</li>
 *     <li>El ciclo de vida de una Activity</li>
 *     <li>Manejar la pila de actividades</li>
 * </ol>
 *
 * @author Ciro León Espinosa
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */
public class SendMessageActivity extends AppCompatActivity {
    private static final String TAG = "SendMessageActivity";

    // private SendMessageClickListener delegate;
    private ActivitySendMessageBinding binding;

    /**
     * Método que se ejecuta cuando se rea la Activity.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Establecer el Listener OnClickListener al botón mediante una clase anónima
        //que implementa la interfaz View.OnClickListener
        // Usuario que ha iniciado sesión. DATO GLOBAL porque siempre se va a acceder a él mediante
        // método getApplication().getUser()
        binding.setMessage(new Message(((SendMessageApplication) getApplication()).getUser()));
        binding.btSend.setOnClickListener(view -> sendMessage());
        //Toast.makeText(SendMessageActivity.this, "Esto es un evento", Toast.LENGTH_SHORT).show());
        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }
    //region CICLO DE VIDA DE LA ACTIVITY

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }


    /**
     * Este método se ejecuta cuando se destruye la Activity.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }
    //endregion

    /**
     * Este método es el que se llama cuando se pulsa sobre el botón btSend definido en el XML android:onclick="sendMessage"
     * <code>android:onclick="sendMessage"</code>
     *
     * @param view
     */
    public void sendMessage(View view) {
        sendMessage();
    }

    public void sendMessage() {
        //TODO Se modificará este ejercicio para estudiar ViewBinding
        //Toast.makeText(this, "Hemos pulsado el botón", Toast.LENGTH_SHORT).show();
        //1. Crear el contenedor para añadir los datos
        Bundle bundle = new Bundle();
        //1.1 pasar dato a dato
        //bundle.putString("user",etUser.getText().toString());
        // bundle.putString("message",etMessage.getText().toString());
        //1.2 crear objeto

        bundle.putParcelable("message", binding.getMessage());
        //2. Vamos a crear el objeto intent explicitoa porque se conoce la actividad destino.
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);
        //3. Inicia la transición entre una vista y otra mediante startActivity
        startActivity(intent);
    }

    /**
     * Crea el menu de opciones en la vista. Se devuelve true para indicar al SO que se ha realizado la opcion de modificar el menu
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Este metodo callback
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_aboutus:
                //Toast.makeText(this, "Se ha pulsado sobre About us", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    /**
     * Esta clase no anonima implementa el listener que responde siempre al evento OnClick
     *
     class SendMessageClickListener implements View.OnClickListener {
    @Override public void onClick(View view) {
    //Toast.makeText(SendMessageActivity.this, "Esto es atraves de un delegado", Toast.LENGTH_SHORT).show();
    }
    }*/
}