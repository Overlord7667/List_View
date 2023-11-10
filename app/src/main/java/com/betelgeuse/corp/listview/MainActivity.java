package com.betelgeuse.corp.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button addButton, updateButton;
    EditText enterText;
    ListView listView;
    //List<String> data;
    //ArrayAdapter<String> listAdapter;
//    GridView gridView;

    ArrayList<String> nameList = new ArrayList<>();
    ArrayAdapter ListAdapter;

    Integer indexValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data = new ArrayList<>();
        addButton = findViewById(R.id.enter);
        updateButton = findViewById(R.id.update);
        enterText = findViewById(R.id.textEdit);
        listView = findViewById(R.id.listItem);
//        gridView = findViewById(R.id.listItem);
//        String text = enterText.getText().toString();
//        String[] Array = {"Fruit", "Car", "Sports", "Travel"};
//        listAdapter = new ArrayAdapter<>(this, R.layout.item_res, data);
//        listView.setAdapter(listAdapter);



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                change = (String) ((TextView)view).getText();
////                enterText.setText(change);
////                Toast.makeText(MainActivity.this, ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        enterText.setOnKeyListener((v, keyCode, event) ->
//        {
//            if (event.getAction() == KeyEvent.ACTION_DOWN){
//                if (keyCode == KeyEvent.KEYCODE_ENTER){
//                    addItem();
//                    return true;
//                }
//            }
//            return false;
//        });
//        button.setOnClickListener(v ->{
//            addItem();
//        });

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//////                TextViewUpdateItem updater = new TextViewUpdateItem(textView1);
//////                updater.updateItem();
////                //change = "Hello World";
////                addItem();
////                Toast.makeText(MainActivity.this, change, Toast.LENGTH_SHORT).show();
//            }
//        });

        ListAdapter = new  ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(ListAdapter);

        //add item
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = enterText.getText().toString();
                nameList.add(value);
                ListAdapter.notifyDataSetChanged();
                enterText.setText("");
            }
        });

        //select item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String change = (String) ((TextView) view).getText();
                enterText.setText(change);
                indexValue = position;
            }
        });

        //update item
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = enterText.getText().toString();
                nameList.set(indexValue,value);
                ListAdapter.notifyDataSetChanged();
                enterText.setText("");
                Toast.makeText(MainActivity.this, "Record Updated", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.delete_ic)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this item?")
                        //yes
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                nameList.remove(position);
                                ListAdapter.notifyDataSetChanged();
                            }
                        })
                        //no
                        .setNegativeButton("NO", null)
                        .show();
                return false;
            }
        });
    }

//    public void addItem(){
//        String text = enterText.getText().toString();
//        if (!text.isEmpty()){
//            data.add(text);
//            //data.add(0, text);
//            listAdapter.notifyDataSetChanged();
//            enterText.setText("");
//        }
//    }

//    public interface UpdateItem{
////        void updateItem();
//    }

//    public class TextViewUpdateItem implements UpdateItem{
////        private TextView textView1;
////
////        public TextViewUpdateItem(TextView textView){
////            this.textView1 = textView;
////        }
////
////        @Override
////        public void updateItem() {
////            textView1.setText("");
////        }
//    }

}