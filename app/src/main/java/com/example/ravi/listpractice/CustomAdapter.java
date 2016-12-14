package com.example.ravi.listpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 08-12-2016.
 */
public class CustomAdapter  extends BaseAdapter
{

    List<Person> personArrayList =new ArrayList<>();
    Context Mcontext;
    LayoutInflater layoutInflater;

    public CustomAdapter(Context Mcontext, List<Person> personArrayList){
         this.Mcontext=Mcontext;
        this.personArrayList=personArrayList;

    }

    @Override
    public int getCount() {
        return personArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return personArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        if(layoutInflater == null){
            layoutInflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view == null){
            view =layoutInflater.inflate(R.layout.inflator_row_item,null);
        }


        Holder holder = new Holder();
        holder.id = (TextView) view.findViewById(R.id.id);
        holder.name = (TextView) view.findViewById(R.id.name);
        holder.email = (TextView) view.findViewById(R.id.email);
        holder.address = (TextView) view.findViewById(R.id.address);
        holder.gender = (TextView) view.findViewById(R.id.gender);

        Person person = personArrayList.get(i);

        holder.id.setText(person.getId());
         holder.name.setText(person.getName());
         holder.email.setText(person.getEmail());
         holder.address.setText(person.getAddress());
         holder.gender.setText(person.getGender());

        return view;
    }



    private class Holder {
        TextView id ,name,email,address,gender;

    }
}
