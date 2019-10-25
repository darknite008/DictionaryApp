package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private AutoCompleteTextView act;
private Button btn;
private TextView txtv;
private String[] dictionary={
        "Hello","definition- Salutation or Greeting. ",
        "Wow","definition- Used to express wonder.",
        "Android","definition- An automaton resembling a human being in shape and motions.",
        "Football","definition- Football is a family of team sports that involve, to varying degrees, kicking a ball to score a goal.",
        "Bottle","definition- A bottle is a narrow-necked container made of an impermeable material.",
        "Sun","definition- The Sun, or Sol, is the star at the center of the Solar System.",
        "War","definition- War is a state of armed conflict between states, governments, societies and informal paramilitary groups, such as mercenaries, insurgents and militias.",
        "Lust","definition- Lust is a craving, it can take any form such as the lust for sexuality, lust for money or the lust for power.",
        "Order","definition- An authoritative direction or instruction; command; mandate.",
        "Power","definition- Ability to act or produce an effect.",
        "God","definition- God is conceived of as the supreme being, creator deity, and principal object of faith.",
        "Home","definition- A home, or domicile, is a dwelling-place used as a permanent or semi-permanent residence for an individual, family, household or several families in a tribe.",
        "Nature","definition- Nature, in the broadest sense, is the natural, physical, or material world or universe.",
        "Disease","definition- Illness of people, animals, plants, etc., caused by infection or a failure of health.",
        "Life","definition- The quality that distinguishes a vital and functional being from a dead body."};


private Map<String,String> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act=findViewById(R.id.autoview);
        btn=findViewById(R.id.btnS);
        txtv=findViewById(R.id.tv);

        words=new HashMap<>();
                for (int i=0;i<dictionary.length;i+=2){
                words.put(dictionary[i],dictionary[i+1]);}

        final ArrayAdapter arrayAdapter=new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,
                 new ArrayList<String>(words.keySet()));
                 act.setAdapter(arrayAdapter);
                 act.setThreshold(1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = act.getText().toString();
                String capital=words.get(value);
                txtv.setText(String.valueOf(capital));
            }
        });
    }
}
