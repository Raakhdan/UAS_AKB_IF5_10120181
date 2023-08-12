package com.example.UAS_AKB_IF5_10120181;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;


//Akhdan Rafly
//10120181
//IF-5
public class HomeFragment extends Fragment {

    Toolbar toolbar;
    private RecyclerView recyclerView;
    FloatingActionButton button;
    Adapter adapter;
    List<com.example.UAS_AKB_IF5_10120181.Note> notes;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private Button btnSignOut;

    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragment = new com.example.UAS_AKB_IF5_10120181.HomeFragment();


    }

    private final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.addBtn:
                        Intent i = new Intent(getActivity(), AddNoteActivity.class);
                        startActivity(i);
                        break;

                }
            }
        };


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.listOfNote);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        view.findViewById(R.id.addBtn).setOnClickListener(listener);
        toolbar = view.findViewById(R.id.toolbar);
        NoteDatabase db = new NoteDatabase(view.getContext());
        notes = db.getNotes();
        adapter = new Adapter(view.getContext(), notes);
        recyclerView.setAdapter(adapter);

//        view.findViewById(R.id.btnlogout).setOnClickListener(listener);
        auth = FirebaseAuth.getInstance();

        return view;

    }

}
// Akhdan Rafly
// 10120181
// IF-5