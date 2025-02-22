package com.example.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        Button btnLesson1 = rootView.findViewById(R.id.btnLesson1);
        Button btnLesson2=rootView.findViewById(R.id.btnLesson2);
        Button btnLesson3=rootView.findViewById(R.id.btnLesson3);
        Button btnLesson4=rootView.findViewById(R.id.btnLesson4);
        Button btnLesson5=rootView.findViewById(R.id.btnLesson5);
        Button btnLesson6=rootView.findViewById(R.id.btnLesson6);
        Button btnLesson7=rootView.findViewById(R.id.btnLesson7);
        Button btnLesson8=rootView.findViewById(R.id.btnLesson8);

        final MediaPlayer mediaPlayer1=MediaPlayer.create(getActivity(),R.raw.variables);
        final MediaPlayer mediaPlayer2=MediaPlayer.create(getActivity(),R.raw.strings);
        final MediaPlayer mediaPlayer3=MediaPlayer.create(getActivity(),R.raw.conditions);
        final MediaPlayer mediaPlayer4=MediaPlayer.create(getActivity(),R.raw.loops);
        final MediaPlayer mediaPlayer5=MediaPlayer.create(getActivity(),R.raw.lists);
        final MediaPlayer mediaPlayer6=MediaPlayer.create(getActivity(),R.raw.diction);
        final MediaPlayer mediaPlayer7=MediaPlayer.create(getActivity(),R.raw.sets);
        final MediaPlayer mediaPlayer8=MediaPlayer.create(getActivity(),R.raw.lambda);



        btnLesson1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mediaPlayer1.start();
                Intent intent = new Intent(getActivity(), Lesson1.class);
                intent.putExtra("url", "https://www.learnpython.org/en/Variables_and_Types");
                startActivity(intent);
//                String url = "https://www.programiz.com/python-programming/online-compiler/";
//        WebView webView = (WebView)rootView.findViewById(R.id.webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl(url);
            }
        });

        btnLesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.start();
                Intent intent=new Intent(getActivity(),Lesson2.class);
                intent.putExtra("url2","https://www.learnpython.org/en/String_Formatting");
                //intent.putExtra("url", "https://www.learnpython.org/en/Conditions");
                startActivity(intent);
            }
        });

       btnLesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();
                Intent intent=new Intent(getActivity(),Lesson3.class);
                intent.putExtra("url3","https://www.learnpython.org/en/Conditions");
                //intent.putExtra("url", "https://www.learnpython.org/en/Conditions");
                startActivity(intent);
            }
        });

        btnLesson4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer4.start();
                Intent intent=new Intent(getActivity(),Lesson4.class);
                intent.putExtra("url4","https://www.learnpython.org/en/Loops");
                //intent.putExtra("url", "https://www.learnpython.org/en/Conditions");
                startActivity(intent);
            }
        });


        btnLesson5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer5.start();
                Intent intent=new Intent(getActivity(),Lesson5.class);
                intent.putExtra("url5","https://www.learnpython.org/en/Lists");

                startActivity(intent);
            }
        });

        btnLesson6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer6.start();
                Intent intent=new Intent(getActivity(),Lesson6.class);
                intent.putExtra("url6","https://www.learnpython.org/en/Dictionaries");

                startActivity(intent);
            }
        });

        btnLesson7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer7.start();
                Intent intent=new Intent(getActivity(),Lesson7.class);
                intent.putExtra("url7","https://www.learnpython.org/en/Sets");

                startActivity(intent);
            }
        });

        btnLesson8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer8.start();
                Intent intent=new Intent(getActivity(),Lesson7.class);
                intent.putExtra("url8","https://www.learnpython.org/en/Lambda_functions");

                startActivity(intent);
            }
        });





        return rootView;
    }




}