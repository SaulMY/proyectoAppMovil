package com.example.appevaluacion3;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment2Opciones#newInstance} factory method to
 * create an instance of this fragment.
 */
class TextSizeUtility {

    // Utility method to change text size globally
    public static void changeTextSize(Activity activity, float change) {
        changeTextSizeForViewGroup((ViewGroup) activity.findViewById(android.R.id.content), change);
    }

    // Recursive method to traverse through all views and adjust text size for TextViews
    private static void changeTextSizeForViewGroup(ViewGroup viewGroup, float change) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                changeTextSizeForViewGroup((ViewGroup) child, change);
            } else if (child instanceof TextView) {
                TextView textView = (TextView) child;
                float currentTextSize = textView.getTextSize();
                float newTextSize = currentTextSize + change;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, newTextSize);
            }
        }
    }
}
public class fragment2Opciones extends Fragment {
    private ToggleButton modoOscuroBoton;
    private ViewGroup rootLayout;
    private float textSizeChange = 2.0f;
    private float baseTextSize;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment2Opciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment2OpcionesCliente.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment2Opciones newInstance(String param1, String param2) {
        fragment2Opciones fragment = new fragment2Opciones();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        View view = inflater.inflate(R.layout.fragment_fragment2_opciones,container,false);

        rootLayout = view.findViewById(R.id.rootLayout);

        Button aumentarBoton = view.findViewById(R.id.aumentarBoton);
        aumentarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextSizeUtility.changeTextSize(getActivity(), textSizeChange);
            }
        });

        Button disminuirBoton = view.findViewById(R.id.disminuirBoton);
        disminuirBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextSizeUtility.changeTextSize(getActivity(), -textSizeChange);
            }
        });

        baseTextSize = ((TextView) view.findViewById(R.id.tituloTextView)).getTextSize();

        modoOscuroBoton = view.findViewById(R.id.modoOscuroBoton);
        modoOscuroBoton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        modoOscuroBoton.setChecked(currentNightMode == Configuration.UI_MODE_NIGHT_YES);
        // Inflate the layout for this fragment
        return view;
    }


}