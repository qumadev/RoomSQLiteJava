package com.qumadev.roomsqlitejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsuarios = findViewById(R.id.tvUsuarios);

        List<Usuario> listaUsuarios;

        AppDatabase appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "dbPruebas"
        ).allowMainThreadQueries().build();

        //Insertando algunos usuarios
        appDatabase.daoUsuario().insertarUsuario(new Usuario("0001","Adrian Mamani","adrian@gmail.com"));
        appDatabase.daoUsuario().insertarUsuario(new Usuario("0002","Diego Quispe","diego@gmail.com"));
        appDatabase.daoUsuario().insertarUsuario(new Usuario("0003","Abel Rosales","abel@gmail.com"));

        //Obtener un registro en especifico
//        Usuario user = appDatabase.daoUsuario().obtenerUsuario("0001");
//        tvUsuarios.setText(user.usuario+", "+user.nombre+", "+user.correo+", ");

        //Actulizar un registro existente
//        appDatabase.daoUsuario().actualizarUsuario("0001","Fernando Mamani","fernando@gmail.com");

        //Eliminar un registro
//        appDatabase.daoUsuario().borrarUsuario("0001");

        //mostrar usuarios
        listaUsuarios = appDatabase.daoUsuario().obtenerUsuarios();
        String texto = "";
        for(int i=0;i<listaUsuarios.size();i++){
            texto =  texto + "Usuario "+(i+1)+" = "+listaUsuarios.get(i).usuario+", "+listaUsuarios.get(i).nombre+", "+listaUsuarios.get(i).correo+"\n";
        }
        tvUsuarios.setText(texto);

    }
}