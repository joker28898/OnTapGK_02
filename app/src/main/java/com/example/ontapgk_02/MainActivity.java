package com.example.ontapgk_02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtMa, txtTen;
    RadioGroup radioGroup;
    Button btnNhap, btnLuu, btnXoa;
    ListView lv;
    ArrayList<Employeee> arrEmp = new ArrayList<Employeee>();
    ArrayAdapter<Employeee> adapter;
    Employeee emp = null;

    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        adapter = new ArrayAdapter<Employeee>(this, android.R.layout.simple_list_item_1, arrEmp);
        lv.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = txtMa.getText().toString();
                String ten = txtTen.getText().toString();
                int rad = radioGroup.getCheckedRadioButtonId();
                if (rad == R.id.radioButton_Full){
                    emp = new EmployeeFullTime();
                }
                else {
                    emp = new EmployeePartTime();
                }
                emp.setId(ma);
                emp.setName(ten);
                arrEmp.add(emp);
                adapter.notifyDataSetChanged();

                txtMa.setText("");
                txtTen.setText("");
                txtMa.requestFocus();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtMa.setText(arrEmp.get(i).getId());
                txtTen.setText(arrEmp.get(i).getName());
                if (arrEmp.get(i) instanceof EmployeeFullTime) {
                    radioGroup.check(R.id.radioButton_Full);
                } else {
                    radioGroup.check(R.id.radioButton_Part);
                }
                vitri = i;

            }
        });

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = txtMa.getText().toString();
                String ten = txtTen.getText().toString();
                int rad = radioGroup.getCheckedRadioButtonId();
                if (rad == R.id.radioButton_Full){
                    emp = new EmployeeFullTime();
                }
                else {
                    emp = new EmployeePartTime();
                }
                emp.setId(ma);
                emp.setName(ten);
                arrEmp.set(vitri , emp);
                adapter.notifyDataSetChanged();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               XacNhanXoa();
            }
        });
    }

    private void initView() {
        txtMa = findViewById(R.id.editText_Ma);
        txtTen = findViewById(R.id.editText_Ten);
        radioGroup = findViewById(R.id.radioGroup);
        btnNhap = findViewById(R.id.button_Nhap);
        btnLuu = findViewById(R.id.button_Luu);
        btnXoa = findViewById(R.id.button_Xoa);
        lv = findViewById(R.id.listview);


    }

    public void XacNhanXoa(){
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("Thông báo");
        alertdialog.setIcon(R.mipmap.ic_launcher);
        alertdialog.setMessage("Bạn có chắc muốn xóa không ?");
        alertdialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                arrEmp.remove(vitri);
                adapter.notifyDataSetChanged();
                txtMa.setText("");
                txtTen.setText("");
            }
        });
        alertdialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertdialog.show();
    }
}
