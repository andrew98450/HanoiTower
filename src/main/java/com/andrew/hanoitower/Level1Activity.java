package com.andrew.hanoitower;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import java.util.Stack;

public class Level1Activity extends AppCompatActivity {
    public static final int limit_count = 20;
    public static final int tower_count = 3;
    int count = 1;
    boolean is_push = false;
    String[] tower = { "=", "===", "=====" };
    String pole = "|";
    int tmp_tower = 0;
    int tmp_count = 0;
    int tmp_move = 0;
    Stack pole1_status = new Stack();
    Stack pole2_status = new Stack();
    Stack pole3_status = new Stack();
    Object[] tmp_arr;
    int[] tower_arr = { 3, 2, 1 };
    TextView count_txt,limitcount_txt;
    EditText pole1,pole2,pole3;
    CheckBox Checked;
    Button bt1,bt2,bt3;
    AlertDialog alertDialog;
    public void Init()
    {
        pole1_status.clear();
        pole2_status.clear();
        pole3_status.clear();
        pole1.setText("");
        pole2.setText("");
        pole3.setText("");
        count = 1;
        Checked.setChecked(false);
        is_push = false;
        count_txt.setText("搬移次數:");
        limitcount_txt.setText("限制搬移次數:");
        bt1.setEnabled(true);
        bt2.setEnabled(false);
        bt3.setEnabled(false);
        for (int i = 0; i < tower.length; i++)
        {
            pole1.append(tower[i] + "\r\n");
        }
        for (int i = 0; i < tower_arr.length; i++)
        {
            pole1_status.push(tower_arr[i]);
        }
        for (int i = 1; i <= 3; i++)
        {
            pole2.append(pole + "\r\n");
            pole3.append(pole + "\r\n");
        }
    }
    public void Pop(int move_pole)
    {
        switch (move_pole)
        {
            case 1:
                if (pole1_status.size() != 0)
                {
                    tmp_tower = Integer.parseInt(pole1_status.pop().toString());
                    tmp_count = tower_count - pole1_status.size();
                    tmp_arr = pole1_status.toArray();
                    StringBuilder str = new StringBuilder();
                    for(int i = 0; i < tmp_count; i++)
                    {
                        str.append(pole + "\r\n");
                    }
                    for (int i = tmp_arr.length - 1; i >= 0; i--)
                    {
                        str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                    }
                    pole1.setText(str.toString());
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("HanoiTower");
                    builder.setMessage("搬移失敗:河內塔是空的");
                    builder.setPositiveButton("Ok", null);
                    builder.show();
                    is_push = false;
                }
                break;
            case 2:
                if (pole2_status.size() != 0)
                {
                    tmp_tower = Integer.parseInt(pole2_status.pop().toString());
                    tmp_count = tower_count - pole2_status.size();
                    tmp_arr = pole2_status.toArray();
                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < tmp_count; i++)
                    {
                        str.append(pole + "\r\n");
                    }
                    for (int i = tmp_arr.length - 1; i >= 0; i--)
                    {
                       str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                    }
                    pole2.setText(str.toString());
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("HanoiTower");
                    builder.setMessage("搬移失敗:河內塔是空的");
                    builder.setPositiveButton("Ok", null);
                    builder.show();
                    is_push = false;
                }
                break;
            case 3:
                if (pole3_status.size() != 0)
                {
                    tmp_tower = Integer.parseInt(pole3_status.pop().toString());
                    tmp_count = tower_count - pole3_status.size();
                    tmp_arr = pole3_status.toArray();
                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < tmp_count; i++)
                    {
                        str.append(pole + "\r\n");
                    }
                    for (int i = tmp_arr.length - 1; i >= 0; i--)
                    {
                        str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                    }
                    pole3.setText(str.toString());
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("HanoiTower");
                    builder.setMessage("搬移失敗:河內塔是空的");
                    builder.setPositiveButton("Ok", null);
                    builder.show();
                    is_push = false;
                }
                break;
        }
    }
    public void Push(int to_pole, int move_pole)
    {
        switch (to_pole)
        {
            case 1:
                if (pole1_status.size() != 0)
                {
                    if (Integer.parseInt(pole1_status.peek().toString()) > tmp_tower)
                    {
                        pole1_status.push(tmp_tower);
                        tmp_count = tower_count - pole1_status.size();
                        tmp_arr = pole1_status.toArray();
                        StringBuilder str = new StringBuilder();
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str.append(pole + "\r\n");
                        }
                        for (int i = tmp_arr.length - 1; i >= 0; i--)
                        {
                            str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                        }
                        if (Checked.isChecked() == true)
                        {
                            count_txt.setText("搬移次數:" + String.valueOf(count++));
                        }
                        pole1.setText(str.toString());
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("HanoiTower");
                        builder.setMessage("搬移失敗:需要小的河內塔");
                        builder.setPositiveButton("Ok", null);
                        builder.show();
                        Push(move_pole, to_pole);
                    }
                }
                else
                {
                    pole1_status.push(tmp_tower);
                    tmp_count = tower_count - pole1_status.size();
                    tmp_arr = pole1_status.toArray();
                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < tmp_count; i++)
                    {
                        str.append(pole + "\r\n");
                    }
                    for (int i = tmp_arr.length - 1; i >= 0; i--)
                    {
                        str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                    }
                    if (Checked.isChecked() == true)
                    {
                        count_txt.setText("搬移次數:" + String.valueOf(count++));
                    }
                    pole1.setText(str.toString());
                }
                break;
            case 2:
                if (pole2_status.size() != 0)
                {
                    if (Integer.parseInt(pole2_status.peek().toString()) > tmp_tower)
                    {
                        pole2_status.push(tmp_tower);
                        tmp_count = tower_count - pole2_status.size();
                        tmp_arr = pole2_status.toArray();
                        StringBuilder str = new StringBuilder();
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str.append(pole + "\r\n");
                        }
                        for (int i = tmp_arr.length - 1; i >= 0; i--)
                        {
                            str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                        }
                        if (Checked.isChecked() == true)
                        {
                            count_txt.setText("搬移次數:" + String.valueOf(count++));
                        }
                        pole2.setText(str.toString());
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("HanoiTower");
                        builder.setMessage("搬移失敗:需要小的河內塔");
                        builder.setPositiveButton("Ok", null);
                        builder.show();
                        Push(move_pole, to_pole);
                    }
                }
                else
                {
                    pole2_status.push(tmp_tower);
                    tmp_count = tower_count - pole2_status.size();
                    tmp_arr = pole2_status.toArray();
                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < tmp_count; i++)
                    {
                        str.append(pole + "\r\n");
                    }
                    for (int i = tmp_arr.length - 1; i >= 0; i--)
                    {
                        str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                    }
                    if (Checked.isChecked() == true)
                    {
                        count_txt.setText("搬移次數:" + String.valueOf(count++));
                    }
                    pole2.setText(str.toString());
                }
                break;
            case 3:
                if (pole3_status.size() != 0)
                {
                    if (Integer.parseInt(pole3_status.peek().toString()) > tmp_tower)
                    {
                        pole3_status.push(tmp_tower);
                        tmp_count = tower_count - pole3_status.size();
                        tmp_arr = pole3_status.toArray();
                        StringBuilder str = new StringBuilder();
                        for (int i = 0; i < tmp_count; i++)
                        {
                            str.append(pole + "\r\n");
                        }
                        for (int i = tmp_arr.length - 1; i >= 0; i--)
                        {
                            str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                        }
                        if (Checked.isChecked() == true)
                        {
                            count_txt.setText("搬移次數:" + String.valueOf(count++));
                        }
                        pole3.setText(str.toString());
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("HanoiTower");
                        builder.setMessage("搬移失敗:需要小的河內塔");
                        builder.setPositiveButton("Ok", null);
                        builder.show();
                        Push(move_pole, to_pole);
                    }
                }
                else
                {
                    pole3_status.push(tmp_tower);
                    tmp_count = tower_count - pole3_status.size();
                    tmp_arr = pole3_status.toArray();
                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < tmp_count; i++)
                    {
                        str.append(pole + "\r\n");
                    }
                    for (int i = tmp_arr.length - 1; i >= 0; i--)
                    {
                        str.append(tower[Integer.parseInt(tmp_arr[i].toString()) - 1] + "\r\n");
                    }
                    if (Checked.isChecked() == true)
                    {
                        count_txt.setText("搬移次數:" + String.valueOf(count++));
                    }
                    pole3.setText(str.toString());
                }
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        count_txt = (TextView)findViewById(R.id.textView_count);
        limitcount_txt = (TextView)findViewById(R.id.textView_limitcount);
        pole1 = (EditText)findViewById(R.id.editText_pole1);
        pole2 = (EditText)findViewById(R.id.editText_pole2);
        pole3 = (EditText)findViewById(R.id.editText_pole3);
        Checked = (CheckBox)findViewById(R.id.checkbox_limit);
        bt1 = (Button)findViewById(R.id.button_1);
        bt2 = (Button)findViewById(R.id.button_2);
        bt3 = (Button)findViewById(R.id.button_3);
        pole1.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        pole1.setSingleLine(false);
        pole1.setHorizontallyScrolling(false);
        pole2.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        pole2.setSingleLine(false);
        pole2.setHorizontallyScrolling(false);
        pole3.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        pole3.setSingleLine(false);
        pole3.setHorizontallyScrolling(false);
        Init();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt1.setEnabled(false);
                bt2.setEnabled(true);
                bt3.setEnabled(true);
                if (is_push == true)
                {
                    is_push = false;
                    Push(1,tmp_move);
                }
                else
                {
                    is_push = true;
                    tmp_move = 1;
                    Pop(tmp_move);
                }
                if (count > limit_count)
                {
                    builder.setTitle("HanoiTower");
                    builder.setMessage("超過限制次數");
                    builder.setPositiveButton("Ok", null);
                    builder.show();
                    Init();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt1.setEnabled(true);
                bt2.setEnabled(false);
                bt3.setEnabled(true);
                if (is_push == true)
                {
                    is_push = false;
                    Push(2, tmp_move);
                }
                else
                {
                    is_push = true;
                    tmp_move = 2;
                    Pop(tmp_move);
                }
                if (count > limit_count)
                {
                    builder.setTitle("HanoiTower");
                    builder.setMessage("超過限制次數");
                    builder.setPositiveButton("Ok", null);
                    builder.show();
                    Init();
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt1.setEnabled(true);
                bt2.setEnabled(true);
                bt3.setEnabled(false);
                if (is_push == true)
                {
                    is_push = false;
                    Push(3,tmp_move);
                    if (pole3_status.size() == tower_count)
                    {
                        builder.setTitle("HanoiTower");
                        builder.setMessage("挑戰成功");
                        builder.setPositiveButton("Ok", null);
                        builder.show();
                        Init();
                    }
                }
                else
                {
                    is_push = true;
                    tmp_move = 3;
                    Pop(tmp_move);
                }
                if (count == limit_count)
                {
                    builder.setTitle("HanoiTower");
                    builder.setMessage("超過限制次數");
                    builder.setPositiveButton("Ok", null);
                    builder.show();
                    Init();
                }
            }
        });
        Checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true)
                {
                    limitcount_txt.setText("限制搬移次數:" + limit_count);
                }else {
                    limitcount_txt.setText("限制搬移次數:");
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_replay:
                Init();
                break;
            case R.id.item_exit:
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.level_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
