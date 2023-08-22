package com.msaggik.weok;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float matMilk = 70;
    byte matMilkDiscount = 77;
    float eggs = 25;
    byte eggsDiscount = 37;
    float water = 53;
    byte watwerDiscount = 44;
    float bread = 19;
    float cola = 41;
    byte colarDiscount = 32;
    float account = 233;

    private float calculation() {
        float count = (matMilk * (100 - matMilkDiscount) + eggs * (100 - eggsDiscount)
                + water * (100 - watwerDiscount) + bread * (100)
                + cola * (100 - colarDiscount)) / 100;
        return count;
    }

    private boolean possibility() {
        if (calculation() <= account) {
            return true;
        } else {
            return false;
        }

    }
    private float balance() {
        if(possibility()) {
            return account - calculation();
        } else {
            return -1;
        }
    }
    private TextView possibilityOut;
    private TextView balanceOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);
        if (possibility()) {
            possibilityOut.setText("Имеется достаточно средств для покупки продуктов");
            balanceOut.setText("Остаток от покупки " + balance() + " рубли");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки продуктов");
            balanceOut.setText(" - ");
        }
    }
}