package com.infideap.blockedittext;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BlockEditText amexEditText = findViewById(R.id.blockEditText_amex);
        amexEditText.setNumberOfBlock(3);
        amexEditText.setDefaultLength(4);
        amexEditText.setLengthAt(1,6);
        amexEditText.setLengthAt(2,5);
        amexEditText.setHint("Amex");
        amexEditText.setSeparatorCharacter('-');
        amexEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        amexEditText.setEdiTextBackground(ContextCompat.getDrawable(this, R.drawable.selector_edittext_round_border_line));

        amexEditText.setTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=amexEditText.getMaxLength()){
                    amexEditText.setBackgroundColor(Color.GREEN);
                }else
                    amexEditText.setBackgroundColor(Color.TRANSPARENT);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        BlockEditText cardEditText = findViewById(R.id.blockEditText_card);
        cardEditText.addCardPrefix(CardPrefix.amex(this));

        BlockEditText icNumberEditText = findViewById(R.id.blockEditText_ic_number);
        icNumberEditText.setNumberOfBlock(3);
        icNumberEditText.setDefaultLength(6);
        icNumberEditText.setLengthAt(1,2);
        icNumberEditText.setLengthAt(2,4);

        icNumberEditText.setSelection(0);
    }
}
