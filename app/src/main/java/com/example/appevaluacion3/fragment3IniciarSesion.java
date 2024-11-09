package com.example.appevaluacion3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment3IniciarSesion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment3IniciarSesion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment3IniciarSesion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment3IniciarSesion.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment3IniciarSesion newInstance(String param1, String param2) {
        fragment3IniciarSesion fragment = new fragment3IniciarSesion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button btn_login;
    EditText txtUsuario;
    EditText txtPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3_iniciar_sesion, container, false);
        TextInputEditText correoElectronicoEditText = view.findViewById(R.id.correoElectronicoEditText);
        TextInputEditText contraseñaEditText= view.findViewById(R.id.contraseñaEditText);
        Button loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = correoElectronicoEditText.getText().toString();
                String contraseña = contraseñaEditText.getText().toString();

                // Verificar si el usuario y la contraseña se encuentran registrados
                if (usuario.equals("floppa@empresa.com") && contraseña.equals("superjuaquer")) {
                    // Abrir la cuenta "Admin"
                    boolean admin = true;
                }
                 else {
                    // Mostrar un mensaje de error
                    Toast.makeText(getActivity(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.fragment_fragment3_iniciar_sesion, container, false);

        btn_login = view.findViewById(R.id.loginButton);
        txtUsuario = view.findViewById(R.id.correoElectronicoEditText);
        txtPass = view.findViewById(R.id.contraseñaEditText);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtUsuario.getText().toString().equals("admin") && txtPass.getText().toString().equals("admin")){
                    Intent intent = new Intent(getActivity(), AdminActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Iniciando sesion como administrador.", Toast.LENGTH_SHORT).show();
                }else{
                    //logica para buscar usuario y verificar contraseña
                    Toast.makeText(getActivity(), "Iniciando sesion como usuario.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;

    }
}