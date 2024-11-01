package com.example.formulirpendaftaran;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        RadioGroup radioGroup = findViewById(R.id.radioGroupGender);
        CheckBox checkBoxHobby1 = findViewById(R.id.checkBoxHobby1);
        CheckBox checkBoxHobby2 = findViewById(R.id.checkBoxHobby2);
        CheckBox checkBoxHobby3 = findViewById(R.id.checkBoxHobby3);
        CheckBox checkBoxHobby4 = findViewById(R.id.checkBoxHobby4);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String phone = editTextPhone.getText().toString();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                String gender = radioButton != null ? radioButton.getText().toString() : "Tidak Dipilih";

                StringBuilder hobbies = new StringBuilder();
                if (checkBoxHobby1.isChecked()) hobbies.append(checkBoxHobby1.getText()).append(", ");
                if (checkBoxHobby2.isChecked()) hobbies.append(checkBoxHobby2.getText()).append(", ");
                if (checkBoxHobby3.isChecked()) hobbies.append(checkBoxHobby3.getText()).append(", ");
                if (checkBoxHobby4.isChecked()) hobbies.append(checkBoxHobby4.getText()).append(", ");

                if (hobbies.length() > 0) {
                    hobbies.setLength(hobbies.length() - 2);
                } else {
                    hobbies.append("Tidak ada hobi dipilih");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Data Pendaftaran")
                        .setMessage("Nama: " + name +
                                "\nEmail: " + email +
                                "\nTelepon: " + phone +
                                "\nJenis Kelamin: " + gender +
                                "\nHobi: " + hobbies)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}
