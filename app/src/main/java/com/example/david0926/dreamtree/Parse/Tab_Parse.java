package com.example.david0926.dreamtree.Parse;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david0926.dreamtree.Dialog_Parse;
import com.example.david0926.dreamtree.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tab_Parse extends android.support.v4.app.Fragment{

    public static Tab_Parse newInstance(){
        Tab_Parse fragment = new Tab_Parse();
        return fragment;
    }

    RecyclerView rcv;
    RecycleAdapter_Parse rcvAdap;
    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<String> nameList = new ArrayList<String>();

    String body="";
    String auth="";

    Elements b,a;
    Document doc=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_parse, container, false);

        rcv = v.findViewById(R.id.parse_recycler);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(lm);
        rcvAdap = new RecycleAdapter_Parse();
        rcv.setAdapter(rcvAdap);

        //parse



        //example text
        wordList.add("처음에는, 당신이 원하는 곳으로 갈 수는 없겠지만, 당신이 지금 있는 곳에서 출발할 수는 있을 것이다.");
        nameList.add("Unknown");
        wordList.add("새로운 목표를 세우거나, 새로운 삶의 꿈을 꾸기 위해, 결코 늦은 때란 존재하지 않는다.");
        nameList.add("C. S. Lucis");
        wordList.add("천리 길도 한 걸음부터.");
        nameList.add("속담");
        wordList.add("당신이 두려워 하는 동굴 속에, 당신이 찾는 보물이 있다.");
        nameList.add("Joseph Cambel");
        wordList.add("모든 것이 상실되고, 다시 시작해야 한다는 것을 감히 선언할 용기가 있다면, 당신은 잃어버릴 것이 없다.");
        nameList.add("Hulio Corzatar");
        wordList.add("실패는 그저 더 지능적으로 다시 시작할 수 있는 기회일 뿐이다.");
        nameList.add("Henry Ford");
        wordList.add("아무도 과거로 돌아가서, 새로운 시작을 맞이할 수는 없지만, 누구나 오늘 새로이 시작할 수 있고 새로운 결말을 만들 수는 있다.");
        nameList.add("Maria Robinson");
        wordList.add("끝까지 도달하는 것이 결말을 의미하지는 않는다.");
        nameList.add("Pablo Alboran");
        wordList.add("지금으로부터 20년이 지난다면, 당신은 당신이 한 일보다는 ,당신이 하지 못한 일에 더 실망하게 될 것이다.");
        nameList.add("Mark Twain");


        RecycleModel_Parse model;

        for(int i=0;i<9;i++) {
            JsoupAs jsoupas = new JsoupAs();
            jsoupas.execute();
            model = new RecycleModel_Parse();
            model.setWord(wordList.get(i));
            model.setName("-"+nameList.get(i));
            rcvAdap.add(model);
            rcvAdap.notifyDataSetChanged();
        }

        RecycleClick_Parse.addTo(rcv).setOnItemClickListener(new RecycleClick_Parse.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(getContext(), Dialog_Parse.class);
                intent.putExtra("word", rcvAdap.getItems().get(position).getWord());
                intent.putExtra("name", rcvAdap.getItems().get(position).getName());
                startActivity(intent);
            }
        });




        return v;
    }

    private class JsoupAs extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        protected Void doInBackground(Void... params)
        {
            try{
                doc = Jsoup.connect("http://pding397.iptime.org/ran_quote.php").get();
                b = doc.select("div.body");
                a = doc.select("div.auth");
                for(Element e:b) {
                    body+=e.text()+"\n";
                }
                for(Element e:a) {
                    auth+=e.text()+"\n";
                }

            }

            catch(IOException e) {
                e.printStackTrace();
            }




            return null;
        }
        @Override
        protected void onPostExecute(Void result)
        {
            wordList.add(body);
            nameList.add(auth);
        }
    }
}
