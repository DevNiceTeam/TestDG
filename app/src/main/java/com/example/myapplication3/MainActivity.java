//package com.example.myapplication3;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.myapplication3.databinding.ActivityMainBinding;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.stream.Stream;
//
//public class MainActivity extends AppCompatActivity
//{
//    // Used to load the 'myapplication3' library on application startup.
//    static
//    {
//        System.loadLibrary("myapplication3");
//    }
//
//    private ActivityMainBinding binding;
//
//    EditText editText;
//    EditText editText2;
//    TextView tv;
//    ArrayList al = new ArrayList();
//    List<String> full = new ArrayList<>();
//    ArrayList<db> dbs = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        tv= binding.sampleText;
//        editText = (EditText)findViewById(R.id.editTextName);
//        editText2 = (EditText)findViewById(R.id.editTextTel);
//
//        for (String s: stringFromJNI())
//        {
//            Arrays.toString(getStrings(s));
//        }
//
//        for (String s: full)
//        {
//            tv.append(s + "\n");
//        }
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void onMyButtonClick(View view)
//    {
//        if (editText.getText().toString().equalsIgnoreCase("") || editText2.getText().toString().equalsIgnoreCase(""))
//        {
//            setToast("Введите Имя и нажмете Search");
//        }
//        else
//        {
//            Stream<String> stream = full.stream();
//            String[] res = stream.filter(strings -> strings.contains(editText.getText())).toArray(String[]::new);
//            System.out.println(Arrays.toString(res));
//            upd(Arrays.asList(res),true);
//        }
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void onMyButtonClickAdd(View view)
//    {
//
//        if (editText.getText().toString().equalsIgnoreCase("") || editText2.getText().toString().equalsIgnoreCase(""))
//        {
//            setToast("Введите Имя и телефон");
//        }
//        else
//        {
//            Stream<String> stream1 = full.stream();
//            String[] res = stream1.filter(strings -> strings.contains(editText.getText() + " : " +editText2.getText())).toArray(String[]::new);
//             Collections.addAll(full, editText.getText().toString(), editText2.getText().toString());
//            full.forEach( (s) -> System.out.println(s) );
//            System.out.println(Arrays.toString(res));
//            System.out.println(full);
//        }
//    }
//
//    void upd(List<String> l)
//    {
//        //tv.setText("");
//        for (String s: l)
//        {
//            tv.append(s + "\n");
//        }
//    }
//    void upd(List<String> l, boolean b)
//    {
//        if (b==true)
//        {
//            tv.setText("");
//            for (String s: l)
//            {
//                tv.append(s + "\n");
//            }
//        }
//        else
//        {
//            for (String s: l)
//            {
//                tv.append(s + "\n");
//            }
//        }
//    }
//
//    public String[] getStrings(String str)
//    {
//        if (str == null)
//        {
//            return null;
//        }
//        StringTokenizer tok = new StringTokenizer(str, ": ");
//        List<String> values = new ArrayList<>();
//
//        while (tok.hasMoreTokens())
//        {
//            values.add(tok.nextToken());
//        }
//
//        full.add(String.valueOf(values));
//        return values.toArray(new String[values.size()]);
//    }
//
//    void setToast(String txt)
//    {
//        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
//    }
//
//    String getToast(String txt)
//    {
//        Toast.makeText(this,txt, Toast.LENGTH_SHORT).show();
//        return txt;
//    }
//    /**
//     * A native method that is implemented by the 'myapplication3' native library,
//     * which is packaged with this application.
//     */
//    public native String[] stringFromJNI();
//}

package com.example.myapplication3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication3.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity
{
    // Used to load the 'myapplication3' library on application startup.
    static
    {
        System.loadLibrary("myapplication3");
    }

    private ActivityMainBinding binding;

    EditText editText;
    EditText editText2;
    TextView tv;
    ArrayList<db> dbs = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tv= binding.sampleText;
        editText = (EditText)findViewById(R.id.editTextName);
        editText2 = (EditText)findViewById(R.id.editTextTel);

        for (String s: stringFromJNI())
        {
            tv.append(Arrays.toString(new ArrayList[]{getStrings(s)}) + "\n");
        }
        upd(true);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)  //Search//
    public void onMyButtonClick(View view)
    {
        //upd(true);
        if (editText.getText().toString().isEmpty()) // || editText.getText().equals() != List) //TODO: Сделать проверку)
        {
            setToast("Введите Имя и нажмете Search");
        }
        else
        {
            List<db> list2 = dbs.stream()                    //TODO: мб переделать не нравится фильтрь ну или реализовать свой Contains
                    .filter(e -> e.getName().contains(editText.getText()))
                    .collect(Collectors.toList());
            dbs.stream()
                    .filter(e -> e.getName().contains(editText.getText()))
                    .forEach(e -> {
                        tv.append(list2 + "\n");
                        System.out.println(e);
                    });
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onMyButtonClickAdd(View view) //add//
    {
        upd(true);
        if (editText.getText().toString().isEmpty() || editText2.getText().toString().isEmpty())
        {
            setToast("Введите Имя и телефон");
        }
        else
        {
            dbs.add(new db(editText.getText().toString(),editText2.getText().toString()));
            upd(dbs,false);
            System.out.println(dbs);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onMyButtonClickDel(View view) //add//
    {
        upd(dbs,true);
        if (editText.getText().toString().isEmpty())
        {
            setToast("Введите Имя");
        }
        else
        {

            List<db> list2 = new ArrayList<db>();
            dbs.removeIf(e -> list2.contains(editText.getText().toString()));
        }
    }
//
//    public void onMyButtonClickMobileInfo(View view) //add//
//    {
//
//    }

    void upd(boolean b)
    {
        if (b== true)
        tv.setText("");
    }
    void upd(ArrayList<db> l)
    {
        for (db s: l)
        {
            tv.append(s + "\n");
        }
    }
    void upd(ArrayList<db> l, boolean b)
    {
        if (b==true)
        {
            tv.setText("");
            for (db s: l)
            {
                tv.append(s + "\n");
            }
        }
        else
        {
            for (db s: l)
            {
                tv.append(s + "\n");
            }
        }
    }
    void upd(ArrayList<db> l, boolean b, boolean hardres)
    {
        if (b==true)
        {
            if (hardres == true)
            {
                tv.setText("");
            }
            for (db s: l)
            {
                tv.append(s + "\n");
            }
        }
        else
        {
            if (hardres == true)
            {
                tv.setText("");
            }
            for (db s: l)
            {
                tv.append(s + "\n");
            }
        }
    }

    public ArrayList<db> getStrings(String str)
    {
        if (str == null)
        {
            return null;
        }
        StringTokenizer tok = new StringTokenizer(str, "= ");

        while (tok.hasMoreTokens())
        {
            dbs.add(new db(tok.nextToken(),tok.nextToken()));
        }
        return dbs;
    }

    void setToast(String txt)
    {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }

    String getToast(String txt)
    {
        Toast.makeText(this,txt, Toast.LENGTH_SHORT).show();
        return txt;
    }
    public native String[] stringFromJNI();
}