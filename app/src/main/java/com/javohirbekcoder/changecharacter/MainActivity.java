package com.javohirbekcoder.changecharacter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.javohirbekcoder.changecharacter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    boolean[] drinks = new boolean[4];
    boolean isDrink = false;
    int allPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.orderImgBtn.setOnClickListener(v -> {
            for (boolean a : drinks) {
                if (a) {
                    isDrink = true;
                    break;
                } else
                    isDrink = false;
            }
            if (isDrink) {
                Toast.makeText(this, "Ordered ✅\n" + allPrice + " $ withdrawn!", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "You haven't chosen yet!", Toast.LENGTH_SHORT).show();
        });

        binding.layoutCola.setOnClickListener(v -> {
            if (binding.colaCheck.getVisibility() != View.VISIBLE) {
                binding.colaCheck.setVisibility(View.VISIBLE);
                drinks[0] = true;
                allPrice += 5;
                updatePrice();
            } else {
                binding.colaCheck.setVisibility(View.INVISIBLE);
                drinks[0] = false;
                allPrice -= 5;
                updatePrice();
            }
        });

        binding.layoutPepsi.setOnClickListener(v -> {
            if (binding.pepsiCheck.getVisibility() != View.VISIBLE) {
                binding.pepsiCheck.setVisibility(View.VISIBLE);
                drinks[1] = true;
                allPrice += 6;
                updatePrice();
            } else {
                binding.pepsiCheck.setVisibility(View.INVISIBLE);
                drinks[1] = false;
                allPrice -= 6;
                updatePrice();
            }
        });

        binding.layoutFanta.setOnClickListener(v -> {
            if (binding.fantaCheck.getVisibility() != View.VISIBLE) {
                binding.fantaCheck.setVisibility(View.VISIBLE);
                drinks[2] = true;
                allPrice += 7;
                updatePrice();
            } else {
                binding.fantaCheck.setVisibility(View.INVISIBLE);
                drinks[2] = false;
                allPrice -= 7;
                updatePrice();
            }
        });

        binding.layoutSprite.setOnClickListener(v -> {
            if (binding.spriteCheck.getVisibility() != View.VISIBLE){
                binding.spriteCheck.setVisibility(View.VISIBLE);
                drinks[3] = true;
                allPrice += 5;
                updatePrice();
            }
            else{
                binding.spriteCheck.setVisibility(View.INVISIBLE);
                drinks[3] = false;
                allPrice -= 5;
                updatePrice();
            }
        });

    }

    private void updatePrice() {
        binding.textPrice.setText("Price " + allPrice + " $" );
    }
}