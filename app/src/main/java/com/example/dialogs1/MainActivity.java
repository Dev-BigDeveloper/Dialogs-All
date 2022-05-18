package com.example.dialogs1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import com.example.dialogs1.databinding.ActivityMainBinding;
import com.example.dialogs1.databinding.CustomLayoutBinding;
import com.example.dialogs1.databinding.FragmentCustom2Binding;
import com.example.dialogs1.databinding.FragmentDialog2Binding;
import com.example.dialogs1.databinding.FragmentDialogLibraryBinding;
import com.example.dialogs1.fragments.MyDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.alertBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Bu yerda title yoziladi");
            builder.setMessage("bu yerda message yoziladi");

            builder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Negative buttonni bostingiz", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Positive buttoni boslidi", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNeutralButton("Neatral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Netral tugma bosildi", Toast.LENGTH_SHORT).show();
                }
            });


            builder.show();
        });

        binding.alertListBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String[] a = {"Java", "Kotlin", "Android", "Flutter", "IOS", "Desktop developer", "Web developer"};
            boolean[] b = {false, false, false, false, false, false, false};

            builder.setMultiChoiceItems(a, b, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(MainActivity.this, a[which], Toast.LENGTH_SHORT).show();
                    }
                }
            });

            builder.show();
        });

        binding.alertListSingleBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Jahon chempionatida  kim chenpion bo`ladi ?");

            String[] a = {"Angliya", "Portugaliya", "Ispaniya", "Germaniya", "O`zbekiston"};

            builder.setSingleChoiceItems(a, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, a[which], Toast.LENGTH_SHORT).show();
                }
            });

            builder.show();
        });

        binding.customBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            CustomLayoutBinding binding = CustomLayoutBinding.inflate(getLayoutInflater());
            builder.setView(binding.getRoot());
            AlertDialog alertDialog = builder.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            binding.errorBtn.setOnClickListener(v1 -> {
                Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            });
            alertDialog.show();
        });

        binding.fragmentDialog.setOnClickListener(v -> {
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            myDialogFragment.show(getSupportFragmentManager(),"dialog");
        });

        binding.dateBtn.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Toast.makeText(MainActivity.this, year + " : " + month + " : " + dayOfMonth, Toast.LENGTH_SHORT).show();
                }
            },2021,6,19);

            datePickerDialog.show();
        });

        binding.timeBtn.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Toast.makeText(MainActivity.this, hour + " : " + minute, Toast.LENGTH_SHORT).show();
                }
            },hour,minute,false);

            timePickerDialog.show();
        });

        binding.bottomBtn.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            FragmentDialog2Binding dialog2Binding = FragmentDialog2Binding.inflate(getLayoutInflater());
            bottomSheetDialog.setContentView(dialog2Binding.getRoot());
            bottomSheetDialog.show();
        });

        binding.snackbarBtn.setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(v,"This is Snackbar Dialog",Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Undo", Toast.LENGTH_SHORT).show();
                }
            });
            snackbar.show();
        });

        if (binding.customer1 != null) {
            binding.customer1.setOnClickListener(v -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                FragmentCustom2Binding binding = FragmentCustom2Binding.inflate(getLayoutInflater());
                builder.setView(binding.getRoot());
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                binding.cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "You click CANCEL button", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                binding.readyBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "You click READY button", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }

                });
                alertDialog.show();
            });
        }

        if (binding.customer2 != null) {
            binding.customer2.setOnClickListener(v -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                FragmentDialogLibraryBinding binding = FragmentDialogLibraryBinding.inflate(getLayoutInflater());
                builder.setView(binding.getRoot());
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                binding.okayBtn.setOnClickListener(v1 -> {
                    Toast.makeText(this, "You click OKEY", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                });

                binding.chanelBtn.setOnClickListener(v1 -> {
                    Toast.makeText(this, "You click cancel", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                });
                alertDialog.show();
            });
        }

    }
}