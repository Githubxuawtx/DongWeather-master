<<<<<<< HEAD
<<<<<<< HEAD
package com.example.firstday;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private String[] mountainArray;
    ProgressBar progressBar;
    TextView resultView;
    EditText usernameView;
    private AlertDialog dig;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutdome);
        mountainArray = getResources().getStringArray(R.array.visit_place_array);
        initView();
    }

    private void initView() {
        RadioGroup rg = findViewById(R.id.visit_place_rg);
        resultView = (TextView) findViewById(R.id.result_name);
        usernameView = (EditText) findViewById(R.id.user_name);
        progressBar = findViewById(R.id.progressBar);
        Button plusView = (Button)findViewById(R.id.puls_view);
        Button substractView = (Button) findViewById(R.id.substract_view);
        Button submitView = (Button) findViewById(R.id.submit_view);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                int index = -1;
                if (i == R.id.place1) {
                    index = 0;
                } else if (i == R.id.place2) {
                    index = 1;
                } else if (i == R.id.place3) {
                    index = 2;
                } else if (i == R.id.place4) {
                    index = 3;
                }
                if (index >= 0 && index < mountainArray.length) {
                    showUIToast(mountainArray[index]);
                }
            }
        });

//        plusView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                int id = view.getId();
//                switch (id){
//                    case R.id.puls_view:
//                    updateProgressView(true);
//                    break;
//                  /*  case R.id.submit_view:
//                    onSubmitConfirm();
//                    *//*onSubmit();*//*
//                    break;*/
//                    case R.id.substract_view:
//                    updateProgressView(false);
//                    break;
//                    default:
//                    break;
//                }
//            }
//        });
        //注释的地方和下面这一行冲突了，上面这样是不用进行依赖OnclickListener，下面这种是依赖了OnClickListener之后使用的
        //使用.setOnClickListerer
        plusView.setOnClickListener(this);//这里调用的Onclick方法
        substractView.setOnClickListener(this);
        submitView.setOnClickListener(this);
   }

   private void updateProgressView(boolean plus) {
           int progress = progressBar.getProgress();
           if(plus){
               progress += 10;
               if(progress > 100){
                   progress = 100;
               }
           }else {
               progress -= 10;
               if(progress < 0){
                   progress = 0;
               }
           }
           progressBar.setProgress(progress);
    }
    @Override
    public void onClick(View view) {
        //这里有判断
        int id = view.getId();
        switch (id){
            case R.id.puls_view:
                updateProgressView(true);
                break;
                   case R.id.submit_view:
                    onSubmitConfirm();
                    onSubmit();
                    break;
            case R.id.substract_view:
                updateProgressView(false);
                break;
            default:
                break;
        }
    }

    private void onSubmit() {
        StringBuffer sb = new StringBuffer();
        sb.append("选择的兴趣爱好是： $[hobbies]");
        String username = usernameView.getText().toString();
        if(username != null && username.isEmpty()){
            sb.append("\n by" +usernameView.getText().toString());
        }
        resultView.setText((sb.toString()));
    }


    private void onSubmitConfirm() {
        AlertDialog dlg;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("普通对话框")        //设置对话框标题
                .setIcon(R.mipmap.ic_launcher)//设置对话框标题图标
                .setMessage("是否确定提交？")          //设置对话框的提示信息
            //添加“确定”按钮
        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onSubmit();
            }
        })
         //添加“取消”按钮
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dig = builder.create();
        dig.show();
    }
    private void showUIToast(final String info) {
        Toast.makeText(MainActivity.this, "您投票的景点是："+info,
                Toast.LENGTH_LONG).show();

   /*runOnUiThread(new Runnable() {
       @Override
       public void run() {
       }
   });*/
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
=======
=======
>>>>>>> f173405ede714da93af9ff830d4ea51bc578b80d
package com.example.firstday;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private String[] mountainArray;
    ProgressBar progressBar;
    TextView resultView;
    EditText usernameView;
    private AlertDialog dig;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutdome);
        mountainArray = getResources().getStringArray(R.array.visit_place_array);
        initView();
    }

    private void initView() {
        RadioGroup rg = findViewById(R.id.visit_place_rg);
        resultView = (TextView) findViewById(R.id.result_name);
        usernameView = (EditText) findViewById(R.id.user_name);
        progressBar = findViewById(R.id.progressBar);
        Button plusView = (Button)findViewById(R.id.puls_view);
        Button substractView = (Button) findViewById(R.id.substract_view);
        Button submitView = (Button) findViewById(R.id.submit_view);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                int index = -1;
                if (i == R.id.place1) {
                    index = 0;
                } else if (i == R.id.place2) {
                    index = 1;
                } else if (i == R.id.place3) {
                    index = 2;
                } else if (i == R.id.place4) {
                    index = 3;
                }
                if (index >= 0 && index < mountainArray.length) {
                    showUIToast(mountainArray[index]);
                }
            }
        });

//        plusView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                int id = view.getId();
//                switch (id){
//                    case R.id.puls_view:
//                    updateProgressView(true);
//                    break;
//                  /*  case R.id.submit_view:
//                    onSubmitConfirm();
//                    *//*onSubmit();*//*
//                    break;*/
//                    case R.id.substract_view:
//                    updateProgressView(false);
//                    break;
//                    default:
//                    break;
//                }
//            }
//        });
        //注释的地方和下面这一行冲突了，上面这样是不用进行依赖OnclickListener，下面这种是依赖了OnClickListener之后使用的
        //使用.setOnClickListerer
        plusView.setOnClickListener(this);//这里调用的Onclick方法
        substractView.setOnClickListener(this);
        submitView.setOnClickListener(this);
   }

   private void updateProgressView(boolean plus) {
           int progress = progressBar.getProgress();
           if(plus){
               progress += 10;
               if(progress > 100){
                   progress = 100;
               }
           }else {
               progress -= 10;
               if(progress < 0){
                   progress = 0;
               }
           }
           progressBar.setProgress(progress);
    }
    @Override
    public void onClick(View view) {
        //这里有判断
        int id = view.getId();
        switch (id){
            case R.id.puls_view:
                updateProgressView(true);
                break;
                   case R.id.submit_view:
                    onSubmitConfirm();
                    onSubmit();
                    break;
            case R.id.substract_view:
                updateProgressView(false);
                break;
            default:
                break;
        }
    }

    private void onSubmit() {
        StringBuffer sb = new StringBuffer();
        sb.append("选择的兴趣爱好是： $[hobbies]");
        String username = usernameView.getText().toString();
        if(username != null && username.isEmpty()){
            sb.append("\n by" +usernameView.getText().toString());
        }
        resultView.setText((sb.toString()));
    }


    private void onSubmitConfirm() {
        AlertDialog dlg;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("普通对话框")        //设置对话框标题
                .setIcon(R.mipmap.ic_launcher)//设置对话框标题图标
                .setMessage("是否确定提交？")          //设置对话框的提示信息
            //添加“确定”按钮
        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onSubmit();
            }
        })
         //添加“取消”按钮
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dig = builder.create();
        dig.show();
    }
    private void showUIToast(final String info) {
        Toast.makeText(MainActivity.this, "您投票的景点是："+info,
                Toast.LENGTH_LONG).show();

   /*runOnUiThread(new Runnable() {
       @Override
       public void run() {
       }
   });*/
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
<<<<<<< HEAD
>>>>>>> f173405ede714da93af9ff830d4ea51bc578b80d
=======
>>>>>>> f173405ede714da93af9ff830d4ea51bc578b80d
