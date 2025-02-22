package com.example.app;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;

public class PlaygroundFragment extends Fragment {
    ViewFlipper v_flipper;
    public PlaygroundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_playground, container, false);
        //Button button = rootView.findViewById(R.id.button);

        ImageView idelogo=rootView.findViewById(R.id.idelogo);


        int images[]={R.drawable.c,R.drawable.java,R.drawable.kotlin,R.drawable.swift};

         v_flipper=rootView.findViewById(R.id.v_flipper);

        for(int i=0;i<images.length;i++){
            flipperImages(images[i]);
        }





        idelogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlaygroundActivity.class);
              //  intent.putExtra("url", "https://www.online-python.com/");
                intent.putExtra("url", "https://www.w3schools.com/python/trypython.asp?filename=demo_indentation");
                startActivity(intent);
            }
        });

        ImageView star0img = (ImageView) rootView.findViewById(R.id.star0ImageView);
        ImageView star1img = (ImageView) rootView.findViewById(R.id.star1ImageView);
        ImageView star2img = (ImageView) rootView.findViewById(R.id.star2ImageView);
        ImageView star3img = (ImageView) rootView.findViewById(R.id.star3ImageView);
        ImageView star4img = (ImageView) rootView.findViewById(R.id.star4ImageView);
        ImageView star5img = (ImageView) rootView.findViewById(R.id.star5ImageView);


        RadioButton star1,star2,star3,star4,star5;
        star1=rootView.findViewById(R.id.star1);
        star2=rootView.findViewById(R.id.star2);
        star3=rootView.findViewById(R.id.star3);
        star4=rootView.findViewById(R.id.star4);
        star5=rootView.findViewById(R.id.star5);

        RadioGroup radioGroup = rootView.findViewById(R.id.radiogroup);

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Animation 1");
                star0img.animate().alpha(0).setDuration(1000);
                star1img.animate().alpha(1).setDuration(1000);

                star2img.animate().alpha(0).setDuration(1000);
                star3img.animate().alpha(0).setDuration(1000);
                star4img.animate().alpha(0).setDuration(1000);
                star5img.animate().alpha(0).setDuration(1000);

            }
        });
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1img.animate().alpha(0).setDuration(1000);
                star2img.animate().alpha(1).setDuration(1000);

                star0img.animate().alpha(0).setDuration(1000);
                star3img.animate().alpha(0).setDuration(1000);
                star4img.animate().alpha(0).setDuration(1000);
                star5img.animate().alpha(0).setDuration(1000);
            }
        });
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star2img.animate().alpha(0).setDuration(1000);
                star3img.animate().alpha(1).setDuration(1000);

                star0img.animate().alpha(0).setDuration(1000);
                star1img.animate().alpha(0).setDuration(1000);
                star4img.animate().alpha(0).setDuration(1000);
                star5img.animate().alpha(0).setDuration(1000);
            }
        });
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star3img.animate().alpha(0).setDuration(1000);
                star4img.animate().alpha(1).setDuration(1000);

                star0img.animate().alpha(0).setDuration(1000);
                star1img.animate().alpha(0).setDuration(1000);
                star2img.animate().alpha(0).setDuration(1000);
                star5img.animate().alpha(0).setDuration(1000);
            }
        });
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star4img.animate().alpha(0).setDuration(1000);
                star5img.animate().alpha(1).setDuration(1000);

                star0img.animate().alpha(0).setDuration(1000);
                star1img.animate().alpha(0).setDuration(1000);
                star2img.animate().alpha(0).setDuration(1000);
                star3img.animate().alpha(0).setDuration(1000);
            }
        });



        radioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(view.getId());
                System.out.println("Hasan Basbous");
                if(star1.isChecked()){
                    System.out.println("Animation 1");
                    star0img.animate().alpha(0).setDuration(1000);
                    star1img.animate().alpha(1).setDuration(1000);

                    star2img.animate().alpha(0).setDuration(1000);
                    star3img.animate().alpha(0).setDuration(1000);
                    star4img.animate().alpha(0).setDuration(1000);
                    star5img.animate().alpha(0).setDuration(1000);


                }

                if(star2.isChecked()){
                    star1img.animate().alpha(0).setDuration(1000);
                    star2img.animate().alpha(1).setDuration(1000);

                    star0img.animate().alpha(0).setDuration(1000);
                    star3img.animate().alpha(0).setDuration(1000);
                    star4img.animate().alpha(0).setDuration(1000);
                    star5img.animate().alpha(0).setDuration(1000);


                }

                if(star3.isChecked()){
                    star2img.animate().alpha(0).setDuration(1000);
                    star3img.animate().alpha(1).setDuration(1000);

                    star0img.animate().alpha(0).setDuration(1000);
                    star1img.animate().alpha(0).setDuration(1000);
                    star4img.animate().alpha(0).setDuration(1000);
                    star5img.animate().alpha(0).setDuration(1000);
                }

                if(star4.isChecked()){
                    star3img.animate().alpha(0).setDuration(1000);
                    star4img.animate().alpha(1).setDuration(1000);

                    star0img.animate().alpha(0).setDuration(1000);
                    star1img.animate().alpha(0).setDuration(1000);
                    star2img.animate().alpha(0).setDuration(1000);
                    star5img.animate().alpha(0).setDuration(1000);
                }
                if(star5.isChecked()){
                    star4img.animate().alpha(0).setDuration(1000);
                    star5img.animate().alpha(1).setDuration(1000);

                    star0img.animate().alpha(0).setDuration(1000);
                    star1img.animate().alpha(0).setDuration(1000);
                    star2img.animate().alpha(0).setDuration(1000);
                    star3img.animate().alpha(0).setDuration(1000);
                }

            }
        });

        return rootView;
    }
    public void flipperImages(int image){
        ImageView imageView=new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);//4sec
        v_flipper.setAutoStart(true);
        //animation
        v_flipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
    }
}